package com.capg.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.order.dto.Book;
import com.capg.order.dto.BookDto;
import com.capg.order.entity.Order;
import com.capg.order.service.BookFeignClientService;
import com.capg.order.service.ConversionClass;
import com.capg.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
    OrderService service;
	
	@Autowired
	private ConversionClass con;

    @Autowired
    BookFeignClientService bookService;

    @PostMapping("/createBook")
    public BookDto createBook(@RequestBody Book b) {
    	Book book= bookService.createBook(b);
    	return con.convertFromBooktoDto(book);
    }
    
    @GetMapping("/allBook")
    public List<BookDto> getAllBooks(){
        List<Book> books= bookService.getAllBooks();
        List<BookDto> dtos= new ArrayList<BookDto>();
        for(Book b : books) {
       	 dtos.add(con.convertFromBooktoDto(b));
        }
        
        return dtos;
   }
    
    @GetMapping("/getBook/{id}")
    public BookDto getBookById(@PathVariable Long id) {
    	Book b =  bookService.getBookById(id);
    	return con.convertFromBooktoDto(b);
    }
    
    @PutMapping("/updateBook/{id}")
    public BookDto updateBook(@PathVariable Long id,
    		@RequestBody Book book) {
    	Book b =  bookService.updateBook(id, book);
    	return con.convertFromBooktoDto(b);
    }
    
    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable Long id){
   	 bookService.deleteBook(id);
   }

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/get/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PutMapping("/update/{id}")
    public Order updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateOrderStatus(id, status);
    }

    @PutMapping("/delete/{id}")
    public Order deleteOrder(@PathVariable Long id) {
        return service.deleteOrder(id);
    }
}
