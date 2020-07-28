package com.webapp.webdemo.entities.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "USER_ROLE")
public class UserRole {
    @Id
    @SequenceGenerator(sequenceName = "ROLE_NO_SEQ", name = "SEQ_ROLE_NO_GEN", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ROLE_NO_GEN"
    )
    @Column(name = "ROLE_NO")
    private Long roleNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_NO")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_NO")
    private Role role;
}
