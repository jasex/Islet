package com.service.util;

import com.entities.Relax;

import java.util.ArrayList;

public class ParsePics {
    public static String parsePic(ArrayList<Relax> relaxes){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(Relax relax:relaxes){
            sb.append("'");
            sb.append(relax.getPic());
            sb.append("'");
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }



}
