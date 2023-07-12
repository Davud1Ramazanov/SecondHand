package ua.secondhand.secondhand.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.secondhand.secondhand.Models.Products;
import ua.secondhand.secondhand.Repositories.IProductsRepository;

import java.util.List;

@Service
public class ProductsService {
    private final IProductsRepository prodRepos;

    @Autowired
    public ProductsService(IProductsRepository prodRepos) {
        this.prodRepos = prodRepos;
    }

    public List<Products> selectProduct(){
        return prodRepos.findAll();
    }

    public Products createProduct(Products products){
        return prodRepos.save(products);
    }

    public Products updateProduct(Products products, Integer id){
        Products product = prodRepos.findById(id).orElseThrow(() -> new RuntimeException("Products update error!"));
        product.setName(products.getName());
        product.setImage(products.getImage());
        product.setBrand(products.getBrand());
        product.setPrice(products.getPrice());
        product.setQuantity(products.getQuantity());
        product.setCategory(products.getCategory());
        product.setTextile(products.getTextile());

        return prodRepos.save(product);
    }

    public void deleteProduct(Integer id){
        prodRepos.deleteById(id);
    }
}
