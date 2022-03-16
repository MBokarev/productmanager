package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book book2 = new Book(12, "Книга", 1300, "Евгений Онегин", "Пушкин");
    private Smartphone phone2 = new Smartphone(22, "Смартфон", 45000, "Ягодофон", "Смартфонодел");

    @Test
    public void shouldAddedProductToRepository() {

        manager.add(book2);
        manager.add(phone2);

        Product[] expected = new Product[]{book2, phone2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        String search = "Ягодофон";


        Product product1 = new Book(12, "Книга", 1300, "Евгений Онегин", "Пушкин");
        Product product2 = new Smartphone(22, "Смартфон", 45000, "Ягодофон", "Смартфонодел");

        manager.add(product1);
        manager.add(product2);

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Ягодофон");
        assertArrayEquals(expected, actual);
    }
}