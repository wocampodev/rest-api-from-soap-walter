package dev.wocampo.restapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.wocampo.restapi.dtos.PostProductDTO;
import dev.wocampo.restapi.dtos.ProductDTO;
import dev.wocampo.restapi.dtos.UpdateProductDTO;
import dev.wocampo.restapi.helpers.ProductConvert;
import dev.wocampo.restapi.services.IProductService;
import dev.wocampo.soap.client.WsProductsClient;
import dev.wocampo.soap.server.webservice.GetProductByIdResponse;
import dev.wocampo.soap.server.webservice.SaveProductResponse;
import dev.wocampo.soap.server.webservice.UpdateProductResponse;

@Service
public class SoapProductServiceImpl implements IProductService {

    @Autowired
    private WsProductsClient wsProductsClient;

    @Override
    public List<ProductDTO> getAll() {
        return wsProductsClient.handleWrapperGetProducts()
                .getProduct().stream()
                .map(x -> ProductConvert.toDTO(x))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Integer id) {
        GetProductByIdResponse response = wsProductsClient.handleWrapperGetProductById(id);
        return ProductConvert.toDTO(response.getProduct());
    }

    @Override
    public ProductDTO save(PostProductDTO product) {
        SaveProductResponse response = wsProductsClient.handleWrapperSaveProduct(ProductConvert.toEntity(product));
        return ProductConvert.toDTO(response.getProduct());
    }

    @Override
    public ProductDTO update(UpdateProductDTO product, Integer id) {
        UpdateProductResponse response = wsProductsClient.handleWrapperUpdateProduct(id,
                ProductConvert.toEntity(product));
        return ProductConvert.toDTO(response.getProduct());
    }

    @Override
    public void delete(Integer id) {
        wsProductsClient.handleWrapperDeleteProduct(id);
    }

}
