package com.custom.eaii.training.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AuditableEntity {
    @Column(
            name = "created_date",
            nullable = false,
            updatable = false
    )
    @CreatedDate
    protected Date createdDate;
    @Column(
            name = "modified_date"
    )
    @LastModifiedDate
    protected Date modifiedDate;
    @Column(
            name = "created_by",
            updatable = false
    )
    @CreatedBy
    protected String createdBy;
    @Column(
            name = "modified_by"
    )
    @LastModifiedBy
    protected String modifiedBy = null;

    public AuditableEntity() {
    }
}

