package com.hiranwj.excel_export.controller;

import com.hiranwj.excel_export.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/excel")
    public void generateExcelReport(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=course.xls";

        response.setHeader(headerKey, headerValue);

        reportService.generateExcel(response);
    }
}
