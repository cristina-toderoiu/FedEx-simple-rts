package com.ppb.retail.controllers;

import com.ppb.retail.model.DepositInfo;
import com.ppb.retail.repository.DepositInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ToderoiuC on 5/4/2017.
 */
@RestController
public class DepositInfoController {

    @Autowired
    private DepositInfoRepository depositInfoRepository;

    private static Logger log = Logger.getLogger(DepositInfoController.class.getName());

    @RequestMapping(value = "/depositInfo/{cardNumber}")
    public DepositInfo getDepositInfoByCardNumber(@PathVariable("cardNumber") String cardNumber) {
        return depositInfoRepository.getDepositInfoByCardNumber(cardNumber);
    }

    /**
     * Can be used to add card info
     * @param depositInfo
     * @return
     */
    @RequestMapping(value = "/depositInfo", method = RequestMethod.POST)
    public boolean addDepositInfo(@RequestBody DepositInfo depositInfo) {
        depositInfoRepository.save(depositInfo);
        return true;
    }

    @RequestMapping(value = "depositInfo/{cardNumber}", method = RequestMethod.PUT)
    public boolean deposit(@PathVariable("cardNumber") String cardNumber, @RequestBody Long amount) {
        DepositInfo cardInfo = depositInfoRepository.getDepositInfoByCardNumber(cardNumber);
        if (cardInfo == null) {
            log.info("Attempt to make a deposit with an invalid card number: " + cardNumber);
            return false;
        }

        cardInfo.setLastDepositAmount(amount);
        depositInfoRepository.save(cardInfo);
        return true;
    }

    @RequestMapping(value = "/depositInfo/checkPin", method = RequestMethod.POST)
    public boolean checkPin(@RequestBody DepositInfo depositInfo) {
        List<DepositInfo> matches = depositInfoRepository.findAllByCardNumberAndAndPin(depositInfo.getCardNumber(), depositInfo.getPin());
        if (matches != null && matches.size() == 1) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/depositInfo")
    public List<DepositInfo> getAllInfo() {
        return depositInfoRepository.findAll();
    }
}
