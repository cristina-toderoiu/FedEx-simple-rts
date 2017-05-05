package com.ppb.retail;

import com.ppb.retail.model.DepositInfo;
import com.ppb.retail.service.DepositInfoService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by ToderoiuC on 5/5/2017.
 */
public class Main {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        String url = "http://localhost:8052/";
        DepositInfoService depositInfoService = new DepositInfoService(restTemplate, url);

        DepositInfo depositInfo = new DepositInfo();
        depositInfo.setCardId("1");
        depositInfo.setCardNumber("1234567890123456");
        depositInfo.setPin("4321");

        System.out.println(depositInfoService.addDepositInfo(depositInfo));

        List<DepositInfo> allInfo = depositInfoService.getAllInfo();

        System.out.println(allInfo);

        System.out.println(depositInfoService.deposit("1234567890123456", 15L));

        allInfo = depositInfoService.getAllInfo();

        System.out.println(allInfo);

        DepositInfo depositInfoByCardNumber = depositInfoService.getDepositInfoByCardNumber("1234567890123456");

        System.out.println(depositInfoByCardNumber);

        DepositInfo checkPin = new DepositInfo();
        checkPin.setCardNumber("1234567890123456");
        checkPin.setPin("4321");

        System.out.println("check pin - correct: " + depositInfoService.checkPin(checkPin));

        DepositInfo checkPinW = new DepositInfo();
        checkPinW.setCardNumber("1234567890123456");
        checkPinW.setPin("1166");

        System.out.println("check pin - wrong: " + depositInfoService.checkPin(checkPinW));
    }
}
