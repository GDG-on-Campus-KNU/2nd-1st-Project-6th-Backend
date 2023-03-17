package com.gathering.gdsc1stproject6th.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Entity
public class Category extends BaseEntity{

    // 카테고리 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    //카테고리 이름
    @Column(nullable = false)
    private String categoryNm;

}
