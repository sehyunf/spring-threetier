package com.app.threetier.controller;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    //    ex/ex01
    @GetMapping("ex01")
    public void ex01() {
        log.info("ex01 여기 실행됨!");
    };

//    ex/ex02?name=홍길동
    @GetMapping("ex02")
    public void ex02(String name, Model model) {
        log.info(name);
        model.addAttribute("name", name);
    }

//    이름과 나이를 화면으로 보내서, 이름, 나이, 만나이를 출력하기
    @GetMapping("ex03")
    public void ex03(@ModelAttribute("age") int age,@ModelAttribute("name") String name) {
        log.info("{}", age);
        log.info(name);
    }

    @GetMapping("ex04")
    public void ex04(@RequestParam("name") String name, @RequestParam("job") String job, Model model) {
        log.info(name);
        log.info(job);
        model.addAttribute("name", name);
        model.addAttribute("job", job);
    }

    @GetMapping("ex05")
    public void ex05(UserVO userVO) {
        log.info("{}", userVO.toString());
//        userVO.setAge(20);
//        userVO.setName("홍길동");
    }

//    상품 이름 가격 두개를 productVO로 생성한 후
//    화면에서 ex06으로 요청했을 때 log로 productVO로 출력하기
    @GetMapping("ex06")
    public void ex06(@ModelAttribute("productVO") ProductVO productVO) {
        log.info("{}", productVO.toString());
    }




}
