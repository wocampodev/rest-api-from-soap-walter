package dev.wocampo.restapi.dtos;

import java.io.Serializable;

public class UpdateProductDTO implements Serializable {

    private String name;
    private Integer price;
    private String description;

    public UpdateProductDTO() {
    }

    public UpdateProductDTO(String name, Integer price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
