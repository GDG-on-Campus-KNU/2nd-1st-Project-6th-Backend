package com.gathering.gdsc1stproject6th.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    // 카테고리 번호
    private Long categoryId;

    //카테고리 이름
    private String categoryNm;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;
}
