package io.github.vdubois.controller;

import io.github.vdubois.model.Comment;
import io.github.vdubois.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vdubois on 04/12/16.
 */
@RestController
public class CommentsController {

    private CommentService commentService;

    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/books/{isbn}/comments")
    public List<Comment> findCommentsForBookWithIsbn(@PathVariable(value = "isbn") String isbn) {
        return commentService.findByBookIsbn(isbn);
    }
}
