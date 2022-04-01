package dima.salomakhin.task.javatesttaskv2.controller;


import dima.salomakhin.task.javatesttaskv2.model.PairDto;
import dima.salomakhin.task.javatesttaskv2.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptocurrencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/list")
    public List<PairDto> pairs(@RequestParam("page") int page, @RequestParam("size") int size) {
        return currencyService.getAllPairs(page, size);
    }

    @GetMapping("/list/min/{symbol1}/{symbol2}")
    public String getCurrencyMin(@PathVariable("symbol1") String symbol1, @PathVariable String symbol2) {
        return currencyService.getCurrency(symbol1, symbol2).getMinPrice();
    }

    @GetMapping("/list/max/{symbol1}/{symbol2}")
    public String getCurrencyMax(@PathVariable("symbol1") String symbol1, @PathVariable String symbol2) {
        return currencyService.getCurrency(symbol1, symbol2).getMaxPrice();
    }
}
