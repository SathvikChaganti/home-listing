package com.example.homead.service;

import com.example.homead.model.HomeAd;
import com.example.homead.repository.HomeAdRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeAdService {
    private final HomeAdRepository homeRepository;

    public HomeAdService(HomeAdRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public List<HomeAd> getAllHomes(){
        return homeRepository.findAll();
    }

    public HomeAd getHomeByID(Long id){
        return homeRepository.findById( id ).orElse( null );
    }

    public HomeAd updateHome(Long id, HomeAd home) {
        HomeAd existingHome = homeRepository.findById(id).orElse(null);
        if (existingHome == null) {
            return null;
        }

        existingHome.setTitle(home.getTitle());
        existingHome.setDescription(home.getDescription());
        existingHome.setPrice(home.getPrice());
        existingHome.setBedrooms(home.getBedrooms());
        existingHome.setBathrooms(home.getBathrooms());
        existingHome.setSquareFootage(home.getSquareFootage());
        existingHome.setAddress(home.getAddress());
        existingHome.setCity(home.getCity());
        existingHome.setState(home.getState());
        existingHome.setZipCode(home.getZipCode());

        homeRepository.save(existingHome);

        return existingHome;
    }

    public HomeAd saveHome(HomeAd home){
        return homeRepository.save( home );
    }

    public void deleteHome(Long id){
         homeRepository.deleteById( id );
    }
}
