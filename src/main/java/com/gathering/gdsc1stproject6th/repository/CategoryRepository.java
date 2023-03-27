package com.gathering.gdsc1stproject6th.repository;

import com.gathering.gdsc1stproject6th.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
