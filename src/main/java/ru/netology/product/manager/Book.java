package ru.netology.product.manager;

public class Book extends Product {

    private String author;

    public Book(int bookId, String bookName, String bookAuthor) {
        super.id = bookId;
        super.name = bookName;
        this.author = bookAuthor;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (this.author.contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}