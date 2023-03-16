package com.gathering.gdsc1stproject6th.dto;

import com.gathering.gdsc1stproject6th.domain.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HashtagLikesDto {

    private Long hashtagLikesId;

    private Long hashtagId;

    private User user;

}
