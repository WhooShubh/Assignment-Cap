package com.capg.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.book.entity.Book;
import com.capg.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
    private BookRepository repo;

	public Book createBook(Book book) {
        return repo.save(book);
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book getBookById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Book updateBook(Long id, Book updatedBook) {

        Book book = repo.findById(id).orElseThrow();

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setIsbn(updatedBook.getIsbn());
        book.setPrice(updatedBook.getPrice());
        book.setQuantity(updatedBook.getQuantity());
        book.setCategory(updatedBook.getCategory());

        return repo.save(book);
    }

    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}
