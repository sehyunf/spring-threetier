package com.app.threetier.controller;

import com.app.threetier.domain.CompanyVO;
import com.app.threetier.domain.ProductVO;
import com.app.threetier.domain.StudentVO;
import com.app.threetier.service.CompanyService;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TaskController {

    private final ProductService productService;
    private final StudentService studentService;
    private final DataSource getDataSource;
    private final CompanyService companyService;

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
        log.info("studentVO: {}", studentVO);
        studentService.register(studentVO);
        return new RedirectView("/student/result");
    }

    @GetMapping("/student/result")
    public void goTOlResultForm(Model model) {
        model.addAttribute("students", studentService.getStudents());
    }


//    3번실습
    @GetMapping("/company/check-in")
    public void goToCheckInForm(CompanyVO companyVO) {;}

    @GetMapping("/company/get-to-work")
    public void goToGetToWork() {;}

    @GetMapping("/company/leave-work")
    public void goToLeaveWork() {;}

    @GetMapping("/company/late")
    public void goToLate() {;}

    @GetMapping("/company/work")
    public void goToWork() {;}

//    날짜를 변환하는 법
    @PostMapping("/company/check-in")
    public RedirectView checkIn(CompanyVO companyVO, String flag) {
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("format: {}", format);

        int hours = now.getHour();
        int minutes = now.getMinute();

//        지각
        boolean lateCondition = hours >= 9 && minutes > 0;
//        퇴근
        boolean leaveWorkCondition = hours >= 17 && hours >= 0;

        if(flag.equals("getToWork")) {
            companyVO.setGetToWorkDateTime(format);
            log.info("{}", companyVO);
            companyService.register(companyVO);

//            출근 시간 초과 ? 지각 : 정시출근
            return new RedirectView(lateCondition ? "/company/late" : "/company/get-to-work");
        }

//         퇴근
        companyVO.setLeaveWorkDateTime(format);
        log.info("{}", companyVO);
        companyService.register(companyVO);

//        퇴근 시간이면 ? 퇴근 : 조퇴
        return new RedirectView(leaveWorkCondition ? "/company/leave-work" : "/company/work");

    }


}
