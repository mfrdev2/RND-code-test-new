package com.mfrdev.test.converter;


public enum BanglaMonth {
	BOISHAKH("বৈশাখ"),
	JYOISHTHO("জ্যৈষ্ঠ"),
	ASHARH("আষাঢ়"),
	SHRABON("শ্রাবণ"),
	BHADRO("ভাদ্র"),
	ASHBIN("আশ্বিন"),
	KARTIK("কার্তিক"),
	OGROHAYON("অগ্রহায়ণ"),
	POUSH("পৌষ"),
	MAGH("মাঘ"),
	FALGUN("ফাল্গুন"),
	CHOITRO("চৈত্র");
	
	private final String banglaName;
	
	BanglaMonth(String banglaName){
		this.banglaName = banglaName;
	}
	
	public String getBanglaName() {
		return banglaName;
	}
}