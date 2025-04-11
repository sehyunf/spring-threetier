package com.app.threetier.mapper;

import com.app.threetier.domain.ProductVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
//    상품 입력
    public void insert(ProductVO productVO);

}
