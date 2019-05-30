package com.yassir.scholary.reporting;

import com.yassir.scholary.reporting.datasources.CustomDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportingService {

    @Value("${scholary.jasperpath}")
    Resource jasperRes;

    public JasperPrint fillReport() throws JRException, IOException {
        //Preparing parameters
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ReportTitle", "Address Report");
        parameters.put("DataFile", "CustomDataSource.java");
        return JasperFillManager.fillReport(jasperRes.getFile().getAbsolutePath(), parameters, new CustomDataSource());

    }
}
