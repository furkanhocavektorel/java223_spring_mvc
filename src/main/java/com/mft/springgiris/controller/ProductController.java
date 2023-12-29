package com.mft.springgiris.controller;

import com.mft.springgiris.dto.response.HomeResponse;
import com.mft.springgiris.dto.response.SaveProductErrorResponse;
import com.mft.springgiris.entity.Product;
import com.mft.springgiris.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ModelAndView getProductPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("saveproduct");
        modelAndView.addObject("error", SaveProductErrorResponse.builder()
                .errorMesage("")
                .build());
        return modelAndView;
    }

    @PostMapping("")
    public Object saveProduct(String title, String description, int stock,
                              double price, MultipartFile imagee, String categoryName){


        boolean isSave=productService.save(title,description,stock,price,imagee,categoryName);
        ModelAndView modelAndView= new ModelAndView();
        List<Product> products= productService.findAll();
        if (isSave){
            modelAndView.setViewName("shop");
            modelAndView.addObject("model", HomeResponse.builder()
                            .name("aslkfhasf")
                            .title("products")
                            .products(products)
                    .build());

            return modelAndView;
        }else {
            modelAndView.setViewName("saveproduct");
            modelAndView.addObject("error", SaveProductErrorResponse.builder()
                            .errorMesage("ürün kayıt edilemedi!!!")
                    .build());
            return modelAndView;
        }

    }


}
