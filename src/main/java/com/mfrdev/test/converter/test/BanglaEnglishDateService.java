package com.mfrdev.test.converter.test;

import com.mfrdev.test.converter.BanglaDateUtils;
import com.mfrdev.test.converter.BanglaMonth;
import com.mfrdev.test.converter.Date;

public class BanglaEnglishDateService {
	public static void main(String[] args) {
		Date<BanglaMonth> banglaDate = BanglaDateUtils.getBanglaDate(2023, 10, 30);
		System.out.println(banglaDate);
		//BanglaDateUtils.getEnglishDate(year, month, day);
	}
}
