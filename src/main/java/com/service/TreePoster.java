package com.service;

import com.entities.Tree;

import java.sql.SQLException;

public interface TreePoster {
    public int postTree(Tree tree) throws SQLException;
}
