package dz.sundev.controllers;

import dz.sundev.services.ProductService;
import dz.sundev.vos.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductServiceController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully " + product, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getIdProduct/{id}", method = RequestMethod.GET)
    public String getIdProduct(@PathVariable("id") String id) {
        return "id: " + id;
    }

    @RequestMapping(value = "/getProductByName", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(
            @RequestParam(value = "name", required = false, defaultValue = "honey") String name) {
        return new ResponseEntity<>(
                productService.getProducts()
                        .stream()
                        .filter(product -> product.getName().equalsIgnoreCase(name))
                        .findFirst()
                        .orElse(new Product()),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }
}
