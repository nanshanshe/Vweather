package com.vweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class VWeatherOpenHelp extends SQLiteOpenHelper {
	/*
	 * create province table
	 */

	public static final String CREATE_PROVINCE = "create table province ("
			+ "id integer primary key autoincrement," + "province_name text,"
			+ "province_code text)";

	/*
	 * create city table
	 */
	public static final String CREATE_CITY = "create table city("
			+ "id integer primary key autoincerement," + "city_name text,"
			+ "city_code text," + "province_id integer)";

	/*
	 * create county table
	 */
	public static final String CREATE_COUNTY = "create table county("
			+ "id integer primary key autoincrement," + "county_name text,"
			+ "county_code text," + "city_id integer)";
	public VWeatherOpenHelp(Context context,String name,CursorFactory factory,int version) {
		// TODO Auto-generated constructor stub
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_PROVINCE);
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_COUNTY);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		

	}

}
