package service;

import pojo.Category;

public interface CategoryService {
    String findAll() throws Exception;

    Category queryById(String cid) throws Exception;
}
