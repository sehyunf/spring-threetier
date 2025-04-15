package com.app.threetier.service;

import com.app.threetier.domain.CompanyVO;
import com.app.threetier.repository.CompanyDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDAO companyDAO;

    @Override
    public void register(CompanyVO companyVO) {
        companyDAO.save(companyVO);
    }
}
