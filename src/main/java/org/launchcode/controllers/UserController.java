package org.launchcode.controllers;

//import jakarta.validation.Valid;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user")
public class UserController {
    private User createUser() {
        return new User();
    }

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(createUser());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm( @ModelAttribute  User user, Errors errors, Model model) {

        boolean verified = user.getPassword().equals(user.getVerify());
        if (!errors.hasErrors() && verified) {
            return "user/index";
        }
        else {
            model.addAttribute(user);
            if (!verified){
                model.addAttribute("error", "Passwords do not match");
            }
            return "user/add";
        }

    }


}
