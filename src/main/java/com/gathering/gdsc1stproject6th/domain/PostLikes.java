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
public class PostLikes {

    // 게시글찜 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postLikesId;

    // 게시글 번호
    @Column(nullable = true)
    private Long postId;

    // 회원 정보 (ID)
    @ManyToOne(optional = false) @JoinColumn(name = "userId")
    private User user;

}
