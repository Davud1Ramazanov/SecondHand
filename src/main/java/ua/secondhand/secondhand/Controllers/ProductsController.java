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

    @PostMapping("/FindById/{id}")
    public ResponseEntity<Products> findById(@PathVariable Integer id){
        Products products = productsService.findById(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/FindByName")
    public ResponseEntity<Products> findByName(@RequestBody Products products) {
        Products product = productsService.findByName(products);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/FindByTextilesId/{id}")
    public ResponseEntity<List<Products>> findByTextilesId(@PathVariable Integer id){
        List<Products> products = productsService.findByTextilesId(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/FindByBrandsId/{id}")
    public ResponseEntity<List<Products>> findByBrandsId(@PathVariable Integer id){
        List<Products> products = productsService.findByBrandId(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/FindByTextilesNameAndId/{id}")
    public ResponseEntity<Products> findByTextilesNameAndId(@PathVariable Integer id, @RequestBody Products products){
        Products product = productsService.findByNameTextiles(products, id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/FindByBrandsNameAndId/{id}")
    public ResponseEntity<Products> findByBrandsNameAndId(@PathVariable Integer id, @RequestBody Products products){
        Products product = productsService.findByNameBrands(products, id);
        return new ResponseEntity<>(product, HttpStatus.OK);
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
