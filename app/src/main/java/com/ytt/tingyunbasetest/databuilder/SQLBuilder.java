package com.ytt.tingyunbasetest.databuilder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ytt.tingyunbasetest.MainActivity;
import com.ytt.tingyunbasetest.util.LogY;

import java.io.File;

public class SQLBuilder {
    private LogY logger=new LogY(this.getClass().getSimpleName());

    //SQLiteDatabase db=SQLiteDatabase.openDatabase(new File("/data/data/com.ytt.tingyunbasetest/database/yttTest.db"),null);
    //不能加/database目录，该目录需要单独创建
    String dirPath="/data/data/com.ytt.tingyunbasetest/";
    SQLiteDatabase db=SQLiteDatabase.openOrCreateDatabase(dirPath+"yttTest.db",null);
    public void createTable(){
        String sq="create table if not exists usertable(_id integer primary key autoincrement,sname text,snumber text)";
        db.execSQL(sq);
    }
    public void insert(){
        ContentValues contentValues=new ContentValues();
        contentValues.put("sname","xiaoming");
        contentValues.put("snumber","10005");
        db.insert("usertable",null,contentValues);
    }
    public void insert(String sname,String snumber){
        ContentValues contentValues=new ContentValues();
        contentValues.put("sname",sname);
        contentValues.put("snumber",snumber);
        db.insert("usertable",null,contentValues);
    }
    public void search(){
        Cursor cursor=db.query("usertable",null,null,null,null,null,null);
        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            int id=cursor.getInt(0);
            String sname=cursor.getString(1);
            String snumber=cursor.getString(2);
            logger.msg(id+" "+sname+" "+snumber);
            }
        if (!cursor.isClosed()) {
            cursor.close();
            }
        }
}
