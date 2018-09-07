package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public int add(@PathVariable int num1, @PathVariable int num2)
    {
        return num1 + num2;
    }

    @RequestMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public int subtract(@PathVariable int num1, @PathVariable int num2){
        return num1 - num2;
    }

    @RequestMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public int multiply(@PathVariable int num1, @PathVariable int num2){
        return num1 * num2;
    }

    @RequestMapping(path = "/divide/{num1}/by/{num2}", method= RequestMethod.GET)
    @ResponseBody
    public int divide(@PathVariable int num1, @PathVariable int num2){
        return num1 /num2;
    }

}
