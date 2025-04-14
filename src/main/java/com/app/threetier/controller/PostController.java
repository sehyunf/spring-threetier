package com.app.threetier.controller;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.domain.PostVO;
import com.app.threetier.service.PostService;
import com.app.threetier.service.PostServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post/*")
public class PostController {

    private final PostService postService;
    private final HttpSession session;


    @GetMapping("list")
    public void goToList(Model model) {
        model.addAttribute("posts", postService.getList());
    }

//    게시물 한개 조회
    @GetMapping("read")
    public void goToRead(@RequestParam("id") Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id).orElseThrow(() -> new RuntimeException("post not found")));
    }

    @GetMapping("write")
    public void goToWrite(Model model) {
        model.addAttribute("postVO", new PostVO());
        model.addAttribute("memberId", ((MemberVO)session.getAttribute("member")).getId());
    }

    @PostMapping("write")
    public RedirectView write(PostVO postVO) {
        postService.write(postVO);
        return new RedirectView("/post/list");
    }

//    게시물 수정
    @GetMapping("edit")
    public void goToUpdate(@RequestParam("id") Long PostId, Model model) {
        Long MemberId = ((MemberVO)session.getAttribute("member")).getId();
        PostVO postVO = postService.getPostById(PostId).orElseThrow(() -> {
            throw new RuntimeException("post not found");
        });
        model.addAttribute("postVO", postVO);
        model.addAttribute("memberId", MemberId);
    }

    @PostMapping("edit")
    public RedirectView update(PostVO postVO) {
        log.info(postVO.toString());
        postService.edit(postVO);
        return new RedirectView("/post/list");
    }

    @GetMapping("remove")
    public RedirectView delete(@RequestParam("id") Long id) {
        postService.delete(id);
        return new RedirectView("/post/list");
    }

}
