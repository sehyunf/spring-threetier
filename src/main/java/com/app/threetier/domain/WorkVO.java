package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class WorkVO {
    Long id;
    String workName;
    String workTime;
}
