package com.app.threetier.service;

import com.app.threetier.domain.MemberVO;

import java.util.Optional;

public interface MemberService {
//    회원가입
    public void join(MemberVO memberVO);

//    로그인
    public Optional<MemberVO> login(MemberVO memberVO);

//    회원 탈퇴
    public void withdraw(Long id);

}
