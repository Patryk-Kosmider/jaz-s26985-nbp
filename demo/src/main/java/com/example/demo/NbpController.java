package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/nbp")
public class NbpController {
    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }
    @Operation(
            summary = "Retrieve the average value of currency between Start date and End date"
    )
    @ApiResponse
    @ApiResponse(responseCode = "404",description = "404 Not Found", content = { @Content(schema = @Schema())})
    @ApiResponse(responseCode = "400",description = "400 Bad Request", content = { @Content(schema = @Schema())})
    @GetMapping("/{currency}/{start_date}/{end_date}")
    @ApiResponse(responseCode = "408",description = "400 Bad Request", content = { @Content(schema = @Schema())})
    public ResponseEntity<Double> average_currency(@PathVariable String currency, @PathVariable LocalDate start_date, @PathVariable LocalDate end_date){
        Double average_value = nbpService.getAverageExchangeRate(currency, start_date, end_date);
        return ResponseEntity.ok(average_value);
    }
}
