package io.github.vdubois.init;

import io.github.vdubois.model.Comment;
import io.github.vdubois.model.Customer;
import io.github.vdubois.repository.CommentRepository;
import io.github.vdubois.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by vdubois on 16/11/16.
 */
@Component
public class CommentsInitializer implements CommandLineRunner {

    private CustomerRepository customerRepository;

    private CommentRepository commentRepository;

    @Autowired
    public CommentsInitializer(CustomerRepository customerRepository, CommentRepository commentRepository) {
        this.customerRepository = customerRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("vdubois,dubois.vct@free.fr,4,978-1449374648,Excellent livre!!", "starbuxman,josh.long@pivotal.com,5,978-1449374648,A must read").forEach(
                tuple -> {
                    String[] commentsCaracteristics = tuple.split(",");
                    Customer customer = new Customer();
                    customer.setUsername(commentsCaracteristics[0]);
                    customer.setEmail(commentsCaracteristics[1]);
                    customerRepository.save(customer);
                    Comment comment = new Comment();
                    comment.setRating(Integer.valueOf(commentsCaracteristics[2]));
                    comment.setBookIsbn(commentsCaracteristics[3]);
                    comment.setContent(commentsCaracteristics[4]);
                    comment.setCustomer(customer);
                    commentRepository.save(comment);
                }
        );
    }
}
