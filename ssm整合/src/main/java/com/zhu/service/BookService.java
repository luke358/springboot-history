package com.zhu.service;

import com.zhu.pojo.Books;
import java.awt.print.Book;
import java.util.List;

public interface BookService {
    //增加一本念书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(int id);
    //更新一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();

    List<Books> queryBookByName(String bookName);

}
