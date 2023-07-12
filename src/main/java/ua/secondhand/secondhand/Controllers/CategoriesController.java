package ua.secondhand.secondhand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.secondhand.secondhand.Models.Categories;
import ua.secondhand.secondhand.Services.CategoriesService;

import java.util.List;

@RestController
@RequestMapping("/Categories")
public class CategoriesController {
    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/Select")
    public ResponseEntity<List<Categories>> selectCategory(){
        List<Categories> categories = categoriesService.selectCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/Save")
    public ResponseEntity<Categories> createCategory(@RequestBody Categories categories){
        Categories category = categoriesService.createCategory(categories);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/Update/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable Integer id, @RequestBody Categories categories){
        Categories category = categoriesService.updateCategory(categories, id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/Delete/{id}")
    public void deleteCategory(@PathVariable Integer id){
        categoriesService.deleteCategory(id);
    }
}
