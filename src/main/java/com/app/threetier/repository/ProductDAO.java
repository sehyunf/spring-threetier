package com.app.threetier.repository;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

//    상품 등록
    public void insert(ProductVO productVO) {
        productMapper.insert(productVO);
    }
}
