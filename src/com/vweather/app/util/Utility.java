package com.vweather.app.util;

import android.text.TextUtils;

import com.vweather.app.db.VWeatherDB;
import com.vweather.app.model.City;
import com.vweather.app.model.County;
import com.vweather.app.model.Province;

public class Utility {
	public synchronized static boolean handleProvincesResponse(
			VWeatherDB vWeatherDB, String response) {
		if (!TextUtils.isEmpty(response)) {
			String[] allProvinces = response.split(",");
			if (allProvinces != null && allProvinces.length > 0) {
				for (String s : allProvinces) {
					String[] array = s.split("\\|");
					Province province = new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					vWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	public synchronized static boolean handleCitiesResponse(VWeatherDB vWeatherDB,String response,int provinceId){
		if(!TextUtils.isEmpty(response)){
			String[] allCities = response.split(",");
			if (allCities !=null && allCities.length>0){
				for(String s : allCities){
					String[] array = s.split("\\|");
					City city = new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					vWeatherDB.saveCity(city);
			
				}
			
				return true;
			}
			
		}
		return false;
	}
	
	public synchronized static boolean handleCountiesResponse(VWeatherDB vWeatherDB,String response,int cityId){
		if(!TextUtils.isEmpty(response)){
			String[] allCounties = response.split(",");
			if(allCounties != null && allCounties.length>0){
				for(String s:allCounties){
					String[] array = s.split("\\|");
					County county = new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					vWeatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;
	}
	
}
