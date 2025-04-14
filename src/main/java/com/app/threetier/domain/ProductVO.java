package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {
    private Long id;
    private String productName;
    private Long productPrice;
    private Long productStock;
    private String productBrand;
//    검증할 때 null로 비교하기 위해서 int -> integer
//    클래스 타입의 기본 값 = null

}
