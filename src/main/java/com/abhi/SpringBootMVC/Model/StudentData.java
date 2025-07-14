package com.abhi.SpringBootMVC.Model;

public class StudentData {

    public byte[] Image;
    private Integer studentId;
    private String name;
    private String address;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }

    @Override
    public String toString() {
        return "StudentData{" +
                "id=" + studentId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
