package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String serviceName;

    public BookService(String serviceName) {
        this.serviceName = serviceName;
    }
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        System.out.println("Service Name: " + serviceName);
        bookRepository.saveBook(bookName);
        System.out.println("BookService: Book added successfully.");
    }
}