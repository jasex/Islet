package com.dao;

import com.entities.Relax;

import java.sql.SQLException;

public interface RelaxDao {
    public Relax getPicById(int id)throws SQLException;
}
