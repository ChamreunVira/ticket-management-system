package com.kh.vira_dev.userservice.entity;

import com.kh.vira_dev.commonutils.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false , unique = true)
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "image")
    private String image;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "enabled" , nullable = false)
    private boolean enabled;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "login_attempt")
    private Integer loginAttempt = 0;

    @Column(name = "max_attempt")
    private Integer maxAttempt = 3;

    @Column(name = "email" , nullable = false , unique = true)
    private String email;

    @Column(name = "user_type", nullable = false)
    private String userType;

    private String gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    private String status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tbl_user_role",
            joinColumns = @JoinColumn(name = "user_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

}
