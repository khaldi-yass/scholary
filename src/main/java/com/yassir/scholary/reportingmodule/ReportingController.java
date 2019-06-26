package com.yassir.scholary.reportingmodule;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/report")
public class ReportingController {

    private static final String APPLICATION_X_DOWNLOAD = "application/x-download";
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    @Autowired
    ReportingService reportingService;

    @GetMapping("/pdf")
    public String getPdf(HttpServletResponse response) throws JRException, IOException {
        long start = System.currentTimeMillis();
        JasperPrint jasperPrint = reportingService.fillReport();
        response.setContentType(APPLICATION_X_DOWNLOAD);
        response.setHeader(CONTENT_DISPOSITION, "attachment; filename=\"Report.pdf\"");
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        return "File generated in : " + (System.currentTimeMillis() - start) / 1000 + " s.";
    }

    @GetMapping("/xml")
    public String getXml(HttpServletResponse response) throws JRException, IOException {
        long start = System.currentTimeMillis();
        JasperPrint jasperPrint = reportingService.fillReport();
        response.setContentType(APPLICATION_X_DOWNLOAD);
        response.setHeader(CONTENT_DISPOSITION, "attachment; filename=\"Report.xml\"");
        JasperExportManager.exportReportToXmlStream(jasperPrint, response.getOutputStream());
        return "File generated in : " + (System.currentTimeMillis() - start) / 1000 + " s.";
    }

    @GetMapping("/xlsx")
    public String getXlsx(HttpServletResponse response) throws JRException, IOException {
        long start = System.currentTimeMillis();
        JasperPrint jasperPrint = reportingService.fillReport();
        response.setContentType(APPLICATION_X_DOWNLOAD);
        response.setHeader(CONTENT_DISPOSITION, "attachment; filename=\"Report.xlsx\"");
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
        exporter.exportReport();
        return "File generated in : " + (System.currentTimeMillis() - start) / 1000 + " s.";
    }

    @GetMapping("/pptx")
    public String getPptx(HttpServletResponse response) throws JRException, IOException {
        long start = System.currentTimeMillis();
        JasperPrint jasperPrint = reportingService.fillReport();
        response.setContentType(APPLICATION_X_DOWNLOAD);
        response.setHeader(CONTENT_DISPOSITION, "attachment; filename=\"Report.pptx\"");
        JRPptxExporter exporter = new JRPptxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
        exporter.exportReport();
        return "File generated in : " + (System.currentTimeMillis() - start) / 1000 + " s.";

    }
}
