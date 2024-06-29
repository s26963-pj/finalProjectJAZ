package com.example.jaz_s26963_nbp.service;

import com.example.jaz_s26963_nbp.exceptions.ExchangeNotFoundException;
import com.example.jaz_s26963_nbp.exceptions.notValidNumberOfDays;
import com.example.jaz_s26963_nbp.model.Exchange;
import com.example.jaz_s26963_nbp.model.Rate;
import com.example.jaz_s26963_nbp.repository.ExchangeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.DecimalFormat;
import java.util.Optional;

@Service
public class ExchangeService {
    private final ExchangeRepository exchangeRepository;
    private final WebClient webClient;
    private final String formatJson = "?format=json";

    public ExchangeService(ExchangeRepository exchangeRepository, WebClient webClient) {
        this.exchangeRepository = exchangeRepository;
        this.webClient = webClient;
    }

    public Exchange getExchange(Long id) {
        Optional<Exchange> exchange = exchangeRepository.findById(id);
        if (exchange.isPresent()) {
            return exchange.get();
        } else {
            throw new ExchangeNotFoundException();
        }
    }

    public Exchange saveExchange(String table, String exchangeCode) {
        Exchange exchange = webClient.get()
                .uri("http://api.nbp.pl/api/exchangerates/rates/" + table + "/" + exchangeCode + formatJson)
                .retrieve()
                .bodyToMono(Exchange.class)
                .block();
        if (exchange != null) {
            getExchangeMean(exchange);
            exchangeRepository.save(exchange);
        } else {
            throw new ExchangeNotFoundException();
        }
        return exchange;
    }

    public Exchange saveExchange(String table, String exchangeCode, String dateStart, String dateStop) {
        Exchange exchange = webClient.get()
                .uri("http://api.nbp.pl/api/exchangerates/rates/" + table + "/" + exchangeCode + "/" +
                        dateStart + "/" + dateStop + formatJson)
                .retrieve()
                .bodyToMono(Exchange.class)
                .block();
        if (exchange != null) {
            getExchangeMean(exchange);
            exchangeRepository.save(exchange);
        } else {
            throw new ExchangeNotFoundException();
        }
        return exchange;
    }

    private Double getExchangeMean(Exchange exchange) {
        Double total = 0.0;
        for (Rate rate : exchange.getRates()) {
            total += rate.getMid();
        }
        Double mean = total / exchange.getRates().size();
        exchange.setMean(mean);
        return mean;
    }
}
