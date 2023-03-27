package com.gathering.gdsc1stproject6th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<com.gathering.gdsc1stproject6th.domain.Post, Long> {
}
