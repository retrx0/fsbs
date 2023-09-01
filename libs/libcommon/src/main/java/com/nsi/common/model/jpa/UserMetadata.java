package com.nsi.common.model.jpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

//@Entity
//@Table(name = "user_metadata", schema = "public")
@Getter
@Setter
@ToString
public class UserMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
            @JoinColumn(name = "user.user_id")
    Long userId;
    @NotNull boolean isBlocked;
    @NotNull boolean isDeleted;
    @NotNull boolean isTrial;
    @NotNull boolean isPremium;
    String deletedBy;
    @NotNull LocalDateTime lastLogin;
    @NotNull LocalDateTime modifiedTime;
    LocalDateTime trialStart;
    LocalDateTime trialEnd;
    LocalDateTime passwordLastModified;
}
