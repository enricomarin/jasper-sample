package it.larus.jasper_sample.builder;

import java.io.File;
import java.util.Collection;

import it.larus.jasper_sample.bean.FieldBean;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class SampleReportBuilder
{
  public static void buildPdf(File jasperFileSource, Collection<FieldBean> fields, String nomeReport) throws JRException, IllegalArgumentException
  {
    if(fields == null)
    {
    	throw new IllegalArgumentException("Fields not initialized");
    }
    JasperDesign jasperDesign = JRXmlLoader.load(jasperFileSource);
     
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
      
    JRBeanCollectionDataSource jrDataSource = new JRBeanCollectionDataSource(fields);
     
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
      
    JasperExportManager.exportReportToPdfFile(jasperPrint, nomeReport);
  }
}
