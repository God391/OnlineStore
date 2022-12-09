package service;

import pojo.Category;


import java.util.List;

public interface CategoryService {
    String findAll() throws Exception;

    Category queryById(String cid) throws Exception;

}
