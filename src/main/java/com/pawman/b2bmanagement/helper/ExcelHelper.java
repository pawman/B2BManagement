package com.pawman.b2bmanagement.helper;

import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ExcelHelper {

    public static void fillExcelFile() throws IOException {
        File file = new File("");
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheetAt(0);

        sheet.getRow(0).getCell(0).setCellValue("");


    }

    public static void saveXls() throws Exception {
        String pathname = "C:\\Users\\pawman\\Desktop\\123.xlsx";
        File file = new File(pathname);
     //   FileInputStream inputStream = new FileInputStream(file);

     //   XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        Workbook workbook = new Workbook(pathname);
        PdfSaveOptions options = new PdfSaveOptions();
        options.setPageIndex(1);
        options.setPageCount(2);

        workbook.save( "C:\\Users\\pawman\\Desktop\\123.pdf", options);
    }


}
