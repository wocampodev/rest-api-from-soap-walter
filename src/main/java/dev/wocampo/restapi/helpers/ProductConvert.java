package dev.wocampo.restapi.helpers;

import dev.wocampo.restapi.dtos.PostProductDTO;
import dev.wocampo.restapi.dtos.ProductDTO;
import dev.wocampo.restapi.dtos.UpdateProductDTO;
import dev.wocampo.soap.server.webservice.Product;

public final class ProductConvert {

    private ProductConvert() {
    }

    public static ProductDTO toDTO(Product product) {
        ProductDTO productDto = new ProductDTO();
        productDto.setId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        return productDto;
    }

    public static Product toEntity(PostProductDTO productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        if (productDto.getDescription() != null) {
            product.setDescription(productDto.getDescription());
        }
        return product;
    }

    public static Product toEntity(UpdateProductDTO productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        if (productDto.getDescription() != null) {
            product.setDescription(productDto.getDescription());
        }
        return product;
    }

}
