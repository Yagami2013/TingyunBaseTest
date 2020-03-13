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
                        string=string.concat(tmp);
                    }
                    reader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                logger.err(f.getName()+" is not a file");
            }
        }else {
            logger.err(f.getName()+" not exist");
        }
        return string;
    }
}
