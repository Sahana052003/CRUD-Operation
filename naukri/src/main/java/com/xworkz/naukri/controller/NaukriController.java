package com.xworkz.naukri.controller;

import com.xworkz.naukri.dto.NaukriDTO;
import com.xworkz.naukri.service.NaukriService;
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
public class NaukriController {
    public NaukriController() {
        System.out.println("NaukriController is Called");
    }

    @Autowired
    NaukriService naukriService;

    @PostMapping("login")
    public String userRegister(NaukriDTO naukriDTO, Model model) {
        System.out.println("User Entered Data is : " + naukriDTO);
        String userData = naukriService.validatedUserData(naukriDTO);
        if (userData.equalsIgnoreCase("Register Success")) {
            model.addAttribute("message", userData);
            return "index";
        } else if (userData.equalsIgnoreCase("Failed To Register")) {
            model.addAttribute("errormsg", userData);
                return "index";
        } else {
            model.addAttribute("errormsg", userData);
            return "index";
        }
    }



        @GetMapping("getDetails")
    public String getUserDetails(Model model){
            List<NaukriDTO> naukriDTOS=naukriService.getDTO();
            model.addAttribute("message",naukriDTOS);
            return "naukri";
        }

    @GetMapping("getData")
    public String getNaukriDetails(@RequestParam int id, Model model){
        System.out.println("ID is : " + id);
        NaukriDTO dto = naukriService.getID(id);
        if (dto!=null){
            model.addAttribute("info",dto);
            return "nakriDetails";
        }
        return "nakriDetails";
    }
}


