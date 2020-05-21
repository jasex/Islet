package com.service;

import com.dao.AnswerDaoImpl;
import com.entities.Answer;

import java.sql.SQLException;
import java.util.Random;

public class AnswerPasserImpl implements AnswerPasser{

    private AnswerPasserImpl(){

    }
    private static AnswerPasserImpl answerPasser;
    public static AnswerPasserImpl getInstance(){
        if(answerPasser==null){
            answerPasser=new AnswerPasserImpl();
        }
        return answerPasser;
    }

    @Override
    public Answer passAnswer() throws SQLException {
        Answer answer;
        AnswerDaoImpl answerDao=AnswerDaoImpl.getInstance();
        answer=answerDao.getAnswerByid(new Random().nextInt(answerDao.getTotal()+1));
        return answer;
    }
}
