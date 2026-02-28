package com.xworkz.naukri.repository;

import com.xworkz.naukri.entity.NaukriEntity;

import java.util.List;

public interface NaukriRepository {
    boolean saveData(NaukriEntity naukriEntity);
    List<NaukriEntity> getUserData();
    NaukriEntity getDetailsBasedOnEmail(String email);
    NaukriEntity getDetailsBasedOnMobileNumber(Long mobileNumber);
    NaukriEntity getDetailsBasedOnId(int id);
}
