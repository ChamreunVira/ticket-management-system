package com.kh.vira_dev.userservice.entity;

import com.kh.vira_dev.commonutils.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_permission")
@Getter
@Setter
public class Permission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @ManyToMany(mappedBy = "permissions" , fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(mappedBy = "permissions" , fetch = FetchType.LAZY)
    private Set<Group> groups = new HashSet<>();

}
