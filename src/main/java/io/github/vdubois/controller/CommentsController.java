package io.github.vdubois.controller;

import io.github.vdubois.model.Comment;
import io.github.vdubois.repository.CommentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vdubois on 04/12/16.
 */
@RestController
public class CommentsController {

    private CommentRepository commentRepository;

    public CommentsController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/books/{isbn}/comments")
    public List<Comment> findCommentsForBookWithIsbn(@PathVariable(value = "isbn") String isbn) {
        return commentRepository.findByBookIsbn(isbn);
    }
}
