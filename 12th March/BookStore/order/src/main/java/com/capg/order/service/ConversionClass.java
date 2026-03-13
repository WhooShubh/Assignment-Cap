package com.capg.order.service;

import org.springframework.stereotype.Component;

import com.capg.order.dto.Book;
import com.capg.order.dto.BookDto;

@Component
public class ConversionClass {
	
	 public BookDto convertFromBooktoDto(Book book) {
	    	
	    	BookDto dto = new BookDto();
	    	dto.setId(book.getId());
	    	dto.setPrice(book.getPrice());
	    	dto.setQuantity(book.getQuantity());
	    	dto.setTitle(book.getTitle());
	    	return dto;
	    	
	    }
	 
	 public Book convertFromDtoToBook(BookDto dto) {
		 Book book = new Book();
		 book.setId(dto.getId());
		 book.setTitle(dto.getTitle());
		 book.setQuantity(dto.getQuantity());
		 book.setPrice(dto.getPrice());
		 book.setAuthor(null);
		 book.setIsbn(null);
		 book.setCategory(null);
		 return book;
	 }
}
