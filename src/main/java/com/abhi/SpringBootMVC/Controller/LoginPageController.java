package com.abhi.SpringBootMVC.Controller;


import com.abhi.SpringBootMVC.Model.LoginEntity;
import com.abhi.SpringBootMVC.Model.LoginInfo;
import com.abhi.SpringBootMVC.Repositry.LoginRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class LoginPageController {

    @Autowired
    LoginRepo loginRepo;

    /*==================================Login Page Code==========================================*/

    @GetMapping(value = "/loginPage")
    public String loginPage(Model model) {
//        model.addAttribute(loginRepo.findAll());
        model.addAttribute("userLogin", new LoginInfo());
        return "loginPage";
    }

    @PostMapping(value = "/checkLoginInfo")
    public String checkLoginInfo(@ModelAttribute LoginInfo loginInfo, Model model) {

        LoginEntity user = loginRepo.findByUserNameAndPassword(
                loginInfo.getUserName(),
                loginInfo.getPassword()
//                loginInfo.getMobile()
        );

        if (user != null) {
            return "redirect:/allStudent";

        } else if ("Admin".equals(loginInfo.getUserName()) && "Admin123".equals(loginInfo.getPassword())) {
            return "redirect:/listOfUsers"; // Admin flow
        } else {
            model.addAttribute("loginError", "Invalid username or password");
            return "loginPage";
        }
    }
    /*==================================List Of Users Code==========================================*/

    //    to get list of users you must Type UserName = Admin And Password = Admin123
    @GetMapping(value = "/listOfUsers")
    public String listOfUsers(Model model) {
        model.addAttribute("userList", loginRepo.findAll());
        return "listOfUsers";
    }

    /*==================================Create New Login Code==========================================*/
    @GetMapping(value = "/saveNewLogin")
    public String saveNewLogin(@ModelAttribute LoginInfo loginInfo) {
        LoginEntity loginEntity;
        System.out.println(loginInfo);
        if (loginInfo.getUserId() != null) {
            loginEntity = loginRepo.findById(loginInfo.getUserId()).orElse(new LoginEntity());
        } else {
            loginEntity = new LoginEntity();
        }
        loginEntity.setMobile(loginInfo.getMobile());
        loginEntity.setUserName(loginInfo.getUserName());
        loginEntity.setPassword(loginInfo.getPassword());

        loginRepo.save(loginEntity);

//        model.addAttribute("userInfo", new LoginEntity());
        return "redirect:/loginPage";
    }

    @GetMapping(value = "/createNewLogin")
    public String createNewLogin(Model model) {
        model.addAttribute("userInfo", new LoginInfo());
        return "createNewLogin";
    }


    @GetMapping(value = "/saveLoginInfo")
    public String saveLoginData(@ModelAttribute("userInfo") LoginEntity userInfo) {
        loginRepo.save(userInfo);
        return "redirect:/loginPage";
    }



    /*==================================Forget Password Code==========================================*/

    @GetMapping(value = "/forgetPassword")
    public String forgetPassword(Model model) {
        model.addAttribute("userInfo", new LoginInfo());
        return "forgetPassword";
    }

    @PostMapping(value = "/findUserByMobile")
    public String findUserByMobile(@RequestParam("mobile") String mobile, Model model) {

        LoginEntity userFounded = loginRepo.findBymobile(mobile);
        LoginInfo userInfo = new LoginInfo();
        userInfo.setMobile(mobile);
        model.addAttribute("userInfo", userInfo);

        if (userFounded != null) {
//            model.addAttribute("userFound", true);
            model.addAttribute("userFounded", userFounded);

        } else {
            model.addAttribute("error", "Mobile No is Not Present....!!");
        }
        return "forgetPassword";
    }

    @GetMapping(value = "/resetPassword")
    public String resetPassword(@RequestParam("userId") Integer userId, @RequestParam("newPassword") String newPassword, Model model) {
        LoginEntity users = loginRepo.findById(userId).orElse(null);
        if (users != null) {
            users.setPassword(newPassword);
            loginRepo.save(users);

        } else {
            model.addAttribute("error", "Mobile No Not Found");
        }

        return "redirect:/loginPage";

    }

    /*==================================Deleteing  Users Code==========================================*/
    @GetMapping(value = "/deleteAllUSers")
    public String deleteAllUSers() {
        System.out.println("deleteing all students");
        loginRepo.deleteAll();
        return "listOfUsers";
    }

    @GetMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        System.out.println("Delete a USers" + id);
        loginRepo.deleteById(id);
        return "redirect:/listOfUsers";

    }

    @GetMapping("/editUser/{userId}")
    public String editUser(@PathVariable Integer userId, Model model) {
        LoginEntity user = loginRepo.findById(userId).orElse(null);
        model.addAttribute("student", user);
        return "forgetPassword"; // same form for create/edit
    }

//    @PostMapping("/saveLoginInfo")
//    public String saveLoginData(@ModelAttribute("userInfo") LoginInfo userInfo) {
//        LoginEntity entity = new LoginEntity();
//        // No need to set userId on create; DB will auto-generate
//        entity.setUserName(userInfo.getUserName());
//        entity.setPassword(userInfo.getPassword());
//
//        loginRepo.save(entity);
//        return "redirect:/loginPage";
//    }
}

