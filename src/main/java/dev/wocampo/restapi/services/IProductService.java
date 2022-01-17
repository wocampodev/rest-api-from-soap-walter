package dev.wocampo.restapi.services;

import java.util.List;

import dev.wocampo.restapi.dtos.PostProductDTO;
import dev.wocampo.restapi.dtos.ProductDTO;
import dev.wocampo.restapi.dtos.UpdateProductDTO;

public interface IProductService {

    List<ProductDTO> getAll();

    ProductDTO getById(Integer id);

    ProductDTO save(PostProductDTO product);

    ProductDTO update(UpdateProductDTO product, Integer id);

    void delete(Integer id);

}
