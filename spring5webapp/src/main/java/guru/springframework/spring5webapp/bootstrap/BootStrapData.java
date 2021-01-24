package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepositorie;
import guru.springframework.spring5webapp.repositories.BookRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositorie authorRepositorie;
    private final BookRepositorie bookRepositorie;

    public BootStrapData(AuthorRepositorie authorRepositorie, BookRepositorie bookRepositorie) {
        this.authorRepositorie = authorRepositorie;
        this.bookRepositorie = bookRepositorie;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "William");
        Book ddd = new Book("Tica","121212");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepositorie.save(eric);
        bookRepositorie.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE BOOK", "131313");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepositorie.save(rod);
        bookRepositorie.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books "+bookRepositorie.count());

    }
}
