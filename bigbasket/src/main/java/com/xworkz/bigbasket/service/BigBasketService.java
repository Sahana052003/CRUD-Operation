package com.xworkz.bigbasket.service;

import com.xworkz.bigbasket.dto.BigBasketDTO;

import java.util.List;

public interface BigBasketService {
    String checkUserData(BigBasketDTO bigBasketDTO);

    List<BigBasketDTO> getDTO();

    BigBasketDTO checkEmail(String email);

    BigBasketDTO checkMobileNumber(Long phoneNumber);

    BigBasketDTO getId(int id);
}
