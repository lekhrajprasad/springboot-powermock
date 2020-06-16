package com.lpras.sb.pmock.simple;

import com.lpras.sb.pmock.simple.AddService;

public class AddServiceImpl implements AddService {
	@Override
	public int add(int num1, int num2) {
		System.out.println("**--- AddServiceImpl add executed ---**");
		return num1 + num2;
	}
}