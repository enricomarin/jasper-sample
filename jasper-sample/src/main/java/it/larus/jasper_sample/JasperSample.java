package it.larus.jasper_sample;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import it.larus.jasper_sample.bean.FieldBean;
import it.larus.jasper_sample.builder.SampleReportBuilder;
import net.sf.jasperreports.engine.JRException;

/**
 * Hello world!
 * 
 */
public class JasperSample
{
  public static void main(String[] args)
  {
    if (args.length < 1)
    {
      System.out.println("Missing argument. Type: JasperSample fileJasperName.jrxml");
    }
    else
    {
      String fileJrxml = args[0]; 
      File jasperFileSource = new File(fileJrxml);
      
      try
      {
        Collection<FieldBean> fields = new ArrayList<FieldBean>();
        
        fields.add(new FieldBean("Prova 1",  "8.00",  "1234567890128", "A123B453"));
        fields.add(new FieldBean("Prova 2",  "6.00",  "1234567890128", "A123B456"));
        fields.add(new FieldBean("Prova 3",  "10.00", "1234567890128", "A134B456"));
        fields.add(new FieldBean("Prova 4",  "7.00",  "1234567890128", "A123B457"));
        fields.add(new FieldBean("Prova 5",  "5.00",  "1234567890128", "A123B458"));
        fields.add(new FieldBean("Prova 6",  "10.00", "1234567890128", "A123B456"));
        fields.add(new FieldBean("Prova 7",  "12.20", "1234567890128", "A354B456"));
        fields.add(new FieldBean("Prova 8",  "13.15", "1234567890128", "A13AB456"));
        fields.add(new FieldBean("Prova 9",  "15.10", "1234567890128", "A643B456"));
        fields.add(new FieldBean("Prova 10", "10.00", "1234567890128", "A123C456"));
        
        String nomeReport = "report.pdf";
        
        SampleReportBuilder.buildPdf(jasperFileSource, fields, nomeReport);
        
        
        System.out.println("Pdf file successfully generated.");
        
      }
      catch (IllegalArgumentException e)
      {
    	System.out.println(e.getMessage());
      }
      catch (JRException e)
      {
        System.out.println("Error during the generation of PDF file.\n");
        e.printStackTrace();
      }      
    }
  }
}
