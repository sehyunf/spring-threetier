package com.app.threetier.service;

import com.app.threetier.domain.ProductVO;

import java.util.List;

public interface ProductService {

//    상품 등록
    public void write(ProductVO productVO);

    public List<ProductVO> getList();

    public void edit(ProductVO productVO);
}
