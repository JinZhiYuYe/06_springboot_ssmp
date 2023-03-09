package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Book;
import org.springframework.stereotype.Service;


public interface IBookService extends IService<Book> {

    boolean saveBook(Book book);

    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);

    boolean delete(Integer id);
}
