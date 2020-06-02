package com.service;

import com.dao.TreeDaoImpl;
import com.entities.Tree;

import java.sql.SQLException;

public class TreePosterImpl implements TreePoster {
    private static TreePosterImpl treePoster;
    private TreePosterImpl(){

    }

    public static TreePosterImpl getInstance(){
        if(treePoster==null){
            treePoster=new TreePosterImpl();
        }
        return treePoster;
    }

    @Override
    public int postTree(Tree tree) throws SQLException {
        TreeDaoImpl treeDao=TreeDaoImpl.getInstance();
        return treeDao.postTree(tree);
    }
}
