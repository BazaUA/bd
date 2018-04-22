package com.bazalyskyi.school.controller;

import com.bazalyskyi.school.entity.Pupils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;




public class ExcelReportView extends AbstractXlsView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment;filename=\"pupil.xls\"");
        List<Pupils> pupils = (List<Pupils>) model.get("pupils");
        Sheet sheet = workbook.createSheet("Pupil Data");
        sheet.setDefaultColumnWidth(30);
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Pupil ID");
        header.createCell(1).setCellValue("Pupil Name");
        header.createCell(2).setCellValue("Pupil Surname");
        header.createCell(3).setCellValue("Pupil Midlename");
        header.createCell(4).setCellValue("Pupil Sex");
        header.createCell(5).setCellValue("Pupil Meadl");

        int rowNum = 1;
        for(Pupils student:pupils){
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(student.getId());
            row.createCell(1).setCellValue(student.getName());
            row.createCell(2).setCellValue(student.getSurname());
            row.createCell(3).setCellValue(student.getMidlename());
            row.createCell(4).setCellValue(student.getSex());
            row.createCell(5).setCellValue(student.getMedal());
        }
    }
}