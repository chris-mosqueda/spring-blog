package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
//
//    @RequestMapping(path = "/hi", method= RequestMethod.GET) //listens for url path
//    @ResponseBody //only to return text
//    private String sayHi(@RequestParam(value = "isloud", required = false) ){
//        return "<h1>Hi!</h1>"; // not returning a whole lot of html here
//    }

    @GetMapping("/list")
    private String listOfNames(Model viewModel){
        List<String> names = new ArrayList<>();

        names.add("chris");
        names.add("jack");
        names.add("jow");

        viewModel.addAttribute("listOfNames", names); //sending a variable that contains a list of names

        viewModel.addAttribute("role", "admin");

        return "lists";
    }

}
