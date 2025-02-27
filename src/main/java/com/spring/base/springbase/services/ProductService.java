package com.spring.base.springbase.services;

import com.spring.base.springbase.controllers.ProductController;
import com.spring.base.springbase.dtos.ProductRecordDto;
import com.spring.base.springbase.models.ProductModel;
import com.spring.base.springbase.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ResponseEntity<ProductModel> saveProduct(ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> productModelList = productRepository.findAll();
        if(!productModelList.isEmpty()) {
            for(ProductModel productModel : productModelList) {
                UUID id = productModel.getIdProduct();
                productModel.add(linkTo(methodOn(ProductController.class).getOneProducts(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productModelList);
    }

    public ResponseEntity<Object> getOneProducts(UUID id) {
        Optional<ProductModel> productModel = productRepository.findById(id);
        if(productModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto nao encontrado");
        }
        productModel.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(productModel);
    }

    public ResponseEntity<Object> updateProduct(UUID id,ProductRecordDto productRecordDto) {
        Optional<ProductModel> productModel = productRepository.findById(id);
        if(productModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto nao encontrado");
        }
        var productUpdate = productModel.get();
        BeanUtils.copyProperties(productRecordDto, productUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productUpdate));
    }

    public ResponseEntity<Object> deleteProduct(UUID id) {
        Optional<ProductModel> productModel = productRepository.findById(id);
        if(productModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto nao encontrado");
        }
        productRepository.delete(productModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado");
    }

}
