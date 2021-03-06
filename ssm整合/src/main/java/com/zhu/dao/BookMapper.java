package com.zhu.dao;

import com.zhu.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

public interface BookMapper {

    //增加一本念书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookId") int id);
    //更新一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookById(@Param("bookId")int id);

    //查询全部的书
    List<Books> queryAllBook();

    List<Books> queryBookByName(@Param("bookName") String bookName);
}
