package ua.secondhand.secondhand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.secondhand.secondhand.Models.Brands;
import ua.secondhand.secondhand.Services.BrandsService;

import java.util.List;

@RestController
@RequestMapping("/Brands")
public class BrandsController {
    private final BrandsService brandsService;

    @Autowired
    public BrandsController(BrandsService brandsService) {
        this.brandsService = brandsService;
    }

    @GetMapping("/Select")
    public ResponseEntity<List<Brands>> selectBrand() {
        List<Brands> brand = brandsService.selectBrand();
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PostMapping("/Save")
    public ResponseEntity<Brands> createBrand(@RequestBody Brands brands) {
        Brands brand = brandsService.createBrand(brands);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PostMapping("/Update/{id}")
    public ResponseEntity<Brands> updateBrand(@PathVariable Integer id, @RequestBody Brands brands) {
        Brands brand = brandsService.updateBrand(brands, id);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @PostMapping("/Delete/{id}")
    public void deleteBrand(@PathVariable Integer id) {
        brandsService.deleteBrand(id);
    }
}
