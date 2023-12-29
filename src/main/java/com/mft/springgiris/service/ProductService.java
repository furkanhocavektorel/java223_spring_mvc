package com.mft.springgiris.service;

import com.mft.springgiris.entity.Category;
import com.mft.springgiris.entity.Product;
import com.mft.springgiris.repository.IProductRepository;
import com.mft.springgiris.utilty.Multipart;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final IProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(IProductRepository productRepository, CategoryService categoryService){
        this.productRepository=productRepository;
        this.categoryService=categoryService;
    }
    public boolean save(String title, String description, int stock,
                        double price, MultipartFile file, String categornName){
        Optional<Category> category=categoryService.getByName(categornName);

        if (category.isPresent()){

            String url= Multipart.multipartToUrl(file);


        Product product= Product.builder()
                .categoryId(category.get().getId())
                .description(description)
                .url(url)
                .price(price)
                .stock(stock)
                .title(title)
                .build();
        productRepository.save(product);
        return true;
        }else {
            return false;
        }


    }



    public List<Product> findAll(){
        return productRepository.findAll();
    }





}
