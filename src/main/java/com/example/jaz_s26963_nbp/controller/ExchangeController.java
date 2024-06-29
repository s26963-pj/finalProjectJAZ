package com.example.jaz_s26963_nbp.controller;

import com.example.jaz_s26963_nbp.model.Exchange;
import com.example.jaz_s26963_nbp.service.ExchangeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/get/exchange/{table}/{code}")
    @Operation(summary = "Get exchange from NBP API", description = "Enter number of days, the return will be Exchange object with mean")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved and saved")
    @ApiResponse(responseCode = "404", description = "Invalid code / Exceeded valid number of days")
    public ResponseEntity<Exchange> getExchange(@PathVariable String table, @PathVariable String code,
                                                @RequestParam(required = false) String dateStart, @RequestParam(required = false) String dateStop) {
        if (dateStart == null || dateStop == null) {
            return ResponseEntity.ok(exchangeService.saveExchange(table, code));
        }
        return ResponseEntity.ok(exchangeService.saveExchange(table, code, dateStart, dateStop));

    }
}
