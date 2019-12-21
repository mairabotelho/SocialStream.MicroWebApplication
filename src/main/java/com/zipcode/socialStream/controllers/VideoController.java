package com.zipcode.socialStream.controllers;

import com.zipcode.socialStream.models.Video;
import com.zipcode.socialStream.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class VideoController {

        private VideoService videoService;

        @Autowired
        public VideoController(VideoService videoService){
            this.videoService = videoService;
        }

        @GetMapping("/videos")
        public ResponseEntity<Iterable<Video>> index(){
            return new ResponseEntity<>(videoService.index(), HttpStatus.OK);

        }

        @GetMapping("/videos/{videoId}")
        public @ResponseBody ResponseEntity<Video> show (@PathVariable Long videoId){
            return new ResponseEntity<>(videoService.show(videoId), HttpStatus.OK);
        }

        @PostMapping("/videos")
        public ResponseEntity<Video> create(@Valid @RequestBody Video video){
            return new ResponseEntity<>(videoService.create(video), HttpStatus.OK);
        }

        @PutMapping("/videos/{videoId}")
        public ResponseEntity<Video> update(@PathVariable Long videoId, @Valid @RequestBody Video video){
            return new ResponseEntity<>(videoService.update(videoId, video), HttpStatus.OK);
        }

        @DeleteMapping("/videos")
        public ResponseEntity<Boolean> delete(Long videoId){
            return new ResponseEntity<>(videoService.delete(videoId), HttpStatus.OK);
        }
}
