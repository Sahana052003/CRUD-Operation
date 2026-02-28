package com.xworkz.bigbasket.controller;

import com.xworkz.bigbasket.dto.BigBasketDTO;
import com.xworkz.bigbasket.service.BigBasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class BigBasketController {
    public BigBasketController(){
        System.out.println("BigBasketController is Called");
    }
    @Autowired
    BigBasketService bigBasketService;


    @PostMapping("register")
    public String loginPage(BigBasketDTO bigBasketDTO,Model model){
        System.out.println("User entered data " + bigBasketDTO);
        String checkUserData = bigBasketService.checkUserData(bigBasketDTO);
        if(checkUserData.equalsIgnoreCase("Register Success")){
            model.addAttribute("message", checkUserData);
            return "index";
        } else if (checkUserData.equalsIgnoreCase("Failed To Register")) {
            model.addAttribute("errormsg", checkUserData);
            return "index";
        } else {
            model.addAttribute("errormsg", checkUserData);
            return "index";
        }
    }


    @GetMapping("getUserDetails")
    public String getUserDetails(Model model){
        List<BigBasketDTO> naukriDTOS=bigBasketService.getDTO();
        model.addAttribute("message",naukriDTOS);
        return "bigbasket";
    }





    @GetMapping("getData")
    public String getNaukriDetails(@RequestParam int id, Model model){
        System.out.println("ID is : " + id);
        BigBasketDTO dto = bigBasketService.getId(id);
        if (dto!=null){
            model.addAttribute("info",dto);
            return "bigbasketDetails";
        }
        return "bigbasketDetails";
    }
}

