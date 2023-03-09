package com.example.controller;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.utils.R;
import com.example.entity.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author : jinye
 * @date : 2023/3/1 20:27
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true, bookService.list());
    }

    @PostMapping
    private R save(@RequestBody Book book) throws IOException{
        boolean flag = bookService.saveBook(book);
        System.out.println(11111323);
        return new R(flag, flag ? "添加成功":"添加失败");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id")Integer id){
        return new R(bookService.delete(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Integer id){
        return new R(true, bookService.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book){

        IPage<Book> iPage = bookService.getPage(currentPage, pageSize, book);
        if (currentPage > iPage.getPages()){
            iPage = bookService.getPage((int)iPage.getPages(), pageSize, book);
        }
        return new R(true, iPage);
    }
}
