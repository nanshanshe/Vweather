package com.vweather.app.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vweather.app.model.City;
import com.vweather.app.model.County;
import com.vweather.app.model.Province;

public class VWeatherDB {

	/*
	 * database name
	 */
	public static final String DB_NAME = "vweather";
	/*
	 * database version
	 */
	public static final int VERSION = 1;
	private static VWeatherDB vWeatherDB;
	private SQLiteDatabase db;

	/*
	 * private constructor method
	 */
	public VWeatherDB(Context context) {
		// TODO Auto-generated constructor stub
		VWeatherOpenHelp dbHelper = new VWeatherOpenHelp(context, DB_NAME,
				null, VERSION);
		db = dbHelper.getWritableDatabase();
	}

	/*
	 * get vweather instance
	 */
	public synchronized static VWeatherDB getInstance(Context context) {
		if (vWeatherDB == null) {
			vWeatherDB = new VWeatherDB(context);
		}
		return vWeatherDB;
	}

	/*
	 * put province to db
	 */
	public void saveProvicne(Province province) {
		// TODO Auto-generated method stub
		if (province != null) {
			ContentValues values = new ContentValues();
			values.put("provice_name", province.getProvinceName());
			values.put("provice_code", province.getProvinceCode());
			db.insert("Province", null, values);
		}

	}

	/*
	 * get province from db
	 */
	public List<Province> loadProvinces() {
		// TODO Auto-generated method stub
		List<Province> list = new ArrayList<Province>();
		Cursor cursor = db
				.query("Province", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				Province province = new Province();
				province.setId(cursor.getInt(cursor.getColumnIndex("id")));
				province.setProvinceName(cursor.getString(cursor
						.getColumnIndex("provice_name")));
				province.setProvinceCode(cursor.getString(cursor
						.getColumnIndex("provice_code")));
				list.add(province);

			} while (cursor.moveToNext());
		}
		return list;

	}

	/*
	 * put city to db
	 */

	public void saveCity(City city) {
		// TODO Auto-generated method stub
		if (city != null) {
			ContentValues values = new ContentValues();
			values.put("city_name", city.getCityName());
			values.put("city_Code", city.getCityCode());
			values.put("province_id", city.getProvinceId());
			db.insert("City", null, values);
		}

	}

	/*
	 * get city from db
	 */
	public List<City> loadCities() {
		// TODO Auto-generated method stub
		List<City> list = new ArrayList<City>();
		Cursor cursor = db.query("City", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				City city = new City();
				city.setId(cursor.getInt(cursor.getColumnIndex("id")));
				city.setCityName(cursor.getString(cursor
						.getColumnIndex("city_name")));
				city.setProvinceId(cursor.getInt(cursor
						.getColumnIndex("province_id")));
				list.add(city);

			} while (cursor.moveToNext());

		}
		return list;

	}

	/*
	 * put county to db
	 */
	public void saveCounty(County county) {
		if (county != null) {
			ContentValues values = new ContentValues();
			values.put("county_name", county.getCountyName());
			values.put("county_code", county.getCountyCode());
			values.put("city_id", county.getCityId());
			db.insert("County", null, values);

		}

	}

	/*
	 * get county from db
	 */
	public List<County> loadCounties() {
		List<County> list = new ArrayList<County>();
		Cursor cursor = db.query("County", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				County county = new County();
				county.setId(cursor.getInt(cursor.getColumnIndex("id")));
				county.setCountyName(cursor.getString(cursor
						.getColumnIndex("county_name")));
				county.setCountyCode(cursor.getString(cursor
						.getColumnIndex("county_code")));
				county.setCityId(cursor.getInt(cursor.getColumnIndex("city_id")));
				list.add(county);

			} while (cursor.moveToNext());
		}
		return list;
	}
}