package com.dao;

import com.entities.Relax;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RelaxDaoImpl extends BaseDao implements RelaxDao {
    private static RelaxDaoImpl relaxDao;
    private int total;
    private RelaxDaoImpl() throws SQLException {
        Object[] params={};
        ResultSet resultSet=this.ExecuteQuery( "select count(*) from relax;",params);
        while(rs.next()){
            this.total = resultSet.getInt(1);
        }
    }
    public static RelaxDaoImpl getInstance() throws SQLException {
        if(relaxDao==null){
            relaxDao=new RelaxDaoImpl();
        }
        return relaxDao;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public Relax getPicById(int id) throws SQLException{
       Relax relax=null;
       String sql="select * from relax where id=?";
       Object[] params={id};
       rs=this.ExecuteQuery(sql,params);
       while(rs.next()){
           String pic=rs.getString(2);
           relax=new Relax(pic);
       }
       return relax;
    }
}
