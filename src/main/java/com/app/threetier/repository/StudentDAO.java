package com.app.threetier.repository;

import com.app.threetier.domain.StudentVO;
import com.app.threetier.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentDAO {
    private StudentMapper studentMapper;

    public void save(StudentVO studentVO) {
        studentMapper.insert(studentVO);
    }

    public List<StudentVO> findAll() {
        return studentMapper.selectAll();
    }
}
