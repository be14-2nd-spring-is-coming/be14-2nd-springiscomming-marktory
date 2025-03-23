package com.sic.marktory.subscribe.query.service;

import com.sic.marktory.subscribe.query.dto.MemberDTO;
import com.sic.marktory.subscribe.query.mapper.SubscribeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    private final SubscribeMapper subscribeMapper;

    public SubscribeServiceImpl(SubscribeMapper subscribeMapper) {
        this.subscribeMapper = subscribeMapper;
    }

    @Override
    public List<MemberDTO> getSubscribedMembers(Long memberId) {
        return subscribeMapper.findSubscribedMembers(memberId);
    }

    @Override
    public List<MemberDTO> getSubscriberMembers(Long memberId) {
        return subscribeMapper.findSubscriberMembers(memberId);
    }
}