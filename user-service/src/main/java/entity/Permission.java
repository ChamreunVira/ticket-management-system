package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_permission")
@Getter
@Setter
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String test;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @ManyToMany(mappedBy = "permissions" , fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();

}
