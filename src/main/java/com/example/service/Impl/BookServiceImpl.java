package com.example.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Book;
import com.example.mapper.BookMapper;
import com.example.service.IBookService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : jinye
 * @date : 2023/3/1 20:16
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    private Counter counter;

    public BookServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("用户付费操作次数：");
    }

    @Override
    public boolean saveBook(Book book) {
       return bookMapper.insert(book) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> iPage = new Page<>(currentPage, pageSize);
        bookMapper.selectPage(iPage, null);
        return iPage;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> query = new LambdaQueryWrapper<>();
        query.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        query.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        query.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        IPage<Book> iPage = new Page<>(currentPage, pageSize);
        bookMapper.selectPage(iPage, query);
        return iPage;
    }

    @Override
    public boolean delete(Integer id) {
        // 每次执行删除等同于执行了付费操作
        counter.increment();
        return bookMapper.deleteById(id) > 0;
    }
}
