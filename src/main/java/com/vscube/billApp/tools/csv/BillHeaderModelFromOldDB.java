package com.vscube.billApp.tools.csv;

import com.opencsv.bean.CsvBindByName;

public class BillHeaderModelFromOldDB {
    @CsvBindByName(column = "IH_NUMBER")
    public long headerNumber;
    @CsvBindByName(column = "IH_ONUM")
    public long orderNumber;
    @CsvBindByName(column = "IH_SA_TYPE")
    public String type;
    @CsvBindByName(column = "IH_ITEMS")
    public String noItems;
    @CsvBindByName(column = "IH_BIL_DT")
    public String bill_date;
    @CsvBindByName(column = "IH_BIL_NO")
    public long bill_number;
    @CsvBindByName(column = "IH_DC_DT")
    public String dc_date;
    @CsvBindByName(column = "IH_CUS_CD")
    public String customerCode;
    @CsvBindByName(column = "IH_QTY")
    public long totalQuantity;
    @CsvBindByName(column = "IH_MRPAMT")
    public double  mrpAmount;
    @CsvBindByName(column = "IH_BILAMT")
    public double  billAmount;
    @CsvBindByName(column = "IH_DISC")
    public double  discount;
    @CsvBindByName(column = "IH_CA_DISC")
    public double  discountCash;
    @CsvBindByName(column = "IH_NTAXSAL")
    public double  salesAmount;
    @CsvBindByName(column = "IH_GROSS")
    public double  grossAmount;
    @CsvBindByName(column = "IH_ROUND")
    public double  rountAmount;
    @CsvBindByName(column = "IH_NETAMT")
    public double  netAmount;
    @CsvBindByName(column = "IH_BALANCE")
    public double  balAmount;
    @CsvBindByName(column = "IH_DIFAMT")
    public double  discountAmount;
    @CsvBindByName(column = "IH_UPDATE")
    public String updatedDate;
    @CsvBindByName(column = "IH_UPTIME")
    public String updatedTime;
}
