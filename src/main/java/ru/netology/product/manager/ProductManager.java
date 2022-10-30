package ru.netology.product.manager;

public class ProductManager {

    private final ProductRepository repository = new ProductRepository();

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                int length = result.length + 1;
                Product[] tmp = new Product[length];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }

                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = product;

                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        return product.matches(search);
        /*
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

        // или в одну строку:
        return product.getName().contains(search);
         */
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public void removeById(int removeId) {
        repository.removeById(removeId);
    }
}