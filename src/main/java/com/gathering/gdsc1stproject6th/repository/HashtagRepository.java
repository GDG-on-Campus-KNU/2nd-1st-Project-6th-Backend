package com.gathering.gdsc1stproject6th.repository;

import com.gathering.gdsc1stproject6th.domain.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {

    Optional<Hashtag> findByHashtagNm(String hashtagName);

}
