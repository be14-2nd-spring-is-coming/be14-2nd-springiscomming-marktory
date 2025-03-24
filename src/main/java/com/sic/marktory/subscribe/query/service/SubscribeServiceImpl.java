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
    public List<MemberDTO> findSubscribedMembers(Long memberId) {
        return subscribeMapper.selectSubscribedMembers(memberId);
    }

    @Override
    public List<MemberDTO> findSubscriberMembers(Long memberId) {
        return subscribeMapper.selectSubscriberMembers(memberId);
    }
}