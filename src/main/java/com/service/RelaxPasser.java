package com.service;

import com.entities.Relax;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RelaxPasser {
   public ArrayList<Relax> passRelax() throws SQLException;
}
