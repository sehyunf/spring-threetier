package com.app.threetier.service;

import com.app.threetier.domain.StudentVO;
import com.app.threetier.repository.StudentDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Override
    public void register(StudentVO studentVO) {
        studentDAO.save(studentVO);
    }

    @Override
    public List<StudentVO> getStudents() {
        return studentDAO.findAll();
    }
}
