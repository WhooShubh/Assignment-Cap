package com.capg.order.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.order.dto.Book;
import com.capg.order.dto.BookDto;
import com.capg.order.entity.Order;
import com.capg.order.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository repo;
    
    @Autowired
	private ConversionClass con;

    @Autowired
    BookFeignClientService bookService;

    public Order createOrder(Order order) {
    	Book book = bookService.getBookById(order.getBookId());
        
        BookDto dto = con.convertFromBooktoDto(book);
        
        order.setTotalPrice(dto.getPrice() * order.getQuantity());
        		
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        return repo.save(order);
    }

    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    public Order getOrderById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Order updateOrderStatus(Long id, String status) {
        Order order = repo.findById(id).orElseThrow();
        order.setStatus(status);

        return repo.save(order);
    }

    public Order deleteOrder(Long id) {
        Order order = repo.findById(id).orElseThrow();
        order.setStatus("CANCELLED");

        return repo.save(order);
    }
}
