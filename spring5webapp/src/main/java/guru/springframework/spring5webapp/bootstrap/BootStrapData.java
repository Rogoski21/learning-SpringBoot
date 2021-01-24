package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepositorie;
import guru.springframework.spring5webapp.repositories.BookRepositorie;
import guru.springframework.spring5webapp.repositories.PublisherRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepositorie authorRepositorie;
    private final BookRepositorie bookRepositorie;
    private final PublisherRepositorie publisherRepositorie;

    public BootStrapData(AuthorRepositorie authorRepositorie, BookRepositorie bookRepositorie, PublisherRepositorie publisherRepositorie) {
        this.authorRepositorie = authorRepositorie;
        this.bookRepositorie = bookRepositorie;
        this.publisherRepositorie = publisherRepositorie;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("Starting in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepositorie.save(publisher);

        System.out.println("Number of publishers " + publisherRepositorie.count());

        Author eric = new Author("Eric", "William");
        Book ddd = new Book("Tica", "121212");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepositorie.save(eric);
        bookRepositorie.save(ddd);
        publisherRepositorie.save(publisher);


        System.out.println("Number of Books " + bookRepositorie.count());
        System.out.println("Publisher: NUmber of Books " + publisher.getBooks().size());

    }
}
