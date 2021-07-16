package kr.co.msa.msauser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
public class HomeController {
    @GetMapping("/welcome")
    public String welcome() {
        return "welcome to user service";
    }
}
