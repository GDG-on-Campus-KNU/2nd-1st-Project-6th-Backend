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
public class MyTeam {

    //내모임 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myTeamId;

    //가입 상태
    @Enumerated(EnumType.STRING)
    private MyTeamStatus status;

    //게시글 번호
    @ManyToOne(optional = false) @JoinColumn(name = "postId")
    private Post post;

    //회원번호
    @ManyToOne(optional = false) @JoinColumn(name = "userId")
    private User user;

}
