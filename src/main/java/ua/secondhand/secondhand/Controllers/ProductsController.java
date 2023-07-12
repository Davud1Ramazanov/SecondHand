package ua.secondhand.secondhand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.secondhand.secondhand.Models.Products;
import ua.secondhand.secondhand.Services.ProductsService;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductsController {
    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }
    @GetMapping("/Select")
    public ResponseEntity<List<Products>> selectProduct(){
        List<Products> products = productsService.selectProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/Save")
    public ResponseEntity<Products> createProduct(@RequestBody Products products){
        Products product = productsService.createProduct(products);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/Update/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Integer id, @RequestBody Products products){
        Products product = productsService.updateProduct(products, id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/Delete/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productsService.deleteProduct(id);
    }
}
