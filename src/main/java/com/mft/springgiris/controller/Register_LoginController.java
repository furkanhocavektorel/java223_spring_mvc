package com.mft.springgiris.controller;

import com.mft.springgiris.dto.response.HomeResponse;
import com.mft.springgiris.entity.Customer;
import com.mft.springgiris.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class Register_LoginController {
    // IOC
    // IOC container
    // IOT
    private final CustomerService customerService;

    public Register_LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // RestFul & MVC-> Model View Controller
    @GetMapping("")
    public ModelAndView register(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    // butona tıklandıktan sonra
    // bir sayfaya yönlendirmek gerekiyor
    // 2 farklı şekli var
    // 1. yöntem yeni bir ModelAndView olusturulur.
    @PostMapping("")
    public ModelAndView register(String name
            ,String surname
            ,String email
            ,String password
            ,int age){
        customerService.saveCustomer(name,surname,email,password,age);
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView view= new ModelAndView();
        view.setViewName("login");
        return view;
    }
    // butona tıklandıktan sonra
    // bir sayfaya yönlendirmek gerekiyor
    // 2 farklı şekli var
    // 2.yötnemde Object
    @PostMapping("/login")
    public Object login(String email,String password){

        Customer customer=customerService.login2(email,password);

        if (customer!=null){
            ModelAndView modelAndView= new ModelAndView();
            modelAndView.setViewName("shop");
            modelAndView.addObject("model",HomeResponse.builder()
                            .name(customer.getName())
                            .title("URUNLER")
                    .build());

            return  modelAndView;
        }else {
            return "redirect:";
        }
    }

}
