package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TaskVO {
    private Integer num;
    private Integer kor;
    private Integer eng;
    private Integer math;
}
