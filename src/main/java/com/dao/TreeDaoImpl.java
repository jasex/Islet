package com.dao;

import com.entities.Quote;
import com.entities.Tree;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TreeDaoImpl extends BaseDao implements TreeDao{
    private static TreeDaoImpl treeDao;
    private int total;


    public static TreeDaoImpl getInstance() throws SQLException {
        if(treeDao==null){
            treeDao=new TreeDaoImpl();
        }
        return treeDao;
    }

    /**
     * 在构造方法中初始化total
     * @throws SQLException
     */
    private TreeDaoImpl() throws SQLException {
        Object[] params={};
        ResultSet resultSet=this.ExecuteQuery("select count(*) from tree;",params);
        while(rs.next()) {
            this.total = resultSet.getInt(1);
        }
    }

    @Override
    public Tree getTreeNoteByid(int id) throws SQLException {
        Tree tree=null;
        String sql="select * from tree where id=?;";
        Object[] params={id};
        rs=this.ExecuteQuery(sql,params);
        while(rs.next()){
            int Id=rs.getInt(1);
            String line=rs.getString(2);
            int likes=rs.getInt(5);
            tree=new Tree(Id,line,likes);
        }
        return tree;
    }

    @Override
    public int insertNote(Tree tree) {
        return 0;
    }

    public int getTotal() {
        return total;
    }
}
