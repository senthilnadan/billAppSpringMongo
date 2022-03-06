package com.vscube.billApp.tools.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemModelFromOldDB {

    public static final String CUSTOM="custom";

    @CsvBindByName(column = "PM_NAME")
    public String name;
    @CsvBindByName(column = "PM_GROUP")
    public String group;
    @CsvBindByName(column = "PM_CATEGO")
    public String category;
    @CsvBindByName(column = "PM_ISBN")
    public String  isbn;
    @CsvBindByName(column = "PM_AUTHOR")
    public String author ;
    @CsvBindByName(column = "PM_CODE")
    public String code;
    @CsvBindByName(column = "PM_SA_RATE")
    public double rate;




}
