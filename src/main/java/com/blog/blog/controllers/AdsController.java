package com.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdsController {
////    ...
//
//    @GetMapping("ads/save") // for create Ad From (only use GETMAP for a search bar) => use POST otherwise
//    public String createAd(@RequestParam(name = "title") String title, @RequestParam(name = "desc") String desc){
//        System.out.println("title"+ title); // just to test
//        System.out.println("description" + desc); //just to test
//
//        Ad ad = adsSrv.save(new Ad(title, description)); //returns a new ad on form submit
//        // REDIRECT IS => a url
//        return "redirect:/ads/" + ad.getId();
////        return "redirect:/ads/"; => will route to all ads view
//    }

}
