package ma.sec.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(Authentication a) {
        return "Hello! " + a.getName();
    }

    @PostMapping("/hello")
    public String helloPost(Authentication a) {
        return "Hello Post ! " + a.getName();
    }
}
