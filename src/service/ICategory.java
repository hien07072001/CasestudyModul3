package service;

import model.CategoryShoes;

import java.sql.SQLException;
import java.util.List;

public interface ICategory {

    public List<CategoryShoes> findAll();

    public  void  insert(CategoryShoes categoryShoes) throws Exception;

    public boolean update(int id, CategoryShoes categoryShoes) throws SQLException;

    public boolean delete(int id) throws SQLException;

}
