package com.kh.vira_dev.userservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_refresh_token")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
