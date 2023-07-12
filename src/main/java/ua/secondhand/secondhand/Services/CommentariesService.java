package ua.secondhand.secondhand.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.secondhand.secondhand.Models.Categories;
import ua.secondhand.secondhand.Models.Commentaries;
import ua.secondhand.secondhand.Repositories.ICommentariesRepository;

import java.util.List;

@Service
public class CommentariesService {
    public final ICommentariesRepository commRepo;
    @Autowired
    public CommentariesService(ICommentariesRepository commRepo) {
        this.commRepo = commRepo;
    }

    public List<Commentaries> selectCommentary(){
        return commRepo.findAll();
    }

    public Commentaries createCommentary(Commentaries commentaries){
        return commRepo.save(commentaries);
    }

    public Commentaries updateCommentary(Commentaries commentaries, Integer id){
        Commentaries commentary = commRepo.findById(id).orElseThrow(() -> new RuntimeException("Commentaries update error!"));
        commentary.setText(commentaries.getText());
        commentary.setHeader(commentaries.getHeader());
        commentary.setRating(commentaries.getRating());
        commentary.setProduct(commentaries.getProduct());

        return commRepo.save(commentary);
    }

    public void deleteCommentary(Integer id){
        commRepo.deleteById(id);
    }

}
