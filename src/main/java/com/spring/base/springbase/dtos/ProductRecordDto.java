package com.spring.base.springbase.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRecordDto(@NotBlank String nameProduct, @NotNull Double valueProduct) {

}
