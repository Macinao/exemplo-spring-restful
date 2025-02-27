package com.spring.base.springbase.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Entity
@Table(name = "product")
public class ProductModel extends RepresentationModel<ProductModel> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product")
    private UUID idProduct;

    @Column(name = "name_product", nullable = false)
    private String nameProduct;

    @Column(name = "value_product", nullable = false)
    private Double valueProduct;

    public UUID getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getValueProduct() {
        return valueProduct;
    }

    public void setValueProduct(Double valueProduct) {
        this.valueProduct = valueProduct;
    }

}
