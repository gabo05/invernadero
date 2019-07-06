package invernadero.reports;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
 
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

import invernadero.models.*;

public class ReportGenerator {
    public void generateOrden60Report(List<Orden60> data) {
        try {
            String[] columns = {"Tiempo", "Carro", "Fardos", "Bloque"};
            // Create a Workbook
            HSSFWorkbook workbook = new HSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

            // Create a Sheet
            HSSFSheet sheet = workbook.createSheet("Orden60");

            // Create a Row
            HSSFRow headerRow = sheet.createRow(0);

            // Create cells
            for(int i = 0; i < columns.length; i++) {
                headerRow.createCell(i).setCellValue(columns[i]);
            }

            // Create Other rows and cells with employees data
            int rowNum = 1;
            for(Orden60 orden: data) {
                HSSFRow row = sheet.createRow(rowNum++);

                row.createCell(0)
                    .setCellValue(orden.getTiempo());

                row.createCell(1)
                    .setCellValue(orden.getCarro());

                row.createCell(2)
                    .setCellValue(orden.getFardos());

                row.createCell(2)
                    .setCellValue(orden.getBloque());
            }

            // Resize all columns to fit the content size
            for(int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream("Orden60.xls");
            workbook.write(fileOut);
            fileOut.close();

            // Closing the workbook
            // workbook.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void generateOrden64Report(List<Orden64> data) {
        try {
            String[] columns = {"Tiempo", "Carro", "Fardos", "Seccion"};
            // Create a Workbook
            HSSFWorkbook workbook = new HSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

            // Create a Sheet
            HSSFSheet sheet = workbook.createSheet("Orden64");

            // Create a Row
            HSSFRow headerRow = sheet.createRow(0);

            // Create cells
            for(int i = 0; i < columns.length; i++) {
                headerRow.createCell(i).setCellValue(columns[i]);
            }

            // Create Other rows and cells with employees data
            int rowNum = 1;
            for(Orden64 orden: data) {
                HSSFRow row = sheet.createRow(rowNum++);

                row.createCell(0)
                    .setCellValue(orden.getTiempo());

                row.createCell(1)
                    .setCellValue(orden.getCarro());

                row.createCell(2)
                    .setCellValue(orden.getFardos());

                row.createCell(2)
                    .setCellValue(orden.getSeccion());
            }

            // Resize all columns to fit the content size
            for(int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream("Orden64.xls");
            workbook.write(fileOut);
            fileOut.close();

            // Closing the workbook
            // workbook.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}