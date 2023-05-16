package com.gathering.gdsc1stproject6th.repository;

import com.gathering.gdsc1stproject6th.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
