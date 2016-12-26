package io.github.vdubois.init;

import io.github.vdubois.model.Comment;
import io.github.vdubois.model.Customer;
import io.github.vdubois.repository.CommentRepository;
import io.github.vdubois.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Thread.currentThread().sleep((long) (Math.random() * 10000));
        Stream.of("vdubois,dubois.vct@free.fr,4,978-1449374648,Excellent livre!!,2016-01-02 11:52:36", "starbuxman,josh.long@pivotal.com,5,978-1449374648,A must read,2015-08-16 06:38:12").forEach(
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
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try {
                        comment.setCreationDate(formatter.parse(commentsCaracteristics[5]));
                    } catch (ParseException e) {
                        comment.setCreationDate(new Date());
                    }
                    commentRepository.save(comment);
                }
        );
    }
}
