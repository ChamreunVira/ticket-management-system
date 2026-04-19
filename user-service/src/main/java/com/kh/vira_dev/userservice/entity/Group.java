package com.kh.vira_dev.userservice.entity;

import com.kh.vira_dev.commonutils.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_group")
@Getter
@Setter
public class Group extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "descriptionb")
    private String description;

    @Column(name = "status")
    private String status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tbl_group_role",
            joinColumns = @JoinColumn(name = "group_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id" , referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tbl_group_permission",
            joinColumns = @JoinColumn(name = "group_id" , referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id" , referencedColumnName = "id")
    )
    private Set<Permission> permissions = new HashSet<>();


}
