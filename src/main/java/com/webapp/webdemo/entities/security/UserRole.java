package com.webapp.webdemo.entities.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "USER_ROLE")
public class UserRole {
    @Id
    @SequenceGenerator(sequenceName = "USER_ROLE_NO_SEQ", name = "SEQ_USER_ROLE_NO_GEN", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USER_ROLE_NO_GEN"
    )
    @Column(name = "USER_ROLE_NO")
    private Long userRoleNo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_NO")
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_NO")
    private Role role;
}
