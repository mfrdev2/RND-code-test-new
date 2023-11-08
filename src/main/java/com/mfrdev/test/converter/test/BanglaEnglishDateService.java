package com.mfrdev.test.converter.test;

import com.mfrdev.test.converter.BanglaDateUtils;
import com.mfrdev.test.converter.BanglaMonth;
import com.mfrdev.test.converter.Date;
import com.mfrdev.test.converter.EnglishMonth;

public class BanglaEnglishDateService {
	public static void main(String[] args) {
		for (int i = 1; i <=12 ; i++) {
			Date<BanglaMonth> banglaDate = BanglaDateUtils.getBanglaDate(2022, i, 20);
			System.out.println(banglaDate);
			BanglaMonth month = banglaDate.getMonth();
			System.out.println(month.getBanglaName()+"["+i+"]");

			System.out.println();

		}


		Date<EnglishMonth> englishDate = BanglaDateUtils.getEnglishDate(1430, 12, 30);
		System.out.println(englishDate);
	}
}
