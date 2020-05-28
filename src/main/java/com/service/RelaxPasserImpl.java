package com.service;

import com.dao.RelaxDaoImpl;
import com.entities.Relax;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class RelaxPasserImpl implements RelaxPasser { private static QuotePasserImpl quotePasser;
    private static RelaxPasserImpl relaxPasser;
    private RelaxPasserImpl(){

    }
    public static RelaxPasserImpl getInstance(){
        if(relaxPasser==null){
            relaxPasser=new RelaxPasserImpl();
        }
        return relaxPasser;
    }
    @Override
    public ArrayList<Relax> passRelax() throws SQLException {
        RelaxDaoImpl relaxDao=RelaxDaoImpl.getInstance();
        ArrayList<Relax> relaxes=new ArrayList<>();
        for(int i=0;i<3;i++){
            relaxes.add(relaxDao.getPicById(new Random().nextInt(relaxDao.getTotal())+1));
        }
        return relaxes;
    }
}
