package com.app.threetier.controller;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.domain.StudentVO;
import com.app.threetier.service.ProductService;
import com.app.threetier.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.sql.DataSource;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TaskController {

    private final ProductService productService;
    private final StudentService studentService;
    private final DataSource getDataSource;

    @GetMapping("/product/write")
    public void goToWrite(Model model) {
        model.addAttribute("productVO", new ProductVO());
    }

    @PostMapping("/product/write")
    public RedirectView write(ProductVO productVO) {
        productService.write(productVO);
        return new RedirectView("/product/list");
    }

    @GetMapping("/product/list")
    public void goTOlList(Model model) {
        model.addAttribute("products", productService.getList());
    }

//    2번실습
    @GetMapping("/student/register")
    public void goToRegister(StudentVO studentVO) {;}

    @PostMapping("/student/register")
    public RedirectView register(StudentVO studentVO) {
        studentService.register(studentVO);
        return new RedirectView("/student/result");
    }

    @GetMapping("/student/result")
    public void goTOlResultForm(Model model) {
        model.addAttribute("students", studentService.getStudents());
    }


}
