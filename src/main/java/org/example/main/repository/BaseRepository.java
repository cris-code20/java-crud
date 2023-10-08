package org.example.main.repository;

import java.sql.SQLException;
import java.util.List;

public interface BaseRepository <T>{

    List<T> findAll() throws SQLException;

    T getById(int id) throws SQLException;
    void save(T t) throws SQLException;
    void delete(int id) throws SQLException;

}
