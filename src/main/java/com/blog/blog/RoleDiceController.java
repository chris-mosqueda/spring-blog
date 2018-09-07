package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoleDiceController {

    // first time home page view
    @GetMapping("/roll-dice")
    public String returnHome() {
        return "rollDice";
    }

    // after guesses a link
    @GetMapping(value="roll-dice/{num}")
    public String match(@PathVariable String num, Model viewModel) {
        viewModel.addAttribute("rand", getRandomNumber());

        viewModel.addAttribute("guess", num);

        return "guessedNum";
    }

    public static String getRandomNumber(){
        int x = (int) (Math.random() * 6) + 1;
        String randNum = String.valueOf(x);
        return randNum;
    }
}
