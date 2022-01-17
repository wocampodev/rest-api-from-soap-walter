package dev.wocampo.restapi.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.wocampo.restapi.dtos.PostProductDTO;
import dev.wocampo.restapi.dtos.ProductDTO;
import dev.wocampo.restapi.dtos.UpdateProductDTO;
import dev.wocampo.restapi.helpers.ResponseHandler;
import dev.wocampo.restapi.services.IProductService;

@RestController
@RequestMapping("products")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<?> index() {
        List<ProductDTO> products = productService.getAll();
        return ResponseHandler.withBody(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        ProductDTO product = productService.getById(id);
        return ResponseHandler.withBody(product, HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<?> store(@RequestBody PostProductDTO producDto) {
        ProductDTO product = productService.save(producDto);
        return ResponseHandler.withBody(product, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateProductDTO productDto, @PathVariable Integer id) {
        ProductDTO product = productService.update(productDto, id);
        return ResponseHandler.withBody(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseHandler.withNothing(HttpStatus.OK);
    }

}
