package com.ppb.retail.service;

import com.ppb.retail.model.DepositInfo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by ToderoiuC on 5/5/2017.
 */
public class DepositInfoService {
    public static final String DEPOSIT_INFO = "/depositInfo/";
    private RestTemplate restTemplate;
    private String url;

    public DepositInfoService(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public DepositInfo getDepositInfoByCardNumber(String cardNumber) {
        return restTemplate.getForObject(url + DEPOSIT_INFO + cardNumber, DepositInfo.class);
    }

    public boolean addDepositInfo(DepositInfo depositInfo) {
        return restTemplate.postForObject(url + DEPOSIT_INFO, depositInfo, Boolean.class);
    }

    public boolean deposit(String cardNumber, Long amount) {
        return restTemplate.exchange(url + DEPOSIT_INFO + cardNumber, HttpMethod.PUT,
                new HttpEntity<Object>(amount), Boolean.class).getBody();
    }

    public boolean checkPin(DepositInfo depositInfo) {
        return restTemplate.postForObject(url + DEPOSIT_INFO + "checkPin", depositInfo, Boolean.class);
    }

    public List<DepositInfo> getAllInfo() {
        return restTemplate.exchange(url + DEPOSIT_INFO, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<DepositInfo>>() {}).getBody();
    }
}
