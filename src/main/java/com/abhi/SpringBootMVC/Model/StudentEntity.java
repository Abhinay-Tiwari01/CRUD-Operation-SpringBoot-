package com.abhi.SpringBootMVC.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "students")
//@AllArgsConstructor
//@Data
//@Getter
//@Setter
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int StudentId;

    @Column(name = "studen_name")
    private String name;

    @Column(name = "student_address")
    private String address;

    public StudentEntity() {
    }

    public StudentEntity(int StudentId, String name, String address) {
        this.StudentId = StudentId;
        this.name = name;
        this.address = address;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int id) {
        this.StudentId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "StudentId=" + StudentId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
