package com.service;

import com.entities.Tree;

import java.sql.SQLException;

public interface TreePasser {
    public Tree getRandomTree() throws SQLException;
}
