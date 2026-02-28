package com.xworkz.bigbasket.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BigBasketDTO {
    private int id;
    private String name;
    private String email;
    private String address;
    private Long phoneNumber;
    private String gender;
    private String state;
    private String country;
}
