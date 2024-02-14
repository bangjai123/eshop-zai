package id.ac.ui.cs.advprog.eshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/")
    public String HalamanUtama(Model model){
        return "Home";
    }
}
