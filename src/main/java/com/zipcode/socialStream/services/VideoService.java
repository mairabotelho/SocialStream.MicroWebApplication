package com.zipcode.socialStream.services;

import com.zipcode.socialStream.models.Video;
import com.zipcode.socialStream.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class VideoService {
    @Autowired
    private VideoRepository repository;

    public String uploadToS3(MultipartFile multipartFile, Long id){
        String result = null;
        try{
            result = S3StorageService.upload(S3StorageService.convertToFile(multipartFile, id));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        return result;
    }

    public Iterable<Video> index(){
        return repository.findAll();
    }

    public Video show(Long videoId){
        return repository.findByVideoId(videoId);
    }

    public Video create(Video video){
        return repository.save(video);
    }

    public Video update(Long videoId, Video video){
        Video ogVideo = show(videoId);
        ogVideo.setVideoDescription(video.getVideoDescription());
        ogVideo.setVideoName(video.getVideoName());
        return repository.save(ogVideo);
    }

    public Boolean delete(Long videoId){
        repository.deleteById(videoId);
        return true;
    }
}
