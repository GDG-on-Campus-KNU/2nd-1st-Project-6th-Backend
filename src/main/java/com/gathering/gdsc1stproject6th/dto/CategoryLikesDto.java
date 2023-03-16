package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryLikesDto {

    private Long categoryLikesId;

    private Long categoryId;

    private User user;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;

}
