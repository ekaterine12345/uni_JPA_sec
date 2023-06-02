package com.example.uni_jpa_sec.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
@ToString
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity<ID extends Serializable> {

    @CreatedDate
    @Column(name="CREATED_AT", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;

    @LastModifiedDate
    @Column(name="UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedAt;

    public enum RecordState{
        DRAFT, INACTIVE, ACTIVE, DELETED
    }

    @Enumerated(EnumType.STRING)
    @Column(name="RECORD_STATE")
    protected RecordState recordState;
}
