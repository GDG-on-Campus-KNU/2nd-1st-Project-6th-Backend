package com.gathering.gdsc1stproject6th.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
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
public class Hashtag extends BaseEntity{

    //해시태그 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hashtagId;

    //해시태그 이름
    @Column(nullable = false)
    private String hashtagNm;

    //언급수
    @ColumnDefault("0")
    @Column(nullable = false)
    private Integer tagCount;

}
