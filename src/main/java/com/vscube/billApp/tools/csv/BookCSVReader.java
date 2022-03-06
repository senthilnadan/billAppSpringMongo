package com.vscube.billApp.tools.csv;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.vscube.billApp.tools.csv.CommonUtils.getInputStreamForFile;

public class BookCSVReader {

    public static List<ItemModelFromOldDB> parseCSVWithHeader(String filename) throws FileNotFoundException {
        CSVReader reader = null;
        reader = new CSVReader(new InputStreamReader(getInputStreamForFile(filename)));
        List<ItemModelFromOldDB> itemModelFromOldDBList = new ArrayList<>();
        CsvToBean<ItemModelFromOldDB> csvToBean = new CsvToBeanBuilder(reader).withType(ItemModelFromOldDB.class).withIgnoreLeadingWhiteSpace(true).build();

        Iterator<ItemModelFromOldDB> iterator = csvToBean.iterator();

        while(iterator.hasNext()){
            itemModelFromOldDBList.add(iterator.next());
        }
        return itemModelFromOldDBList;
    }

    public static List<AccountModelFromOldDB> parseCSVWithHeaderForAccount(String filename) throws FileNotFoundException {
        CSVReader reader = null;
        reader = new CSVReader(new InputStreamReader(getInputStreamForFile(filename)));
        List<AccountModelFromOldDB> itemModelFromOldDBList = new ArrayList<>();
        CsvToBean<AccountModelFromOldDB> csvToBean = new CsvToBeanBuilder(reader).withType(AccountModelFromOldDB.class).withIgnoreLeadingWhiteSpace(true).build();

        Iterator<AccountModelFromOldDB> iterator = csvToBean.iterator();

        while(iterator.hasNext()){
            itemModelFromOldDBList.add(iterator.next());
        }
        return itemModelFromOldDBList;
    }

    public static List<BillHeaderModelFromOldDB> parseCSVWithHeaderForBillHeader(String filename) throws FileNotFoundException {
        CSVReader reader = null;
        reader = new CSVReader(new InputStreamReader(getInputStreamForFile(filename)));
        List<BillHeaderModelFromOldDB> itemModelFromOldDBList = new ArrayList<>();
        CsvToBean<BillHeaderModelFromOldDB> csvToBean = new CsvToBeanBuilder(reader).withType(BillHeaderModelFromOldDB.class).withIgnoreLeadingWhiteSpace(true).build();

        Iterator<BillHeaderModelFromOldDB> iterator = csvToBean.iterator();

        while(iterator.hasNext()){
            itemModelFromOldDBList.add(iterator.next());
        }
        return itemModelFromOldDBList;
    }

    public static  List<BillDetailModelFromOldDB> parseCSVWithHeaderForBillDetail(String filename) throws FileNotFoundException {
        CSVReader reader = null;
        reader = new CSVReader(new InputStreamReader(getInputStreamForFile(filename)));
        List<BillDetailModelFromOldDB> itemModelFromOldDBList = new ArrayList<>();
        CsvToBean<BillDetailModelFromOldDB> csvToBean = new CsvToBeanBuilder(reader).withType(BillDetailModelFromOldDB.class).withIgnoreLeadingWhiteSpace(true).build();

        Iterator<BillDetailModelFromOldDB> iterator = csvToBean.iterator();

        while(iterator.hasNext()){
            itemModelFromOldDBList.add(iterator.next());
        }
        return itemModelFromOldDBList;
    }
}
