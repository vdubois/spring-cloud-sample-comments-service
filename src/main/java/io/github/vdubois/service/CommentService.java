package io.github.vdubois.service;

import io.github.vdubois.model.Comment;
import io.github.vdubois.repository.CommentRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vdubois on 07/12/16.
 */
@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Cacheable(value = "comments", key = "#booksIsbn")
    public List<Comment> findByBookIsbn(String booksIsbn) {
        return commentRepository.findByBookIsbn(booksIsbn);
    }
}
