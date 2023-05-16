package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    // 회원 번호
    private Long userId;

    // 권한
    private Long userLv;

    // 회원 이름
    private String userNm;

    // 회원 닉네임
    private String userNickname;

    // 회원 이메일
    private String userEmail;

    // 회원 전화번호
    private String userPhoneNumber;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;

    public User toEntity() {
        User user = User.builder()
                .userId(userId)
                .userLv(userLv)
                .userNm(userNm)
                .userNickname(userNickname)
                .userEmail(userEmail)
                .userPhoneNumber(userPhoneNumber)
                .build();

        return user;
    }

    public static UserDto from(User entity) {
        return new UserDto(
                entity.getUserId(),
                entity.getUserLv(),
                entity.getUserNm(),
                entity.getUserNickname(),
                entity.getUserEmail(),
                entity.getUserPhoneNumber(),
                entity.getCreatedAt(),
                entity.getUpdateAt(),
                entity.getDeleteAt()
        );
    }

}
