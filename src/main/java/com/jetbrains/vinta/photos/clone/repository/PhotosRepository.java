package com.jetbrains.vinta.photos.clone.repository;

import com.jetbrains.vinta.photos.clone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photo,Integer> {


}
