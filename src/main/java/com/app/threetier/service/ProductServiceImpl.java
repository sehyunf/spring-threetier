package com.app.threetier.service;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService
{

    private final ProductDAO productDAO;

    @Override
    public void write(ProductVO productVO) {
        productDAO.insert(productVO);
    }

    @Override
    public List<ProductVO> getList() {
        return productDAO.selectAll();
    }

    @Override
    public void edit(ProductVO productVO) {
        productDAO.update(productVO);
    }
}
