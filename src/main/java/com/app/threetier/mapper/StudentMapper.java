package com.app.threetier.mapper;

import com.app.threetier.domain.StudentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    public void insert(StudentVO studentVO);

    public List<StudentVO> selectAll();
}
