package service;

import model.CategoryShoes;

import java.sql.SQLException;
import java.util.List;

public interface ICategory {

    public List<CategoryShoes> findAll();

    public  void  insert(CategoryShoes categoryShoes) throws Exception;

    public boolean updateCategory( CategoryShoes categoryShoes) throws SQLException;

    public boolean deleteCategory(int id) throws SQLException;

}
