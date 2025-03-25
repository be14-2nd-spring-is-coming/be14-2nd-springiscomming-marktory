package com.sic.marktory.member.command.application.controller;

import com.sic.marktory.member.command.application.dto.EmailTokenDTO;
import com.sic.marktory.member.command.application.dto.EmailTokenVerifyDTO;
import com.sic.marktory.member.command.application.dto.MemberDTO;
import com.sic.marktory.member.command.application.service.MailService;
import com.sic.marktory.member.command.application.service.MemberService;
import com.sic.marktory.member.command.domain.aggregate.vo.*;
import com.sic.marktory.member.common.exception.NickNameException;
import com.sic.marktory.member.common.exception.TokenAlreadyVerifiedException;
import com.sic.marktory.member.common.exception.TokenExpiredException;
import com.sic.marktory.member.common.exception.TokenNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Member Command", description = "가입, 로그인, 이메일 인증")
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final ModelMapper modelMapper;
    private MemberService memberService;
    private MailService mailService;
    private ModelMapper mapper;
    private Environment env;

    @Autowired
    public MemberController(MemberService memberService, MailService mailService , ModelMapper mapper, Environment env, ModelMapper modelMapper) {
        this.memberService = memberService;
        this.mailService = mailService;
        this.mapper = mapper;
        this.env = env;
        this.modelMapper = modelMapper;
    }

    /* 설명. 이메일 전송(API)
     *  흐름 -> 이메일 전송, 응답으로 토큰 값 전송, 토큰 값을 기준으로 프론트에서 요청-> 백엔드에서 요청 확인
     *  토큰값이 일치 시 -> 회원가입 폼으로 이동시켜 줌
    * */
    @Operation(
            summary = "이메일 토큰 발송",
            description = """
        회원가입을 위한 인증 이메일을 발송합니다.
        - 입력한 이메일 주소로 인증용 토큰이 포함된 이메일이 발송됩니다.
        - 응답으로 이메일 주소와 토큰이 함께 전달됩니다.
        - 프론트엔드에서는 이 토큰을 저장해두었다가 인증 요청 시 사용해야 합니다.
        """
    )
    @PostMapping("/signup-email")
    public ResponseEntity<ResponseEmailVO> postSignupEmail(@RequestBody RequestEmailVO email) {

        EmailTokenDTO emailTokenDTO = modelMapper.map(email, EmailTokenDTO.class);
        mailService.sendVerificationEmail(emailTokenDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseEmailVO(emailTokenDTO.getEmail(),
                        emailTokenDTO.getToken(),
                        "이메일이 전송되었습니다."));
    }

    /* 설명. 이메일 토큰 확인
     *  커스텀 예외를 사용해서, 발생시키기
    * */
    @Operation(
            summary = "이메일 인증 확인",
            description = """
        사용자가 이메일을 통해 받은 인증 토큰을 검증합니다.
        - 입력한 이메일 + 토큰 정보로 유효성을 확인합니다.
        - 유효하지 않은 토큰인 경우 404, 만료된 경우 410, 이미 인증된 경우 409 응답이 반환됩니다.
        - 정상적으로 인증되면 인증 완료 메시지를 반환합니다.
        """
    )
    @PostMapping("/signup-email/verification")
    public ResponseEntity<ResponseVerifyTokenVO> postEmailVerification(@RequestBody RequestVerifyTokenVO verifyMemberInfo) {

        EmailTokenVerifyDTO emailTokenVerifyDTO = mapper.map(verifyMemberInfo, EmailTokenVerifyDTO.class);
        emailTokenVerifyDTO.setToken(verifyMemberInfo.getToken());

        try {
            mailService.verifyToken(emailTokenVerifyDTO);
            ResponseVerifyTokenVO responseVerifyTokenVO =
                    new ResponseVerifyTokenVO("인증이 완료되었습니다.");
            return ResponseEntity.status(HttpStatus.OK).body(responseVerifyTokenVO);
        } catch (TokenNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResponseVerifyTokenVO(e.getMessage()));
        } catch (TokenExpiredException e) {
            return ResponseEntity
                    .status(HttpStatus.GONE)
                    .body(new  ResponseVerifyTokenVO(e.getMessage()));
        } catch (TokenAlreadyVerifiedException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ResponseVerifyTokenVO(e.getMessage()));
        }
    }

    /* 설명. 이메일 토큰 확인이 완료되었다? 회원가입 */
    @Operation(
            summary = "회원가입",
            description = """
        이메일 인증이 완료된 사용자가 회원가입을 진행합니다.
        - 필수 정보로 닉네임, 이메일, 비밀번호 등을 전달해야 합니다.
        - 닉네임 중복 시 409 CONFLICT 응답이 반환됩니다.
        - 성공 시 회원 가입 완료 메시지를 포함한 응답을 반환합니다.
        """
    )
    @PostMapping("signup")
    public ResponseEntity<?> postSingup(@RequestBody RequestSignupVO signupVO) {
        MemberDTO memberDTO = mapper.map(signupVO, MemberDTO.class);
        try {
            memberService.registMember(memberDTO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new ResponseSignupVO(memberDTO.getNickname(),
                            "회원가입이 완료되었습니다! 환영합니다!"));
        } catch (NickNameException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new NickNameException(e.getMessage()));
        }
    }
}
