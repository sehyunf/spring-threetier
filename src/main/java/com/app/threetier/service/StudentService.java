package com.app.threetier.service;

import com.app.threetier.domain.StudentVO;

import java.util.List;

public interface StudentService {

    public void register(StudentVO studentVO);
    public List<StudentVO> getStudents();
}
