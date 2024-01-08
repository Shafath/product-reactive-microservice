package com.abc.productservice.controller;

import com.abc.productservice.dto.ProductDto;
import com.abc.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public Flux<ProductDto> getAllProducts()  {
        System.out.println();
        System.out.println("Feature branch");
        return this.productService.getAll();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<ProductDto>> getAllProducts(@PathVariable String id)  {
        return this.productService.getProductById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public Mono<ProductDto> insertProduct(@RequestBody Mono<ProductDto> productDtoMono)  {
        return this.productService.insertProduct(productDtoMono);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<ProductDto>> updateProduct(@PathVariable String id, @RequestBody Mono<ProductDto> productDtoMono)  {
        return this.productService.updateProduct(id, productDtoMono)
                                    .map(ResponseEntity::ok)
                                    .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteProduct(@PathVariable String id)  {
        return this.productService.deleteProduct(id);
    }
}
