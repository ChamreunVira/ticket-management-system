package com.kh.vira_dev.userservice.entity;

import com.kh.vira_dev.commonutils.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_role")
@Getter
@Setter
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , nullable = false , unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @ManyToMany(mappedBy = "roles" , fetch = FetchType.LAZY)
    private Set<User> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tbl_role_permission",
            joinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id" , referencedColumnName = "id")
    )
    private Set<Permission> permissions = new HashSet<>();

    @ManyToMany(mappedBy = "roles" , fetch = FetchType.LAZY)
    private Set<Group> groups = new HashSet<>();

}
