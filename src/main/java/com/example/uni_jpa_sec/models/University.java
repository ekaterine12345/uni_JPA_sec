package com.example.uni_jpa_sec.models;

import com.example.uni_jpa_sec.dtos.UniversityDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "universities")
public class University extends BaseEntity<Long>{

    @Id
    @Column(name="ID", updatable = false)
    @SequenceGenerator(name = "universityIdSeq", sequenceName = "UNIVERSITY_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "universityIdSeq")
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name="address")
    private String address;

    public University(UniversityDto universityDto) {
        this.name = universityDto.getName();
        this.address = universityDto.getAddress();
        if (this.address != null){
            this.recordState = RecordState.ACTIVE;
        }
        else{
            this.recordState = RecordState.DRAFT;
        }
    }
}
