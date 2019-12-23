package com.zipcode.socialStream.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.persistence.Entity;

import static org.junit.Assert.*;

public class VideoTest {

    @Test
    public void testClassSignatureAnnotations(){
        assertTrue(Video.class.isAnnotationPresent(Entity.class));
    }

    @Test
    public void testCreateJson() throws JsonProcessingException{
        ObjectMapper jsonWriter = new ObjectMapper();
        Video video = new Video();
        String json = jsonWriter.writeValueAsString(video);
    }

}