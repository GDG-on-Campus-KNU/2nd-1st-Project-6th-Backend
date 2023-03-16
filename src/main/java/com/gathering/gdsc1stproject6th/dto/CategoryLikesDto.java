package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryLikesDto {

    private Long categoryLikesId;

    private Long categoryId;

    private User user;

}
