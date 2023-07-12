package ua.secondhand.secondhand.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.secondhand.secondhand.Models.Textiles;
import ua.secondhand.secondhand.Repositories.ITextilesRepository;

import java.util.List;

@Service
public class TextilesService {
    private final ITextilesRepository textilesRepos;

    @Autowired
    public TextilesService(ITextilesRepository textilesRepos) {
        this.textilesRepos = textilesRepos;
    }

    public List<Textiles> selectTextile(){
        return textilesRepos.findAll();
    }

    public Textiles createTextile(Textiles textiles){
        return textilesRepos.save(textiles);
    }

    public Textiles updateTextile(Textiles textiles, Integer id){
        Textiles textile = textilesRepos.findById(id).orElseThrow(() -> new RuntimeException("Textiles update error!"));
        textile.setName(textiles.getName());
        textile.setImage(textiles.getImage());
        textile.setHeight(textiles.getHeight());
        textile.setLength(textiles.getLength());

        return textilesRepos.save(textile);
    }

    public void deleteTextile(Integer id){
        textilesRepos.deleteById(id);
    }
}
