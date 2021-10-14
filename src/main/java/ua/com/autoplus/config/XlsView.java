package ua.com.autoplus.config;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import ua.com.autoplus.entity.Warehouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class XlsView extends AbstractXlsView {

    @Override
    public void buildExcelDocument(Map model, Workbook workbook, HttpServletRequest request,
                                   HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment; filename=\"users.xls\"");

        @SuppressWarnings("unchecked")
       Warehouse warehouse = (Warehouse) model.get("warehouse");

        Sheet sheet = workbook.createSheet("Users Xls");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Id");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Address");


            Row fruitRow = sheet.createRow(1);
            fruitRow.createCell(0).setCellValue(warehouse.getId());
            fruitRow.createCell(1).setCellValue(warehouse.getName());
            fruitRow.createCell(2).setCellValue(warehouse.getAddress());

    }
}

