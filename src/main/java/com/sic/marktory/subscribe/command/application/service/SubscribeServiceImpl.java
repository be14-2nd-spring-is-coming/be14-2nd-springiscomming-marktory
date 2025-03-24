package com.sic.marktory.subscribe.command.application.service;

import com.sic.marktory.member.command.domain.repository.MemberRepository;
import com.sic.marktory.subscribe.command.domain.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("subscribeCommandService")
@RequiredArgsConstructor
public class SubscribeServiceImpl implements SubscribeService{

    private final SubscribeRepository subscribeRepository;
    private final MemberRepository memberRepository;
}
