package com.abc.productservice.service;

import com.abc.productservice.dto.ProductDto;
import org.bson.internal.BsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InitProduct implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        ProductDto productDto = new ProductDto();
        productDto.setDescription("New phone");
        productDto.setPrice(Double.valueOf(1000));
        Flux.just(productDto)
                .flatMap(p -> productService.insertProduct(Mono.just(productDto)))
                .subscribe(System.out::println);
    }
}
