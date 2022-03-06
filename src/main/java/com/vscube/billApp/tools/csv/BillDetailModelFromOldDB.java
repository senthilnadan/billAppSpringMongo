package com.vscube.billApp.tools.csv;

import com.opencsv.bean.CsvBindByName;

public class BillDetailModelFromOldDB {
    @CsvBindByName(column = "SI_NUMBER")
    public long invoiceNumber;
    @CsvBindByName(column = "SI_PRO_CD")
    public String productCode;
    @CsvBindByName(column = "SI_PRO_NM")
    public String productName;
    @CsvBindByName(column = "SI_QTY")
    public long itemQuantity;
    @CsvBindByName(column = "SI_RATE")
    public double itemRate;
    @CsvBindByName(column = "SI_MRP")
    public double itemMRP;
    @CsvBindByName(column = "SI_AMOUNT")
    public double lineAmount;
    @CsvBindByName(column = "SI_PGP_NM")
    public String publisherName;
    @CsvBindByName(column = "IH_QTY")
    public long totalQuantity;
    @CsvBindByName(column = "SI_SA_TYPE")
    public String  type;
    @CsvBindByName(column = "SI_BIL_NO")
    public long  billNo;
    @CsvBindByName(column = "SI_BIL_DT")
    public String  bill_dt;
    @CsvBindByName(column = "SI_CUS_CD")
    public String  customerCode;
    @CsvBindByName(column = "SI_CUS_NM")
    public String  customerName;
    @CsvBindByName(column = "SI_ITEMNO")
    public long  itemNo;

}
