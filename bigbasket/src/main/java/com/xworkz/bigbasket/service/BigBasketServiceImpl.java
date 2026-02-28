package com.xworkz.bigbasket.service;

import com.xworkz.bigbasket.dao.BigBasketDAO;
import com.xworkz.bigbasket.dto.BigBasketDTO;
import com.xworkz.bigbasket.entity.BigBasketEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BigBasketServiceImpl implements BigBasketService{
  @Autowired
    BigBasketDAO bigBasketDAO;



    @Override
    public String checkUserData(BigBasketDTO bigBasketDTO) {
        String name = bigBasketDTO.getName();
        String email = bigBasketDTO.getEmail();
        String address = bigBasketDTO.getAddress();
        Long phoneNumber = bigBasketDTO.getPhoneNumber();
        String gender = bigBasketDTO.getGender();
        String state = bigBasketDTO.getState();
        String country = bigBasketDTO.getCountry();

        String phonePattern = "^[6-9][0-9]{9}$";
        String emailPattern = "^[A-Za-z0-9+_.-]+@gmail\\.com$";

        if (name != null && name.length() >= 3 &&
                email != null && email.matches(emailPattern) &&
                address != null && address.trim().length() >= 5 &&
                phoneNumber != null && String.valueOf(phoneNumber).matches(phonePattern) &&
                gender != null &&
                (gender.equalsIgnoreCase("Male") ||
                        gender.equalsIgnoreCase("Female") ||
                        gender.equalsIgnoreCase("Other")) &&
                state != null && !state.equalsIgnoreCase("Select State") &&
                country != null && !country.equalsIgnoreCase("Select Country")) {

            BigBasketDTO emailExists = checkEmail(email);
            BigBasketDTO phoneExists = checkMobileNumber(phoneNumber);

            if (emailExists == null && phoneExists == null) {

                BigBasketEntity entity = new BigBasketEntity();
                BeanUtils.copyProperties(bigBasketDTO, entity);

                if (bigBasketDAO.saveUserEnteredData(entity)) {
                    return "Register Success";
                }
                return "Failed To Register";
            }
        }
            return "Email or Phone already exists";
    }


    @Override
    public List<BigBasketDTO> getDTO() {
        List<BigBasketEntity> bigBasketEntityList=bigBasketDAO.getData();

        if(!bigBasketEntityList.isEmpty()){
            List<BigBasketDTO> bigBasketDTOList=new ArrayList<>();
            bigBasketEntityList.forEach(bigBasketEntity -> {
                BigBasketDTO bigBasketDTO=new BigBasketDTO();

                BeanUtils.copyProperties(bigBasketEntity,bigBasketDTO);
                bigBasketDTOList.add(bigBasketDTO);
            });
            return bigBasketDTOList;
        }
        return Collections.emptyList();
    }

    @Override
    public BigBasketDTO checkEmail(String email) {
        BigBasketEntity bigBasketEntity=bigBasketDAO.getDataBasedOnEmail(email);

        if (bigBasketEntity!=null){
            BigBasketDTO bigBasketDTO=new BigBasketDTO();
            BeanUtils.copyProperties(bigBasketEntity,bigBasketDTO);
            return bigBasketDTO;
        }
        return null;
    }

    @Override
    public BigBasketDTO checkMobileNumber(Long phoneNumber) {
        BigBasketEntity bigBasketEntity=bigBasketDAO.getDataBasedOnMobileNumber(phoneNumber);

        if(bigBasketEntity!=null){
            BigBasketDTO bigBasketDTO=new BigBasketDTO();
            BeanUtils.copyProperties(bigBasketEntity,bigBasketDTO);
            return bigBasketDTO;
        }
        return null;
    }

    @Override
    public BigBasketDTO getId(int id) {
        BigBasketEntity bigBasketEntity=bigBasketDAO.getDetailsBasedOnId(id);
        if(id!=0){
            BigBasketDTO bigBasketDTO=new BigBasketDTO();
            BeanUtils.copyProperties(bigBasketEntity,bigBasketDTO);
            return bigBasketDTO;
        }
        return null;
    }
}
