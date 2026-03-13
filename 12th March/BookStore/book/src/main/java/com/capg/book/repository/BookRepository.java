package com.capg.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.book.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}
