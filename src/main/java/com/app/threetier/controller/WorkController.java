package com.app.threetier.controller;

import com.app.threetier.domain.WorkVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/work/*")
public class WorkController {

    private final HttpSession session;

    @GetMapping("getToWork")
    public void goToGetToWork(Model model) {
        model.addAttribute("workVO", new WorkVO());
    }

    @PostMapping("getToWork")
    public RedirectView getToWork(WorkVO workVO) {

        Date now = new Date();
        SimpleDateFormat nowTime = new SimpleDateFormat("HH");

        log.info("{}", Integer.parseInt(nowTime.format(now)));

        if(Integer.parseInt(nowTime.format(now)) >= 9){
            return new RedirectView("/work/late");
        }else {
            return new RedirectView("/work/work");
        }
    }

    @GetMapping("work")
    public void goToWork(Model model, RedirectAttributes redirectAttributes) {;}

    @PostMapping("work")
    public RedirectView work(Model model, RedirectAttributes redirectAttributes) {
        Date now = new Date();
        SimpleDateFormat nowTime = new SimpleDateFormat("HH");

        log.info("{}", Integer.parseInt(nowTime.format(now)));

        if(Integer.parseInt(nowTime.format(now)) <= 17){
            redirectAttributes.addFlashAttribute("leave", false);
            return new RedirectView("/work/work");
        }else {
            return new RedirectView("/work/leaveWork");
        }
    }

    @GetMapping("late")
    public void late(Model model) {;}
}
