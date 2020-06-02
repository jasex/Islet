package com.dao;

import com.entities.Tree;

import java.sql.SQLException;

public interface TreeDao {
    public int postTree(Tree tree);
    public Tree getTreeNoteByid(int id) throws SQLException;
}
