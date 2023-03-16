package com.gathering.gdsc1stproject6th.repository;

import com.gathering.gdsc1stproject6th.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
