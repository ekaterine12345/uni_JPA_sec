package com.example.uni_jpa_sec.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="courses")
public class Course  extends BaseEntity<Long>{
    @jakarta.persistence.Id
    @Column(name = "ID")
    @SequenceGenerator(name = "courseIdSeq", sequenceName = "COURSE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseIdSeq")
    private Long Id;

    @Column(name="NAME")
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
