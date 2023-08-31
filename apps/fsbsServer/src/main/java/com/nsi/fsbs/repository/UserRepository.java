package com.nsi.fsbs.repository;

import com.nsi.dto.UserRegistrationDTO;
import com.nsi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserRegistrationDTO, Long> {
    User findByEmail(String email);
}
