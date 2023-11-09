package com.uniamerica.pSpringSecutiryExercicio.Repository;

import com.uniamerica.pSpringSecutiryExercicio.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
