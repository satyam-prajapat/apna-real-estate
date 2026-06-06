package com.bano.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private ServiceRepository serviceRepository;

    // 🚀 STATIC MEMORY REPOSITORY: Naye registered users ko runtime par save rakhne ke liye cache memory variables
    private static String currentActiveUser = "admin";
    private static String currentActivePass = "admin123";

    @GetMapping("/admin/login")
    public String showLoginPage() {
        return "admin/login";
    }

    @PostMapping("/admin/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // 🎯 DYNAMIC CHECK: Ab ye "admin" check nahi karega, balki aapke naye registered values ko match karega!
        if (currentActiveUser.equals(username) && currentActivePass.equals(password)) {
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("error", "Galat Username ya Password!");
            return "admin/login";
        }
    }

    @GetMapping("/admin/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("services", serviceRepository.findAll());
        return "admin/dashboard";
    }

    @GetMapping("/admin/service/add")
    public String showAddServiceForm() {
        return "admin/newcard";
    }

    @PostMapping("/admin/service/save")
    public String saveService(@RequestParam String title, @RequestParam String description) {
        ServiceItem newItem = new ServiceItem();
        newItem.setTitle(title);
        newItem.setDescription(description);
        
        serviceRepository.save(newItem);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/admin/logout")
    public String handleLogout() {
        return "redirect:/admin/login";
    }

    @GetMapping("/admin/signup")
    public String showSignUpPage() {
        return "admin/signup"; 
    }

    @PostMapping("/admin/register")
    public String handleUserRegistration(@RequestParam String username, @RequestParam String password, Model model) {
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            model.addAttribute("error", "Username aur Password khali nahi ho sakte, bhai!");
            return "admin/signup";
        }
        
        // 🎯 SAVE DATA: Pura data register hote hi static active setup variables mein change ho jayega
        currentActiveUser = username.trim();
        currentActivePass = password.trim();
        
        model.addAttribute("success", "Registration successful! Ab naye credentials se login kijiye.");
        return "admin/login"; 
    }
}