package com.app.threetier.controller;

import com.app.threetier.domain.TaskVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/task/*")
public class Task02Controller {

    private final HttpSession session;

    @GetMapping("/register")
    public void goToRegister(Model model) {
        model.addAttribute("taskVO", new TaskVO());
    }

    @PostMapping("/register")
    public RedirectView register(TaskVO taskVO) {
        taskVO.setNum(taskVO.getEng() + taskVO.getMath() + taskVO.getKor());
        session.setAttribute("taskVO", taskVO);
        return new RedirectView("/task/result");
    }

    @GetMapping("/result")
    public void goToResult(Model model) {
        model.addAttribute("taskVO", session.getAttribute("taskVO"));
    }


}
