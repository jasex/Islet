package com.service;

import com.dao.TreeDaoImpl;
import com.entities.Tree;

import java.sql.SQLException;
import java.util.Random;

public class TreePasserImpl implements TreePasser {
    private TreePasserImpl(){

    }
    private static TreePasserImpl treePasser;
    public static TreePasserImpl getInstance(){
        if(treePasser==null){
            treePasser=new TreePasserImpl();
        }
        return treePasser;
    }

    @Override
    public Tree getRandomTree() throws SQLException {
        TreeDaoImpl treeDao=TreeDaoImpl.getInstance();
        Tree tree=treeDao.getTreeNoteByid(new Random().nextInt(treeDao.getTotal()+1));
        return tree;
    }
}
