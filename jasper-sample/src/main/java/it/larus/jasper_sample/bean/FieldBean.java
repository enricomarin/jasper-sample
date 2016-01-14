package it.larus.jasper_sample.bean;

public class FieldBean
{
  private String title;
  
  private String price;
  
  private String ean13;
  
  private String code;
  
  
  public FieldBean()
  {
    
  }

  public FieldBean(String title, String price, String ean13, String code)
  {
    this.title = title;
    this.price = price;
    this.ean13 = ean13;
    this.code = code;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getPrice()
  {
    return price;
  }

  public void setPrice(String price)
  {
    this.price = price;
  }

  public String getEan13()
  {
    return ean13;
  }

  public void setEan13(String ean13)
  {
    this.ean13 = ean13;
  }

  public String getCode()
  {
    return code;
  }

  public void setCode(String code)
  {
    this.code = code;
  }
  
  }
