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
@Table(name="students")
public class Student extends BaseEntity<Long>{

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "studentIdSeq", sequenceName = "STUDENT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentIdSeq")
    private Long Id;

    @Column(name="NAME")
    private String name;

    @ManyToOne
    private University university;  // university_id

    @OneToOne
    private StudentProfile studentProfile;

    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;


    /*
    SELECT s.id, s.name, c.id, c.name
FROM students s
INNER JOIN student_course sc ON s.ID = sc.student_id
INNER JOIN courses c ON c.ID = sc.course_id;
    * */
}
