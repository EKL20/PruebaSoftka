package com.elkin.kartRock.racing.commons.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -1011939721218881483L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected boolean deleted;

    @Column(name = "created_by", updatable = false)
    protected String createdBy;

    @CreationTimestamp
    @Column(name = "created_At", updatable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_by")
    protected String updatedBy;

    @UpdateTimestamp
    @Column(name = "updated_At")
    protected LocalDateTime updatedAt;
}
