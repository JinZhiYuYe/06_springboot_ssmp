package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Book;
import com.example.mapper.BookMapper;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void getById() {
        Book book = bookMapper.selectById(1);
        System.out.println(book);
    }

    @Test
    void save() {
        Book book = new Book();
        book.setType("测试数据123   hot-fix");
        book.setName("safsafsd");
        System.out.println("master 冲突分析");
        book.setDescription("测试wefrwfrwe数据123");
        bookMapper.insert(book);

    }
    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(26);
        book.setType("测试数据123修改");
        book.setName("ttewtwerteg");
        book.setDescription("测试ertyerterrt数据123");
        bookMapper.updateById(book);

    }

    @Test
    void testDelete() {
        bookMapper.deleteById(26);
    }

    @Test
    void getAll() {
        List<Book> books = bookMapper.selectList(null);
        System.out.println(books);
    }

    @Test
    void testGetPage() {
        IPage<Book> ipage = new Page(2, 5);
        bookMapper.selectPage(ipage, null);
        System.out.println(ipage.getCurrent());
        System.out.println(ipage.getSize());
        System.out.println(ipage.getTotal());
        System.out.println(ipage.getPages());
        System.out.println(ipage.getRecords());
    }

    @Test
    void getBy() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "Spring");
        bookMapper.selectList(queryWrapper);
    }

    @Test
    void getBy2() {
        String name = null;
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotEmpty(name), Book::getName, name);
        bookMapper.selectList(queryWrapper);
    }

}
