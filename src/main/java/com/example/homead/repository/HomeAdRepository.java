package com.example.homead.repository;

import com.example.homead.model.HomeAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeAdRepository extends JpaRepository<HomeAd,Long> {
}
