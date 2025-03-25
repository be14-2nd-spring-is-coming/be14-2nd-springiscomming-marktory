package com.sic.marktory.member.command.application.service;

import com.sic.marktory.member.command.application.dto.EmailTokenDTO;
import com.sic.marktory.member.command.application.dto.EmailTokenVerifyDTO;
import com.sic.marktory.common.exception.TokenAlreadyVerifiedException;
import com.sic.marktory.common.exception.TokenExpiredException;
import com.sic.marktory.common.exception.TokenNotFoundException;

public interface MailService {

    public void sendVerificationEmail(EmailTokenDTO emailTokenDTO);
    public void registMailInfo(EmailTokenDTO emailTokenDTO);

    public void verifyToken(EmailTokenVerifyDTO emailTokenVerifyDTO) throws TokenNotFoundException, TokenExpiredException, TokenAlreadyVerifiedException;
}
