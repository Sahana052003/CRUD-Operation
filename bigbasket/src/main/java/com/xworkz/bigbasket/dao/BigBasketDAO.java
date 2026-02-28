package com.xworkz.bigbasket.dao;

import com.xworkz.bigbasket.entity.BigBasketEntity;

import java.util.List;

public interface BigBasketDAO {
    boolean saveUserEnteredData(BigBasketEntity bigBasketEntity);
    List<BigBasketEntity> getData();

    BigBasketEntity getDataBasedOnEmail(String email);
    BigBasketEntity getDataBasedOnMobileNumber(Long phoneNumber);

    BigBasketEntity getDetailsBasedOnId(int id);
}
