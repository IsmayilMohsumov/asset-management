package com.asset.collabera.controller;

import com.asset.collabera.entity.Staff;
import com.asset.collabera.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class WebController {

    @Autowired
    WebService webService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("applicationName" , "Asset Management");
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("applicationName" , "Asset Management");
        return "register";
    }

    @PostMapping("/submit")
    public String submit(@Valid Staff staff, BindingResult binding , Model model) {
        if(binding.hasErrors())
        {
            model.addAttribute("errorMessage",binding);
            return "register";
        }else {
            webService.saveStaff(staff);
            return "redirect:/";
        }
    }

    @PostMapping("/loginverify")
    public String loginverify(Model model, @RequestParam("email") String email, @RequestParam("password") String password ) {


        Staff staff = webService.verifyStaff(email, password);
        if (staff==null){
            return "validationError";
        }
        model.addAttribute("name" , staff.getName());
        model.addAttribute("mobile" , staff.getMobile());
        model.addAttribute("staffId" , staff.getStaffID());

        return "loginverify";
    }


}
