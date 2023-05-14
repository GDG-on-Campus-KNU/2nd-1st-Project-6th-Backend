package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.Category;
import com.gathering.gdsc1stproject6th.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long userId;

    private Long userLv;

    private String userNm;

    private String userNickname;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;

    public static UserDto from(User entity) {
        return new UserDto(
                entity.getUserId(),
                entity.getUserLv(),
                entity.getUserNm(),
                entity.getUserNickname(),
                entity.getCreateAt(),
                entity.getDeleteAt(),
                entity.getUpdateAt()
        );
    }

    public User toEntity() {
        User user = User.builder()
                .userId(userId)
                .userLv(userLv)
                .userNm(userNm)
                .userNickname(userNickname)
                .build();

        return user;
    }

}
