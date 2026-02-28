package com.xworkz.naukri.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "naukri_tb")


@NamedQuery(name = "readAllData",query = "select entities from NaukriEntity entities")
@NamedQuery(name="readEmail",query = "select entity from NaukriEntity entity where entity.email=:emailId")
@NamedQuery(name = "readmobile",query = "Select e from NaukriEntity e where e.mobileNumber=:phoneNumber")


public class NaukriEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;
    private String name;
    private String email;
    private Long mobileNumber;
    private String location;
    private String gender;
    private String nationality;
}
