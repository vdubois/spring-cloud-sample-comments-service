package io.github.vdubois.repository;

import io.github.vdubois.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by vdubois on 16/11/16.
 */
@RepositoryRestResource(collectionResourceRel = "comments", path = "comments")
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    List<Comment> findByBookIsbn(String booksIsbn);
}
