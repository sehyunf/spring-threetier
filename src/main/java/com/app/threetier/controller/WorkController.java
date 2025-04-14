package com.app.threetier.controller;

import com.app.threetier.domain.WorkVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/work/*")
public class WorkController {

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
    public void work(Model model) {;}

    @GetMapping("late")
    public void late(Model model) {;}
}
