package com.remind.backend.service;

import com.remind.backend.model.Member;
import com.remind.backend.model.MemberJPARepo;
import com.remind.backend.model.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberJPARepo memberRepo;

    public Member getUserByEmail(String email){
        return memberRepo.findByEmail(email);
    }

    public Member signUp(MemberDto dto){
        Member newMem = new Member();
        newMem.setEmail(dto.getEmail());
        newMem.setPassword(dto.getPassword());
        return memberRepo.save(newMem);
    }

    public Member login(String email, String pw){
        // TODO: Login logic implement by JWT token
        return null;
    }
}
