package ua.secondhand.secondhand.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.secondhand.secondhand.Models.Brands;
import ua.secondhand.secondhand.Repositories.IBrandsRepository;

import java.util.List;

@Service
public class BrandsService {
    private final IBrandsRepository brandsRepo;

    @Autowired
    public BrandsService(IBrandsRepository brandRepo) {
        this.brandsRepo = brandRepo;
    }

    public List<Brands> selectBrand(){
        return brandsRepo.findAll();
    }

    public Brands createBrand(Brands brands){
        return brandsRepo.save(brands);
    }

    public Brands updateBrand(Brands brands, Integer id){
        Brands brand = brandsRepo.findById(id).orElseThrow(() -> new RuntimeException("Brands update error!"));
        brand.setName(brands.getName());
        brand.setFaq(brands.getFaq());
        brand.setCountry(brands.getCountry());
        brand.setImage(brands.getImage());

        return brandsRepo.save(brand);
    }

    public void deleteBrand(Integer id){
        brandsRepo.deleteById(id);
    }
}
