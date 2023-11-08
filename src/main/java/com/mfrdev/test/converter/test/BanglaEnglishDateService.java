package com.mfrdev.test.converter.test;

import com.mfrdev.test.converter.BanglaDateUtils;
import com.mfrdev.test.converter.BanglaMonth;
import com.mfrdev.test.converter.Date;
import com.mfrdev.test.converter.EnglishMonth;

public class BanglaEnglishDateService {
	public static void main(String[] args) {
		Date<BanglaMonth> banglaDate = BanglaDateUtils.getBanglaDate(2022, 2, 4);
		System.out.println(banglaDate);
		BanglaMonth month = banglaDate.getMonth();
		System.out.println(month.getBanglaName());

		Date<EnglishMonth> englishDate = BanglaDateUtils.getEnglishDate(1428, 10, 21);
		System.out.println(englishDate);
	}
}
