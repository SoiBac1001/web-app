package com.webapp.webdemo.entities.security;

import com.webapp.webdemo.entities.audit.Audit;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
@Table(name = "USERS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"USER_NAME"}),
        @UniqueConstraint(columnNames = {"EMAIL"})
})
public class User extends Audit {
    @Id
    @SequenceGenerator(sequenceName = "USERS_NO_SEQ", name = "SEQ_USERS_NO_GEN", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USERS_NO_GEN"
    )
    @Column(name = "USER_NO")
    private Long userNo;

    @NotBlank
    @Column(name = "USER_NAME", length = 20)
    private String userName;

    @NotBlank
    @Column(name = "PASSWORD", length = 50)
    private String password;

    @NotBlank
    @Column(name = "EMAIL", length = 50)
    private String email;

    /*@ManyToMany
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_NO"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_NO"))
    private List<Role> roles;*/
}
