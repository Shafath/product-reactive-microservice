package com.abc.productservice.utility;

import com.abc.productservice.dto.ProductDto;
import com.abc.productservice.entity.Product;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {
    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product toEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
