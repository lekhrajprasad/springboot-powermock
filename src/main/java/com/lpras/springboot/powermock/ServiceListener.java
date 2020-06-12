package com.lpras.springboot.powermock;

public interface ServiceListener {
	void onSuccess(Service service);
	void onFailure(Service service);
}
