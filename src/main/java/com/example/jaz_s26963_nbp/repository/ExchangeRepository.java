package com.example.jaz_s26963_nbp.repository;

import com.example.jaz_s26963_nbp.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
}
