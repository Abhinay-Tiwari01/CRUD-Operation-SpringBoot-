package com.abhi.SpringBootMVC.Controller.AttributeControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AttributeController {

    @GetMapping(value = "/attribute")
    public String getAttribute(Model model) {
        model.addAttribute("attributes", "Hello TO Java");
        List<String> studentsName = List.of("Abhinay", "Darshan", "Omkar", "Azmat", "testing");
        model.addAttribute("studentsName", studentsName);
        return "attribute";
    }

}
