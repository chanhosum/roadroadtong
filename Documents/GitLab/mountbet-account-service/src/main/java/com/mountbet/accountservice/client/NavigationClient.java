package com.mountbet.accountservice.client;

import com.mountbet.accountservice.entity.Navigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NavigationClient {
    @Value("${navigation-service.url}")
    private String navigationServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public Navigation getMarket(String marketId) {
        //return restTemplate.getForObject(navigationServiceUrl + "/navigation/getMarketForAccountService/1.146604130", Navigation.class); for testing
        return restTemplate.getForObject(navigationServiceUrl + "/navigation/getMarketForAccountService/" + marketId, Navigation.class);
    }

}
