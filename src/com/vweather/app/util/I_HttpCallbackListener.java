package com.vweather.app.util;

public interface I_HttpCallbackListener {
	void onFinish(String response);
	void onError(Exception e);

}
