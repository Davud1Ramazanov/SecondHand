package ua.secondhand.secondhand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.secondhand.secondhand.Models.Textiles;
import ua.secondhand.secondhand.Services.TextilesService;

import java.util.List;

@RestController
@RequestMapping("/Textiles")
public class TextilesController {
    private final TextilesService textilesService;

    @Autowired
    public TextilesController(TextilesService textilesService) {
        this.textilesService = textilesService;
    }

    @GetMapping("/Select")
    public ResponseEntity<List<Textiles>> selectTextile(){
        List<Textiles> textiles = textilesService.selectTextile();
        return new ResponseEntity<>(textiles, HttpStatus.OK);
    }

    @PostMapping("/Save")
    public ResponseEntity<Textiles> createTextiles(@RequestBody Textiles textiles){
        Textiles textile = textilesService.createTextile(textiles);
        return new ResponseEntity<>(textile, HttpStatus.OK);
    }

    @PostMapping("/Update/{id}")
    public ResponseEntity<Textiles> updateTextiles(@PathVariable Integer id, @RequestBody Textiles textiles){
        Textiles textile = textilesService.updateTextile(textiles, id);
        return new ResponseEntity<>(textile, HttpStatus.OK);
    }

    @PostMapping("/Delete/{id}")
    public void deleteTextiles(@PathVariable Integer id){
        textilesService.deleteTextile(id);
    }
}
