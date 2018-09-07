package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringTest {

    @GetMapping("/homeee")
    public String returnHome() {
        return "home"; // looks for html page in templates
    }

}
