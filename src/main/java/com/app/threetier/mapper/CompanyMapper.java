package com.app.threetier.mapper;

import com.app.threetier.domain.CompanyVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {
    public void insert(CompanyVO companyVO);
}
