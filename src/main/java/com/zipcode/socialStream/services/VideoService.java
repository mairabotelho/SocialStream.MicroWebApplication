package com.zipcode.socialStream.services;

import com.zipcode.socialStream.models.Video;
import com.zipcode.socialStream.repositories.VideoRepository;

public class VideoService {

    private VideoRepository repository;

    public VideoService(VideoRepository repository){
        this.repository = repository;
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
        return repository.save(video);
    }

    public Boolean delete(Long videoId){
        repository.deleteById(videoId);
        return true;
    }
}
