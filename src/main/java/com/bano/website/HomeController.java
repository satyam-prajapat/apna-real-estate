package com.bano.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // RestController se wapas Controller kiya taaki HTML pages chala sakein
public class HomeController {

    @Autowired
    private ServiceRepository serviceRepository;
    

    @GetMapping("/")
    public String showHomePage(Model model) {
        // 🎯 LOGIC: Database se saari dynamic properties fetch karke home page ke model mein push karein
        model.addAttribute("services", serviceRepository.findAll());
        
        // Agar aapke pass home page par direct banner dynamic variable hai toh use bhi render karein
        model.addAttribute("bannerText", "Welcome to My Fresh Website Project!");
        
        return "index"; // index.html open karega
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
}