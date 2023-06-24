package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "Чашка", 700);
        Product product2 = new Product(22, "Холодильник", 67_000);
        Product product3 = new Product(300, "Чайник", 7_500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(22);
        Product[] actual = repo.findAll();
        Product[] expected = {product1,product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testExceptionalSituation() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(11, "Чашка", 700);
        Product product2 = new Product(22, "Холодильник", 67_000);
        Product product3 = new Product(300, "Чайник", 7_500);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(5345));
    }
}