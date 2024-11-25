package com.CPmovement.mapping_and_viewing_info.repository;

import com.CPmovement.mapping_and_viewing_info.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Override
    Optional<User> findById(Long userId);
}
