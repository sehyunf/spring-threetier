package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CompanyVO {
    private Long id;
    private String companyName;
    private String getToWorkDateTime;
    private String leaveWorkDateTime;
}
