package com.example.homead.controller;

import com.example.homead.model.HomeAd;
import com.example.homead.service.HomeAdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeAdController {

    private final HomeAdService homeService;

    public HomeAdController(HomeAdService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/homes")
    public List<HomeAd> getAllHomes(){
        return homeService.getAllHomes();
    }

    @GetMapping("/homes/id")
    public HomeAd getHomeById(@PathVariable Long id){
        return homeService.getHomeByID( id );
    }

    @PostMapping("/homes")
    public HomeAd saveHome(@RequestBody HomeAd home){
        return homeService.saveHome( home );
    }

    @PutMapping("/homes/{id}")
    public HomeAd updateHome(@PathVariable Long id, @RequestBody HomeAd home) {
        return homeService.updateHome(id, home);
    }

    @DeleteMapping("/homes/{id}")
    public void deleteHomeById(@PathVariable Long id){
         homeService.deleteHome( id );
    }
}
