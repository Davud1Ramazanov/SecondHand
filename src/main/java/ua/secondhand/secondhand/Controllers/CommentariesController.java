package ua.secondhand.secondhand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.secondhand.secondhand.Models.Commentaries;
import ua.secondhand.secondhand.Services.CommentariesService;

import java.util.List;

@RestController
@RequestMapping("/Commentaries")
public class CommentariesController {
    public final CommentariesService commentariesService;

    @Autowired
    public CommentariesController(CommentariesService commentariesService) {
        this.commentariesService = commentariesService;
    }

    @GetMapping("/Select")
    public ResponseEntity<List<Commentaries>> selectCommentary(){
        List<Commentaries> commentaries = commentariesService.selectCommentary();
        return new ResponseEntity<>(commentaries, HttpStatus.OK);
    }

    @PostMapping("/Save")
    public ResponseEntity<Commentaries> createCommentary(@RequestBody Commentaries commentaries){
        Commentaries commentary = commentariesService.createCommentary(commentaries);
        return new ResponseEntity<>(commentary, HttpStatus.OK);
    }

    @PostMapping("/Update/{id}")
    public ResponseEntity<Commentaries> updateCommentary(@PathVariable Integer id, @RequestBody Commentaries commentaries){
        Commentaries commentary = commentariesService.updateCommentary(commentaries, id);
        return new ResponseEntity<>(commentary, HttpStatus.OK);
    }

    @PostMapping("/Delete/{id}")
    public void deleteCommentary(@PathVariable Integer id){
        commentariesService.deleteCommentary(id);
    }
}
