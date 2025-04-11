package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class MemberVO implements Serializable {
    private Long id;
    private String MemberEmail;
    private String MemberPassword;
    private String MemberName;
}
