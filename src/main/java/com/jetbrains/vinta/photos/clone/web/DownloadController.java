package com.jetbrains.vinta.photos.clone.web;

import com.jetbrains.vinta.photos.clone.service.PhotoService;
import com.jetbrains.vinta.photos.clone.model.Photo;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {

    

    private final PhotoService photoService;

    public DownloadController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @GetMapping("/download/{id}")
        public ResponseEntity<byte[]> download(@PathVariable Integer id){

        Photo photo = photoService.get(id);
        if (photo==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND);


        byte[] data = new byte[0];
            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.valueOf(photo.getContentType()));

        ContentDisposition build = ContentDisposition.builder("attachment")
                .filename(photo.getFilename())
                .build();


        headers.setContentDisposition(build);

            return  new ResponseEntity<>(data,headers, HttpStatus.OK)   ;
    }
}
