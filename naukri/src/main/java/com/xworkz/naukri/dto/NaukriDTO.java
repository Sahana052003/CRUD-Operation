package com.xworkz.naukri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NaukriDTO {

    private int id;
    private String name;
    private String email;
    private Long mobileNumber;
    private String location;
    private String gender;
    private String nationality;
}
