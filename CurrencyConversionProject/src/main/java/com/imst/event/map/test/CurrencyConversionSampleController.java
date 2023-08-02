package com.imst.event.map.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
 
// To invoke an external service, RestTemplate() constructor
// is used
@RestController
public class CurrencyConversionSampleController {
    @GetMapping(
        "/currency-converter-sample/fromCurrency/{fromCurrency}/toCurrency/{toCurrency}/quantity/{quantity}")

    public CurrencyConversionSampleBean
    convertCurrency(@PathVariable String fromCurrency,
                    @PathVariable String toCurrency,
                    @PathVariable BigDecimal quantity)
    {
 
      
        Map<String, String> uriVariables = new HashMap<>();
      
        uriVariables.put("fromCurrency", fromCurrency);
        uriVariables.put("toCurrency", toCurrency);

        ResponseEntity<CurrencyConversionSampleBean>
            responseEntity
            = new RestTemplate().getForEntity(///currency-exchange
                "http://currency-exchange:8000/currency-exchange-sample/fromCurrency/{fromCurrency}/toCurrency/{toCurrency}",
                CurrencyConversionSampleBean.class,
                uriVariables);
        CurrencyConversionSampleBean response
            = responseEntity.getBody();
       
        return new CurrencyConversionSampleBean(
            response.getId(), fromCurrency, toCurrency,
            response.getConversionMultiple(), quantity,
            quantity.multiply(
                response.getConversionMultiple()),
            response.getPort());
    }
}
