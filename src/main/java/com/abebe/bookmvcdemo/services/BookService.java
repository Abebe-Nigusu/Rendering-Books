package com.abebe.bookmvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abebe.bookmvcdemo.models.Book;
import com.abebe.bookmvcdemo.repositories.BookRepository;

@Service
public class BookService {
	
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //update a book
    public Book editBook(Book b) {
    	return bookRepository.save(b);
    }
    //delete a book
    public  void  deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    //returning by criteria
    public List<Book> booksContaining(String search){
    	return bookRepository.findByDescriptionContaining(search);    
    	
    }

}
