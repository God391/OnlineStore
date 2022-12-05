package service;

import pojo.Category;

import java.util.List;

public interface CategoryService {
    String findAll() throws Exception;

    List<Category> findAll2() throws Exception;

    void addUI(String cname) throws Exception;
}
