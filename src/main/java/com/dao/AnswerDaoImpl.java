package com.dao;

import com.entities.Answer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerDaoImpl extends BaseDao implements AnswerDao{
    private static AnswerDaoImpl answerDao;
    private int total;

    public static AnswerDaoImpl getInstance() throws SQLException {
        if(answerDao==null){
            answerDao=new AnswerDaoImpl();
        }
        return answerDao;
    }


    private AnswerDaoImpl() throws SQLException {
        Object[] params={};
        ResultSet resultSet=this.ExecuteQuery( "select count(*) from answer;",params);
        while(rs.next()){
            this.total = resultSet.getInt(1);
        }
    }


    /**
     * 根据id获取answer的方法
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Answer getAnswerByid(int id) throws SQLException {
        Answer answer=null;
        String sql="select * from answer where id=?;";
        Object[] params={id};
        rs=this.ExecuteQuery(sql,params);
        while(rs.next()){
            String content=rs.getString(2);
            answer=new Answer(id,content);
        }
        return answer;
    }

    public int getTotal() {
        return total;
    }


}
