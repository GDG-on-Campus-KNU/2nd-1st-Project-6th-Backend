package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostLikesDto {

    private Long postLikesId;

    private Long postId;

    private User user;

}
