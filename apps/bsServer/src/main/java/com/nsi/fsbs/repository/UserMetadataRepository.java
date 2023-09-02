package com.nsi.fsbs.repository;

import com.nsi.common.model.jpa.UserMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMetadataRepository extends JpaRepository<UserMetadata, Long> {
    UserMetadata getById(Long userId);
    UserMetadata save(UserMetadata userMetadata);
}
