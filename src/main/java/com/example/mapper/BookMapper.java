package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : jinye
 * @date : 2023/3/1 13:46
 */

@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
