package com.app.threetier.mapper;

import com.app.threetier.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    public void insert(MemberVO memberVO);
    public Optional<MemberVO> select(MemberVO memberVO);

//    회원탈퇴
    public void delete(Long id);
}
