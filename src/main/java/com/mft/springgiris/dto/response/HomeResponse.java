package com.mft.springgiris.dto.response;

import com.mft.springgiris.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HomeResponse {
    String name;
    String title;
    List<Product> products;
}
