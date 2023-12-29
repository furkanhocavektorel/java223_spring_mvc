package com.mft.springgiris.controller;

import com.mft.springgiris.dto.response.HomeResponse;
import com.mft.springgiris.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final CustomerService customerService;
    public HomeController(CustomerService customerService){
        this.customerService= customerService;
    }

    @GetMapping("")
    public ModelAndView mainPage(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("shop");
        modelAndView.addObject("model", HomeResponse.builder()
                        .name("xxxxx")


                .build());
        return modelAndView;
    }
}
