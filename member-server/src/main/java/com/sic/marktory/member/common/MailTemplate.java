package com.sic.marktory.member.common;

import org.springframework.stereotype.Component;

/* 설명. email-template (회원가입, 비밀번호 초기화) */
@Component
public class MailTemplate {
    public String sendSignUpEamil(String link) {
        return String.format("""
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="UTF-8">
                <title>이메일 인증</title>
            </head>
            <body style="font-family: Arial, sans-serif;">
                <div style="max-width: 600px; margin: auto; padding: 20px; background-color: #f9f9f9; border-radius: 10px;">
                    <h2 style="text-align: center;">Marktory 가입을 환영합니다!👋</h2>
                    <p style="text-align: center;">Marktory는 모든 사람들의 이야기를 기다립니다.</p>
                    <p style="text-align: center;">아래 버튼을 눌러 이메일 인증을 완료해주세요.</p>
                    <div style="margin-top: 30px; text-align: center;">
                        <a href="%s" style="display: inline-block; background-color: #4CAF50; color: white; padding: 12px 24px; border-radius: 6px; text-decoration: none;">
                            이메일 인증하기
                        </a>
                    </div>
                    <p style="margin-top: 20px; font-size: 12px; color: #888;">이 링크는 10분 뒤 만료됩니다.</p>
                </div>
            </body>
            </html>
            """, link);

    }
}
