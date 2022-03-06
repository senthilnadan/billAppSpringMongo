package com.vscube.billApp.tools.csv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CommonUtils {
    public static InputStream getInputStreamForFile(String filename) throws FileNotFoundException {
        File file = new File("C:\\Users\\Senth\\Documents\\"+filename);
        InputStream inputStream = new FileInputStream(file);
        return inputStream;
    }
}
