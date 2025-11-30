package guru.springframework.spring_6_webapp.services;

import guru.springframework.spring_6_webapp.domain.Author;
import guru.springframework.spring_6_webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;


public interface AuthorService {
    Iterable<Author> findAll();
}
