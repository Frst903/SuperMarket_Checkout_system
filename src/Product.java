
/*  一、设计实体信息类
    1.
* */

public class Product {
  private String id;  // 表示超市商品的ID
  private String name;  // 表示超市商品的名称
  private double price; // 表示超市商品的价格

  // 生成超市商品的ID getter 和setter 方法
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  // 生成超市商品的名称 getter 和setter 方法
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  // 生成表示超市商品的价格 getter 和setter 方法
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
}
