package com.imst.event.map.test;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CurrencyExchangeSampleController {

	@Autowired private Environment environment;
	 
    @GetMapping(
        "/currency-exchange-sample/fromCurrency/{fromCurrency}/toCurrency/{toCurrency}")

    public ExchangeValue
    retrieveExchangeValue(@PathVariable String fromCurrency,
                          @PathVariable String toCurrency)
    {
      
        BigDecimal conversionMultiple = null;
        ExchangeValue exchangeValue = new ExchangeValue();
        if (fromCurrency != null && toCurrency != null) {
            if (fromCurrency.equalsIgnoreCase("USD")
                && toCurrency.equalsIgnoreCase("INR")) {
                conversionMultiple = BigDecimal.valueOf(78);
            }
            if (fromCurrency.equalsIgnoreCase("INR")
                && toCurrency.equalsIgnoreCase("USD")) {
                conversionMultiple
                    = BigDecimal.valueOf(0.013);
            }
            if (fromCurrency.equalsIgnoreCase("EUR")
                && toCurrency.equalsIgnoreCase("INR")) {
                conversionMultiple = BigDecimal.valueOf(82);
            }
            if (fromCurrency.equalsIgnoreCase("AUD")
                && toCurrency.equalsIgnoreCase("INR")) {
                conversionMultiple = BigDecimal.valueOf(54);
            }
        }
      
        exchangeValue = new ExchangeValue(
            1000L, fromCurrency, toCurrency,
            conversionMultiple);
        exchangeValue.setPort(Integer.parseInt(
            environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
