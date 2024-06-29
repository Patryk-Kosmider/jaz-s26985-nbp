package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Service
public class NbpService {
    private final RestTemplate restTemplate;
    private final DatabaseLogRepository databaseLogRepository;

    public NbpService(RestTemplate restTemplate, DatabaseLogRepository databaseLogRepository){
        this.restTemplate = restTemplate;
        this.databaseLogRepository = databaseLogRepository;
    }

    public double getAverageExchangeRate(String currency, LocalDate startDate, LocalDate endDate){

        String url =  "http://api.nbp.pl/api/exchangerates/rates/A/{currencyId}/{startDate}/{endDate}";

        LocalDate now = LocalDate.now();
        LocalTime time = LocalTime.now();

        Nbp nbp = restTemplate.getForObject(url, Nbp.class, currency, startDate, endDate);
        double rate_value = 0;
        for(Rate rate : nbp.getRate_list()){
            rate_value += rate.getMid();
        }

        long days = ChronoUnit.DAYS.between(startDate, endDate);

        double average_rates = rate_value / days;

        DatabaseLog databaseLog = new DatabaseLog();
        databaseLog.setWaluta(currency);
        databaseLog.setDate_start(startDate);
        databaseLog.setDate_end(endDate);
        databaseLog.setDate_now(now);
        databaseLog.setKurs(average_rates);
        databaseLog.setTime(time);

        databaseLogRepository.save(databaseLog);

        return average_rates;
    }
}
