package com.webapp.webdemo.entities.security;

import com.webapp.webdemo.entities.audit.Audit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "USERS")
public class Users extends Audit {
    @Id
    @SequenceGenerator(sequenceName = "USERS_NO_SEQ", name = "SEQ_USERS_NO_GEN", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USERS_NO_GEN"
    )
    @Column(name = "USER_NO")
    private Long userNo;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;
}
