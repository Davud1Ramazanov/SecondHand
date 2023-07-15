package ua.secondhand.secondhand.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.secondhand.secondhand.Models.Products;
import ua.secondhand.secondhand.Repositories.IProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private final IProductsRepository prodRepos;

    @Autowired
    public ProductsService(IProductsRepository prodRepos) {
        this.prodRepos = prodRepos;
    }

    public Products findByName(Products products) {
        Products product = prodRepos.findByName(products.getName());
        if (product != null) {
            return product;
        }
        return null;
    }

    public List<Products> findByTextilesId(Integer id) {
        List<Products> products = prodRepos.findByTextileId(id);
        if (products != null) {
            return products;
        }
        return null;
    }

    public List<Products> findByBrandId(Integer id) {
        List<Products> products = prodRepos.findByBrandId(id);
        if (products != null) {
            return products;
        }
        return null;
    }

    public Products findByNameTextiles(Products products, Integer id){
        Products product = prodRepos.findByTextileIdAndName(id, products.getName());
        if(product != null){
            return product;
        }
        return null;
    }

    public Products findByNameBrands(Products products, Integer id){
        Products product = prodRepos.findByBrandIdAndName(id, products.getName());
        if(product != null){
            return product;
        }
        return null;
    }

    public Products findById(Integer id) {
        Optional<Products> product = prodRepos.findById(id);
        if (product != null) {
            return product.get();
        }
        return null;
    }

    public List<Products> selectProduct() {
        return prodRepos.findAll();
    }

    public Products createProduct(Products products) {
        return prodRepos.save(products);
    }

    public Products updateProduct(Products products, Integer id) {
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

    public void deleteProduct(Integer id) {
        prodRepos.deleteById(id);
    }
}
