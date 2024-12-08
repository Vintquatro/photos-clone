package com.jetbrains.vinta.photos.clone;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class PhotosController {

private final PhotoService photoService;

    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/photos")
    public Collection<Photo> get(){
return photoService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id){
        Photo photo= photoService.get(id);
        if (photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photoService.get(id);
    }


    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id){
        Photo photo= photoService.remove(id);
        if (photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {


        return photoService.save(file.getOriginalFilename(), file.getBytes());

    }

}
