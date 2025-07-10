package com.abhi.SpringBootMVC.Controller;

import com.abhi.SpringBootMVC.Model.StudentData;
import com.abhi.SpringBootMVC.Model.StudentEntity;
import com.abhi.SpringBootMVC.Repositry.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SayhHelloController {

    @Autowired
    StudentRepo studentRepo;

    @PostMapping(value = "/saveStudent")
    public String saveStudent(@ModelAttribute StudentData studentData) {
        System.out.println(studentData);
        StudentEntity studentEntity;
        if (studentData.getStudentId() != null) {
//         ID present it will  update
            studentEntity = studentRepo.findById(studentData.getStudentId()).orElse(new StudentEntity());
        } else {
//             ID missing create new
            studentEntity = new StudentEntity();
        }
        studentEntity.setName(studentData.getName()); // name whichh give  in createstudent html
        studentEntity.setAddress(studentData.getAddress()); //address whichh give in createstudent html

        studentRepo.save(studentEntity);
        return "redirect:/allStudent";
    }

    @GetMapping(value = "/createdStudent")
    public String createStudent(Model model) {
        model.addAttribute("student", new StudentData());
        return "createdStudent";
    }

    @GetMapping(value = "/allStudent")
    public String showAllStudents(Model model) {
        model.addAttribute("allStudent", studentRepo.findAll());
        return "welcome";
    }

    @GetMapping(value = "/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        System.out.println("Deleted Id is :" + id);
        studentRepo.deleteById(id);

        return "redirect:/allStudent";
    }

    @GetMapping(value = "/deleteAllStudent")
    public String deleteAllStudent() {
        System.out.println("Deleting All Students At Once");
        studentRepo.deleteAll();
        return "redirect:/allStudent";
    }

    @GetMapping("/editStudent/{studentID}")
    public String editStudent(@PathVariable Integer studentID, Model model) {
        StudentEntity student = studentRepo.findById(studentID).orElse(null);
        model.addAttribute("student", student);
        return "createdStudent"; // same form for create/edit
    }

//    @PostMapping("/updateStudent")
//    public String updateStudent(@ModelAttribute("studentData") StudentData studentData) {
//        return "redirect:/allStudent";
//    }


//    @GetMapping(value = "/hello")
//    public String hello(Model model){
////        model.addAttribute("allStudents",studentRepo.findAll());
////        model.addAttribute("studentDetail",studentRepo.findById(1).get());
//        System.out.println("Hello From SayHelloController");
//        return "welcome";
//    }
}
