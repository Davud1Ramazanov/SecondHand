package ua.secondhand.secondhand.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.secondhand.secondhand.Models.Categories;
import ua.secondhand.secondhand.Repositories.ICategoriesRepository;

import java.util.List;

@Service
public class CategoriesService {
    private final ICategoriesRepository categoriesRepo;

    @Autowired
    public CategoriesService(ICategoriesRepository categoryRepo) {
        this.categoriesRepo = categoryRepo;
    }

    public Categories findByName(Categories categories){
        Categories category = categoriesRepo.findByName(categories.getName());
        if(category != null){
            return category;
        }
        return null;
    }

    public List<Categories> selectCategory() {
        return categoriesRepo.findAll();
    }

    public Categories createCategory(Categories categories) {
        return categoriesRepo.save(categories);
    }

    public Categories updateCategory(Categories categories, Integer id) {
        Categories category = categoriesRepo.findById(id).orElseThrow(() -> new RuntimeException("Categories update error!"));
        category.setName(categories.getName());

        return categoriesRepo.save(category);
    }

    public void deleteCategory(Integer id) {
        categoriesRepo.deleteById(id);
    }
}
