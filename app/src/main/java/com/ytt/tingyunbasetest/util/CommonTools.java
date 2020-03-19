package com.ytt.tingyunbasetest.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CommonTools {
    public static LogY logger=new LogY("CommonTools");
    public static String readFile(File f){
        String string = "";
        if(f.exists()){
            if(!f.isDirectory()){
                String tmp;
                try {
                    BufferedReader reader=new BufferedReader(new FileReader(f));
                    while ((tmp=reader.readLine())!=null){
                        //logger.msg(tmp);
                        string=string.concat(tmp).concat("\n");
                        //logger.msg(string);
                    }
                    reader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                logger.warning(f.getName()+" is not a file");
            }
        }else {
            logger.warning(f.getName()+" not exist");
        }
        //int l=string.length();
        //logger.warning("str length:"+l+";str end with"+string.charAt(l-2));
        logger.msg(string);
        return string;
    }
    public static void wait(int second_count){
        try {
            Thread.sleep(second_count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
