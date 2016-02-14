package it.larus.jasper_sample;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import it.larus.jasper_sample.bean.FieldBean;
import it.larus.jasper_sample.builder.SampleReportBuilder;
import junit.framework.Assert;
import net.sf.jasperreports.engine.JRException;

/**
 * Unit test for simple App.
 */
public class JasperSampleTest 
{   
  @Test(expected=JRException.class)
  public void jasperSampleNoInputFile() throws JRException, IllegalArgumentException
  {
    Collection<FieldBean> fields = new ArrayList<FieldBean>();
    SampleReportBuilder.buildPdf(new File(""), fields, "target/report.pdf");
  }

  @Test(expected=IllegalArgumentException.class)
  public void jasperSampleNoFieldsTest() throws JRException, IllegalArgumentException
  {
	File inputFileJasper = new File("src/test/reports/testingReport.jrxml");
	String nomeFileReport = "target/report.pdf";
	SampleReportBuilder.buildPdf(inputFileJasper, null, nomeFileReport);
	File fileOutput = new File (nomeFileReport);
	Assert.assertTrue(fileOutput.exists());
	Assert.assertTrue(fileOutput.length() > 0L);
	FileUtils.deleteQuietly(fileOutput);
  }
  
  @Test
  public void jasperSampleTestOk() throws JRException, IllegalArgumentException
  {
	File inputFileJasper = new File("src/test/reports/testingReport.jrxml");
	Collection<FieldBean> fields = new ArrayList<FieldBean>();
	String nomeFileReport = "target/report.pdf";
	SampleReportBuilder.buildPdf(inputFileJasper, fields, nomeFileReport);
	File fileOutput = new File (nomeFileReport);
	Assert.assertTrue(fileOutput.exists());
	Assert.assertTrue(fileOutput.length() > 0L);
	FileUtils.deleteQuietly(fileOutput);
  }
 
  @Test
  public void jasperSampleNoFileOutputTest() throws JRException, IllegalArgumentException
  {
	File inputFileJasper = new File("src/test/reports/testingReport.jrxml");
	Collection<FieldBean> fields = new ArrayList<FieldBean>();
	String nomeFileReport = null;
	try
	{
	  SampleReportBuilder.buildPdf(inputFileJasper, fields, nomeFileReport);
	  File fileOutput = new File (nomeFileReport);
	  Assert.assertTrue(fileOutput.exists());
	  Assert.assertTrue(fileOutput.length() > 0L);
	  FileUtils.deleteQuietly(fileOutput);
	}
	catch (JRException e)
	{
	  Assert.assertEquals("No output specified for the exporter.", e.getMessage());
	}
  }
   
  
}
