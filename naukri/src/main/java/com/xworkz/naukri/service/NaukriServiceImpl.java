package com.xworkz.naukri.service;

import com.xworkz.naukri.dto.NaukriDTO;
import com.xworkz.naukri.entity.NaukriEntity;
import com.xworkz.naukri.repository.NaukriRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NaukriServiceImpl implements NaukriService {
    @Autowired
    NaukriRepository naukriRepository;


    @Override
    public String validatedUserData(NaukriDTO dto) {
        String name =dto.getName();
        String email = dto.getEmail();
        Long mobileNumber = dto.getMobileNumber();
        String location = dto.getLocation();
        String gender = dto.getGender();
        String nationality = dto.getNationality();

        String phonePattern = "^[6-9][0-9]{9}$";

        if (name != null && name.length() >= 3 &&
                email != null && email.endsWith("@gmail.com") &&
                mobileNumber != null && String.valueOf(mobileNumber).matches(phonePattern) &&
                location != null && !location.trim().isEmpty() &&
                gender != null &&
                (gender.equalsIgnoreCase("Male") ||
                        gender.equalsIgnoreCase("Female") ||
                        gender.equalsIgnoreCase("Other")) &&
                nationality != null && !nationality.equalsIgnoreCase("Select Nationality")) {


            NaukriDTO naukriDTO = checkEmailExists(email);
            NaukriDTO naukriDTO1 = checkPhoneNumberExists(mobileNumber);
            if (naukriDTO == null && naukriDTO1 == null) {
                NaukriEntity naukri = new NaukriEntity();
                BeanUtils.copyProperties(dto, naukri);
                if (naukriRepository.saveData(naukri)) {
                    return "Register Success";
                }
                return "Failed To Register";
            }
        }
        return "Data already Exists";
    }


        @Override
        public List<NaukriDTO> getDTO () {
            List<NaukriEntity> naukriEntities = naukriRepository.getUserData();

            if (!naukriEntities.isEmpty()) {
                List<NaukriDTO> naukriDTOS = new ArrayList<>();
                naukriEntities.forEach(naukriEntity -> {
                    NaukriDTO naukriDTO = new NaukriDTO();

                    BeanUtils.copyProperties(naukriEntity, naukriDTO);
                    naukriDTOS.add(naukriDTO);
                });
                return naukriDTOS;
            } else {
                return Collections.emptyList();
            }
        }



        @Override
        public NaukriDTO checkEmailExists (String email){
            NaukriEntity detailsBasedOnEmail = naukriRepository.getDetailsBasedOnEmail(email);

            if (detailsBasedOnEmail != null) {
                NaukriDTO naukriDTO = new NaukriDTO();
                BeanUtils.copyProperties(detailsBasedOnEmail, naukriDTO);
                return naukriDTO;
            }
            return null;
        }

        @Override
        public NaukriDTO checkPhoneNumberExists (Long mobileNumber){
            NaukriEntity detailsBasedOnEmail = naukriRepository.getDetailsBasedOnMobileNumber(mobileNumber);

            if (detailsBasedOnEmail != null) {
                NaukriDTO naukriDTO = new NaukriDTO();
                BeanUtils.copyProperties(detailsBasedOnEmail, naukriDTO);
                return naukriDTO;
            }
            return null;
        }

        @Override
        public NaukriDTO getID ( int id){
            NaukriEntity naukri = naukriRepository.getDetailsBasedOnId(id);
            if (id != 0) {
                NaukriDTO naukriDTO = new NaukriDTO();
                BeanUtils.copyProperties(naukri, naukriDTO);
                return naukriDTO;
            }
            return null;
        }
    }
