package com.jimjacob.example.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class StudentEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHERID")
    private TeacherEntity teacher;

    public StudentEntity(final String firstName, final String lastName, final TeacherEntity teacher) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teacher = teacher;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }
}
