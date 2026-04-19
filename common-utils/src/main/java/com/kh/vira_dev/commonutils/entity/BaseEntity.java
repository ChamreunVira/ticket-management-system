package com.kh.vira_dev.commonutils.entity;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @Column(name = "created_at" , nullable = false)
    private LocalDate createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    public void initialize() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }

    @PreDestroy
    public void destroy() {
        this.updatedAt = LocalDate.now();
    }

}
