package com.nsi.fsbs.repository;

import com.nsi.common.model.jpa.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User getById(@NotNull Long id);
    User save(User user);
}
