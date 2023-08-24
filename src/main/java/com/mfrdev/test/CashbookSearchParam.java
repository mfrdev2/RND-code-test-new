package com.mfrdev.test;

public enum CashbookSearchParam {
    TABLE_TYPE("table_type"),
    FUND_SOURCE("fund_source"),
    FINANCIAL_CODES("financial_codes"),
    PAYER_ID("payer_id"),
    TEAM_ID("team_id"),
    VENDER_NAME("vender_name"),
    FROM_DATE("from_date"),
    TO_DATE("to_date");
    String value;
    CashbookSearchParam(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
