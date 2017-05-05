package com.ppb.retail.repository;

import com.ppb.retail.model.DepositInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ToderoiuC on 5/4/2017.
 */
@Transactional
public interface DepositInfoRepository extends JpaRepository<DepositInfo, String> {
    DepositInfo getDepositInfoByCardNumber(String cardNumber);
    List<DepositInfo> findAllByCardNumberAndAndPin(String cardNumber, String pin);
    
}
