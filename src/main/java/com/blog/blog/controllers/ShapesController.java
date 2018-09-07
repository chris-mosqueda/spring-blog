package com.blog.blog.controllers;

import com.blog.blog.services.ShapesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShapesController {
    private final ShapesService shpServ;

    public ShapesController(ShapesService shpServ) {
        this.shpServ = shpServ;
    }

    @GetMapping("/shapes/{length}")
    public String shapeProperty(@PathVariable double length, Model vModel) {
//        double perimeter = length * 4;
//        vModel.addAttribute("sqrPerim", perimeter);
        double perimeter = shpServ.sqrPerim(length);
        vModel.addAttribute("sqrPerim", perimeter);

        double area = shpServ.sqrArea(length);
        vModel.addAttribute("sqrArea", area);

        double volume = shpServ.sqrVolume(length);
        vModel.addAttribute("sqrVol", volume);

        double circumference = shpServ.circleCirc(length);
        vModel.addAttribute("circleCirc", circumference);

        double circArea = shpServ.areaCirc(length);
        vModel.addAttribute("circArea", circArea);

        return "shapes";
    }
}
