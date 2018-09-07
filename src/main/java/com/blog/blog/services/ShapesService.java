package com.blog.blog.services;

import org.springframework.stereotype.Service;


@Service
public class ShapesService {

    public double sqrPerim(double len) {
        return len * 4;
    }

    public double sqrArea(double len) {
        return len * len;
    }

    public double sqrVolume(double len) {
        return Math.pow(len, 3);
    }

    public double circleCirc(double len) {
        return 2 * (Math.PI * len);
    }

    public double areaCirc(double len) {
        return Math.PI * (Math.pow(len, 2));
    }

}
