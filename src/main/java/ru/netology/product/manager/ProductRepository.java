package ru.netology.product.manager;

public class ProductRepository {

    private Product[] products = new Product[0];

    //вывод всех объектов
    public Product[] findAll() {
        return products;
    }

    //сохранить/добавить объект
    public void save(Product newProduct) {
        if (products.length != 0) {
            if (findById(newProduct.getId()) != null) {
                throw new AlreadyExistsException("Element with id: " + newProduct + " already exist");
            }
        }
        int length = products.length + 1;
        Product[] tmp = new Product[length];

        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = newProduct;

        products = tmp;
    }

    //удалить объект по id
    public void removeById(int removeId) {
        if (products.length != 0) {
            if (findById(removeId) == null) {
                throw new NotFoundException("Element with id: " + removeId + " not found");
            }
            Product[] tmp = new Product[products.length - 1];
            int copyToIndex = 0;

            for (int i = 0; i < products.length; i++) {
                if (products[i].getId() != removeId) {
                    tmp[copyToIndex] = products[i];
                    copyToIndex++;
                }
            }

            products = tmp;
        } else {
            System.out.println("No products to remove");
        }
    }

    // поиск товара по id
    public Product findById(int searchId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == searchId) {
                return products[i];
            }
        }
        return null;
    }
}