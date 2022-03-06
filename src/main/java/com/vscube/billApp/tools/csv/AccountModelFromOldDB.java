package com.vscube.billApp.tools.csv;

import com.opencsv.bean.CsvBindByName;

public class AccountModelFromOldDB {
    @CsvBindByName(column = "AM_NAME")
    public String name;
    @CsvBindByName(column = "AM_ADDRESS")
    public String address;
    @CsvBindByName(column = "AM_PHONE")
    public String phone;
    @CsvBindByName(column = "AM_FAX")
    public String  fax;
    @CsvBindByName(column = "AM_CSTNO")
    public String GST ;
    @CsvBindByName(column = "AM_CODE")
    public String code;
    @CsvBindByName(column = "PM_CONTACT")
    public String contact;
}
