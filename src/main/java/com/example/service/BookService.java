package com.example.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.entity.Book;

import java.util.List;

/**
 * @author : jinye
 * @date : 2023/3/1 20:01
 */
public interface BookService {

    boolean save(Book book);

    boolean update(Book book);

    boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getPage(int currentPage, int pageSize);
}
