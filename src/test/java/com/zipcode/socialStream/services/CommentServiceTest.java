package com.zipcode.socialStream.services;

import com.zipcode.socialStream.models.Comment;
import com.zipcode.socialStream.repositories.CommentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class CommentServiceTest {

    @InjectMocks
    CommentService service;

    @Mock
    CommentRepository mockRepository;

    private List<Comment> commentList;
    private Comment comment1, comment2, comment3;

    @Before
    public void setup(){
        commentList = new LinkedList<>();
        comment1 = new Comment(001L,"comment", null, 123L);
        comment2 = new Comment(002L, "Comment", null, 124L);
        comment3 = new Comment(003L, null, "This is a reply", 125L);

        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);
    }

    @Test
    public void testAddComment() throws Exception{
        when(mockRepository.save(comment1)).thenReturn(comment1);

        assertEquals(service.saveComment(comment1), comment1);

        verify(mockRepository, times(1)).save(comment1);
    }

    @Test
    public void testAddReplyComment(){
        when(mockRepository.save(comment3)).thenReturn(comment3);

        assertEquals(service.saveComment(comment3), comment3);

        verify(mockRepository, times(1)).save(comment3);
    }
}