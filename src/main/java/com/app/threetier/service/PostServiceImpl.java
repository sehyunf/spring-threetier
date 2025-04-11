package com.app.threetier.service;

import com.app.threetier.domain.PostVO;
import com.app.threetier.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

//    전체조회
    @Override
    public List<PostVO> getList() {
        return postDAO.findAll();
    }

//    단일조회
    @Override
    public Optional<PostVO> getPostById(Long id) {
        return postDAO.findById(id);
    }

//    게시글 작성
    @Override
    public void write(PostVO postVO) {
        postDAO.save(postVO);
    }

    @Override
    public void edit(PostVO postVO) {
        postDAO.editById(postVO);
    }

    //    게시글 전체 삭제
    @Override
    public void deleteAll(Long memberId) {
        postDAO.deleteAllByMemberId(memberId);
    }

    @Override
    public void delete(Long Id) {
        postDAO.deleteById(Id);
    }
}
