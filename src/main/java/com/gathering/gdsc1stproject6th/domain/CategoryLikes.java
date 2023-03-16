package com.gathering.gdsc1stproject6th.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Entity
public class CategoryLikes {

    // 카테고리찜 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryLikesId;

    // 카테고리 번호
    @Column(nullable = true)
    private Long categoryId;

    // 회원 정보 (ID)
    @ManyToOne(optional = false) @JoinColumn(name = "userId")
    private User user;

    // 생성일자
    @Column(nullable = true)
    private LocalDateTime createAt;

    // 수정일자
    @Column(nullable = true)
    private LocalDateTime updateAt;

    // 삭제일자
    @Column(nullable = true)
    private LocalDateTime deleteAt;

}
