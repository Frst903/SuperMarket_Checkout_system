/* 一、设计实体信息类
* 2.设计一个SalesItem类，用于描述销售明细（ Sales Particular ）下面使用缩写（ S_Pla ）表示，
* 这个类中包含有商品ID，商品名称，商品价格和销售数量四个属性，
* 类中需要实现对应的 getter 和 setter 方法。
* */

public class SalesItem {
  private String S_Pla_ID;      // 表示销售明细的商品ID
  private String S_Pla_Name;    // 表示销售明细的商品名称
  private double S_Pla_Price;   // 价格表示销售明细的商品价格
  private int Sales_Volume;     // 销售数量表示销售明细的销售数量

  // 生成商品ID getter 和setter 方法
  public String getS_Pla_ID() {
    return S_Pla_ID;
  }
  public void setS_Pla_ID(String s_Pla_ID) {
    S_Pla_ID = s_Pla_ID;
  }

  // 生成商品名称 getter 和 setter 方法
  public String getS_Pla_Name() {
    return S_Pla_Name;
  }
  public void setS_Pla_Name(String s_Pla_Name) {
    S_Pla_Name = s_Pla_Name;
  }

  // 生成商品价格 getter 和 setter 方法
  public double getS_Pla_Price() {
    return S_Pla_Price;
  }
  public void setS_Pla_Price(double s_Pla_Price) {
    S_Pla_Price = s_Pla_Price;
  }

  // 生成销售数量 getter 和setter 方法
  public int getSales_Volume() {
    return Sales_Volume;
  }
  public void setSales_Volume(int sales_Volume) {
    Sales_Volume = sales_Volume;
  }
}
