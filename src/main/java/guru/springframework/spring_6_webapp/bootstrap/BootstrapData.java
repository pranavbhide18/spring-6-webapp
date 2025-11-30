package guru.springframework.spring_6_webapp.bootstrap;

import guru.springframework.spring_6_webapp.domain.Author;
import guru.springframework.spring_6_webapp.domain.Book;
import guru.springframework.spring_6_webapp.domain.Publisher;
import guru.springframework.spring_6_webapp.repositories.AuthorRepository;
import guru.springframework.spring_6_webapp.repositories.BookRepository;
import guru.springframework.spring_6_webapp.repositories.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(BootstrapData.class);
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author();
        author1.setFirstname("John");
        author1.setLastname("Doe");

        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setIsbn("123456789");

        Author savedAuthor1 = authorRepository.save(author1);
        Book bookSaved1 = bookRepository.save(book1);

        Author author2 = new Author();
        author2.setFirstname("Jane");
        author2.setLastname("Doe");

        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setIsbn("987654321");

        Author savedAuthor2 = authorRepository.save(author2);
        Book bookSaved2 = bookRepository.save(book2);

        author1.getBooks().add(bookSaved1);
        author2.getBooks().add(bookSaved2);
        book1.getAuthors().add(savedAuthor1);
        book2.getAuthors().add(savedAuthor2);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Publisher1");
        publisher1.setAddress("address1");
        publisher1.setCity("city1");
        publisher1.setState("state1");
        publisher1.setZip("zip1");
        publisherRepository.save(publisher1);

        book1.setPublisher(publisher1);
        book2.setPublisher(publisher1);

        authorRepository.save(author1);
        authorRepository.save(author2);
        bookRepository.save(book1);
        bookRepository.save(book2);


        System.out.println("In BootstrapData");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
