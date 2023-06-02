package com.example.uni_jpa_sec.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="student_profiles")
public class StudentProfile extends BaseEntity<Long>{
    @jakarta.persistence.Id
    @Column(name = "ID")
    @SequenceGenerator(name = "studentProfileIdSeq", sequenceName = "STUDENT_PROFILE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentProfileIdSeq")
    private Long Id;

    @Column(name="GPA")
    private double gpa;

    @Column(name="FACULTY")
    private String faculty;



}
