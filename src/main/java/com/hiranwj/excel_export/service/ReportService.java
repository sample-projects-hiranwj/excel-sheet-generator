package com.hiranwj.excel_export.service;

import com.hiranwj.excel_export.model.Course;
import com.hiranwj.excel_export.repository.CourseRepository;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private CourseRepository courseRepository;

    public void generateExcel(HttpServletResponse response) throws IOException {
        List<Course> courseList = courseRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Course Info");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Name");
        row.createCell(2).setCellValue("Price");

        int dataRowIndex = 1;

        for (Course course : courseList) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(course.getCid());
            dataRow.createCell(1).setCellValue(course.getName());
            dataRow.createCell(2).setCellValue(course.getPrice());
            dataRowIndex++;
        }
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

//        for (int i = 0; i < courseList.size(); i++) {
//            Course course = courseList.get(i);
//            HSSFRow dataRow = sheet.createRow(dataRowIndex);
//            dataRow.createCell(0).setCellValue(course.getCid());
//            dataRow.createCell(1).setCellValue(course.getCname());
//            dataRow.createCell(2).setCellValue(course.getPrice());
//            dataRowIndex++;
//        }
    }
}
