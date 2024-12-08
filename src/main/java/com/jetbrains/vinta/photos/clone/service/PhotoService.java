package com.jetbrains.vinta.photos.clone.service;

import com.jetbrains.vinta.photos.clone.model.Photo;
import com.jetbrains.vinta.photos.clone.repository.PhotosRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PhotoService {

   private  final PhotosRepository photosRepository;

    public PhotoService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }


    public Iterable<Photo> get() {
        return photosRepository.findAll();
    }


    public Photo get(Integer id) {
        return photosRepository.findById(id).orElse(null);
    }




    public void remove(Integer id) {
    photosRepository.deleteById(id);
    }

    public Photo save(String filename, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFilename(filename);
        photo.setData(data);
        photosRepository.save(photo);
        return photo;
    }

}
