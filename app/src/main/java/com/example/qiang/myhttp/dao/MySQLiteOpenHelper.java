package com.example.qiang.myhttp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 * @author Administrator
 *
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "garden.db";
	private static final String tag ="MySQLiteOpenHelper";


	public MySQLiteOpenHelper(Context context) {
		super(context, DB_NAME, null, 1);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {

		String sql="create table product( _id integer primary key autoincrement, " +
				"product_id varchar(20), " +
				"product_name varchar(20)," +
				"product_number varchar(20)," +
				"product_picture varchar(20)," +
				"product_price varchar(20)," +
				"product_category varchar(20)," +
				"product_special varchar(20)," +
				"product_sort varchar(20)," +
				"product_whether varchar(20)," +
				"product_tuangou varchar(20)," +
				"product_yugu varchar(20)," +
				"product_guige varchar(20));";
		db.execSQL(sql);
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int ordVersion, int newVersion) {

		switch (ordVersion) {
//		case 2:
//			String sql="create table book( _id integer primary key autoincrement,bname varchar(20), bversion integer);";
//			db.execSQL(sql);
//		case 3:
////			String sql="create table person( _id integer primary key autoincrement, name varchar(20),age integer);";
////			db.execSQL(sql);
//			break;

		default:
			break;
		}

	}

}
