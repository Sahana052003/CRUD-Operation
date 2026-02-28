package com.xworkz.naukri.service;

import com.xworkz.naukri.dto.NaukriDTO;

import java.util.List;

public interface NaukriService {

    String validatedUserData(NaukriDTO dto);

    List<NaukriDTO> getDTO();

    NaukriDTO checkEmailExists(String email);
    NaukriDTO checkPhoneNumberExists(Long mobileNumber);


    NaukriDTO getID(int id);
}
