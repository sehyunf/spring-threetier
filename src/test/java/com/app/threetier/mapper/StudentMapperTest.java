package com.app.threetier.mapper;

import com.app.threetier.domain.StudentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void insertTest() {
        StudentVO studentVO = new StudentVO();
        studentVO.setEng(70);
        studentVO.setKor(80);
        studentVO.setMath(90);
        studentMapper.insert(studentVO);
    }
}
