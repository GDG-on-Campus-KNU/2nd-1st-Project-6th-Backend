package com.gathering.gdsc1stproject6th.repository;

import com.gathering.gdsc1stproject6th.domain.PostHashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostHashtagRepository extends JpaRepository<PostHashtag, Long> {

    @Query("SELECT hashtag_id FROM post_hashtag")
    List<Long> findAllHashtagId();
}
