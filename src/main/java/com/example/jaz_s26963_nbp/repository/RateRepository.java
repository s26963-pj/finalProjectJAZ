package com.example.jaz_s26963_nbp.repository;

import com.example.jaz_s26963_nbp.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}
