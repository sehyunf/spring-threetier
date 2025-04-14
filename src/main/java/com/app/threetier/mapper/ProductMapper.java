package com.app.threetier.mapper;

import com.app.threetier.domain.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
//    상품 입력
    public void insert(ProductVO productVO);

//    상품 전체 조회
    public List<ProductVO> selectAll();

//    상품 수정
    public void update(ProductVO productVO);

}
