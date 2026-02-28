package com.xworkz.bigbasket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor@NoArgsConstructor
@Table(name = "bigbasket_tb")


@NamedQuery(name = "readAllData",query = "select entities from BigBasketEntity entities")
@NamedQuery(name="readEmail",query = "select entity from BigBasketEntity entity where entity.email=:gmail")
@NamedQuery(name = "readmobile",query = "Select e from BigBasketEntity e where e.phoneNumber=:mobileNumber")


public class BigBasketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;
    private String name;
    private String email;
    private String address;
    private Long phoneNumber;
    private String gender;
    private String state;
    private String country;
}
