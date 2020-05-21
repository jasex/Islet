package com.dao;

import com.entities.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    public ArrayList<User> getUserByUserName(String name) throws SQLException;
}
