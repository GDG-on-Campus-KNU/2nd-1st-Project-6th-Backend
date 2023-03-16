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
public class User {

    // 회원번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // 권한
    @Column(nullable = false)
    private Long userLv;

    // 회원 이름
    @Column(nullable = true)
    private String userNm;

    // 회원 닉네임
    @Column(nullable = true)
    private String userNickname;

    // 생성일자
    @Column(nullable = true)
    private LocalDateTime createAT;

    // 수정일자
    @Column(nullable = true)
    private LocalDateTime updateAt;

    // 삭제일자
    @Column(nullable = true)
    private LocalDateTime deleteAt;

}
