/* 三、设计Cashier收银类
***
* 1.设计一个Cashier类，负责收银管理，
* 它的属性包含一个用于保存超市所有商品的双列集合HashMap类型的productMap（key为商品ID，value为商品对象），
* 一个用于保存当前销售明细记录的列表集合salesList，在构造方法中，初始化这两个集合。
* */

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Cashier {
  // 创建双列集合（ productMap ） 和 单列集合（ salesItemArrayList ）
  private HashMap< String, Product > productMap;
  private ArrayList< SalesItem > salesItemArrayList;

  // 定义构造方法
  public Cashier() {
    this.productMap = new HashMap<>();
    this.salesItemArrayList = new ArrayList<>();
  }


  /* 2.为Cashier设计一个登录方法login，
  * 该方法的返回值类型为布尔类型，用于表示登录是否成功，
  * 该方法的流程：使用for循环，要求用户输入用户名密码，
  * 用户名为 测试 和密码为 admin 则登录成功，
  * 用户名密码不正确的时候，允许用户输入三次，
  * 三次都不正确则登录失败。
  * */
  public static boolean login() {
    // 定义 for 循环遍历
    for ( int i = 3; i > 0; i-- ) {
      /* 定义用户名为 测试
      *  定义密码为 admin
      *
      * 定义接收键盘输入的值
      *
      * 从键盘输入用户名
      * 定义一个字符串接收键盘输入的用户名
      *
      * 从键盘输入密码
      * 定义一个字符串接收键盘输入的密码
      * */
      String UserName1 = "测试";
      String PassWord1 = "admin";

      Scanner scanner = new Scanner( System.in );

      System.out.println( "请输入你的用户名：" );
      String UserName2 = scanner.nextLine();

      System.out.println( "请输入你的密码：" );
      String PassWord2 = scanner.nextLine();

      // if 语句循环遍历输入的用户名和密码是否正确
      if ( UserName2.equals( UserName1 ) && PassWord2.equals( PassWord1 ) ) {
        // 用户名和密码匹配成功则在调用的界面输出结果
        try {
          //
        } catch ( Exception exception ) {
          exception.printStackTrace();
        }
        return true;
      } else {
        /* 反之则根据 if 语句判断进行相应的提示 */

        // 当 i 不等于 0 ，提示：用户名或密码错误， 还有多少次机会, 然后请重新登录
        if ( i != 0 ) {
          System.out.println( "用户名或密码错误！" + "\n" + "你还有" + ( i - 1 ) + "次登录机会！" );
          System.out.println( "请重新输入：" + "\n" );
        }

        // 当 i 等于 0 ，则提示：用户名或密码错误次数超过3次，登录失败！
        if ( i == 0 ) {
          // 三次都不正确则输出结果：登录失败
          System.out.println( "用户名或密码输入错误超过3次，登录失败！！！" + "\n" );
        }
      }
    }
    //
    boolean fiag;
    return fiag = false;
  }


  /* 定义收银方法 sales()
  * 3.为Cashier设计一个收银方法 sales()，实现该方法流程（使用循环）
  *（1）首先打印出所有商品信息，提示用户输入商品ID，输入字符S代表输入结束，输入字符E代表退出；
  *  如果用户输入S，流程转至步骤（4）；
  *  如果用户输入E，则方法使用return返回；
  *  输入其他字符，则默认为商品ID，流程转至步骤（2）。
  *（2）用户输入商品ID后，查找商品集合是否有该ID商品，没有则提示没有这个商品ID，回到流程（1）；有打印该商品信息，并提示用户输入数量。
  *（3）用户输入商品数量后，需要创建一个销售明细对象，添加到销售记录表中，然后打印当前销售记录表的所有销售明细，然后流程回到步骤（1）。
  *（4）打印所有销售列表中的销售明细，计算销售明细的总价，打印应收取的总价，然后等待用户输入任意字符回车，用户输入后，清空销售明细记录集合，流程转回步骤（1）。
  *
  * */
  private void sales() throws IOException {
    while ( true ) {
      // 定义一个全局从接收的变量属性
      Scanner scanner = new Scanner( System.in );

      // 超市系统购物界面
      System.out.println( "********** 欢迎来到超市系统购物界面 ***********" );
      System.out.println( "************* 显示所有商品信息 *************"  + "\n" );

      // 购买商品
      for ( String productId: productMap.keySet() ) {
        Product product = productMap.get( productId );
        System.out.println( "商品id："+ product.getId() + "\n" + "商品名称：" + product.getName() + "\n" + "价格：" + product.getPrice() + "\n" );
      }
      // 输入字符S代表输入结束；输入字符E代表退出；输入其他任意字符为购买商品的id
      System.out.println("请输入需要购买的商品的ID：" + "\n" + "输入字符 S、s 表示输入商品ID结束！" + "\n" + "输入字符 E、e 表示返回上一级菜单！" + "\n" + "输入其他任意字符则表示为购买的商品的ID！" );
      // 定义一个空字符
      String liang = scanner.nextLine();

      // 判断输入字符 S、s 表示输入商品ID结束！
      if ( "S".equals( liang ) || "s".equals( liang ) ) {
        // 创建后缀为 .txt 的购买记录文件的路径
        FileWriter fwriter = new FileWriter( ( "D:\\SuperMarket_Checkout_system\\wd\\test01.txt" ) );
        // 定义一个空的字符串存储消费金额，初始为 0
        double sum = 0;
        for ( SalesItem salesItem : salesItemArrayList ) {
          System.out.println( "商品id：" + salesItem.getS_Pla_ID() + "\n" + "商品名称：" + salesItem.getS_Pla_Name() + "\n" + "价格：" + salesItem.getS_Pla_Price() + "\n" + "销售数量：" + salesItem.getSales_Volume() + "\n" + "总价：" + salesItem.getS_Pla_Price() * salesItem.getSales_Volume() + "\n" );
          sum += salesItem.getS_Pla_Price() * salesItem.getSales_Volume();
          String conten = salesItem.getS_Pla_ID() + "," + salesItem.getS_Pla_Name() + "," + salesItem.getS_Pla_Price() + "," + salesItem.getSales_Volume() + "," + salesItem.getS_Pla_Price() * salesItem.getSales_Volume() + "\r\n" + "\n";
          fwriter.write( conten );
        }
        //
        System.out.println( " 所有商品一共消费： " + sum + "元。" );
        salesItemArrayList.clear();
        System.out.println("输入任意键返回上一级菜单！");
        scanner.nextLine();
        fwriter.flush();
        fwriter.close();
      }
      // 判断输入字符 E、e 表示返回上一级菜单！
      else if ( "E".equals( liang ) || "e".equals( liang ) ) {
        System.out.println( "已返回上一级菜单！" );
        return;
      }
      // 判断输入其他任意字符则表示为购买的商品的ID！
      else {
        if ( productMap.containsKey( liang ) ) {
          Product product = productMap.get(liang);
          System.out.println( "商品id：" + product.getId() + "\n" + "商品名称：" + product.getName() + "\n" + "价格：" + product.getPrice() + "\n" );
          System.out.println( "请输入购买数量：" );
          String strNum = scanner.nextLine();
          int num = Integer.parseInt( strNum );
          SalesItem salesItemNew = new SalesItem();
          salesItemNew.setS_Pla_ID( product.getId() );
          salesItemNew.setS_Pla_Name( product.getName() );
          salesItemNew.setS_Pla_Price( product.getPrice() );
          salesItemNew.setSales_Volume( num );
          salesItemArrayList.add( salesItemNew );
          for ( SalesItem salesItem : salesItemArrayList ) {
            System.out.println( "商品id：" + salesItem.getS_Pla_ID() + "\n" + "商品名称：" + salesItem.getS_Pla_Name() + "\n" + "价格：" + salesItem.getS_Pla_Price() + "\n" + "销售数量：" + salesItem.getSales_Volume() + "\n" + "总价：" + salesItem.getS_Pla_Price() * salesItem.getSales_Volume() + "\n" );
          }
        } else {
            System.out.println( "你输入的商品id不存在！" );
        }
      }
    }
  }


  /*
   * 4.为 Cashier 设计一个 addProduct 方法，用于添加商品到商品列表中
   * 使用多态方式，让用户有两种通过不同类型文件添加商品，
   * 第一种方式是通过 ProductTxtFileReader 类的对象，添加 .txt 文件的商品信息到商品双列结合中；
   * 第二种是通过 ProductCsvFileReader 类的对象，添加 .csv 文件的商品信息到商品双列结合中。
   * */
  private void addProduct( int Add_The_Goods ) throws Exception {
    // 1.录入 ProductTxtFileReader 文档
    if ( Add_The_Goods == 1 ) {
      // A001.txt 文档路径
      File fileOne = new File("D:\\SuperMarket_Checkout_system\\wd\\test001.txt");
      SimpleDateFormat Sdf = new SimpleDateFormat( "" );
      Sdf.setLenient( false );
      // 判断 A001.txt 文档是否存在
      if ( !fileOne.exists() ) {
        // 存在则提示已存在
        fileOne.createNewFile();
        System.out.println( "文档已存在！" );
      } else {
        // 反之创建新的文档，并且输出文档路径
        try {
          fileOne.createNewFile();
          System.out.println( "创建的文档路径为：" + fileOne );
        } catch ( IOException e ) {
          e.printStackTrace();
        }
      }
      // 创建新的文档并且向文档中录入数据
      try {
        // 创建一个对象文档用于向文件中写入数据
        FileWriter Fw = new FileWriter( fileOne.getAbsoluteFile() );
        // 将字符数据写入到文档文件中
        Fw.write( " 1 网站开发与实践 23.00 " + "\n" );
        Fw.write( " 2 计算机网络 199.9 " + "\n" );
        Fw.write( " 3 显示器 3699 " + "\n" );
        Fw.write( " 4 笔记本！ 64.99 " + "\n" );
        Fw.write( " 5 Java基础案例教程 第2版 59.80 " + "\n" );
        Fw.write( " 6 PHP 网站开发实例教程 第2版 66.60 " + "\n" );
        /*
        * 关闭文档读取流，释放资源
        * */
        Fw.flush();
        Fw.close();
        System.out.println( "已添加 .txt 文件，并且录入数据成功！" );
      } catch ( IOException exception ) {
        exception.printStackTrace();
      }
    }
    // 2.录入 ProductCsvFileReader 文档
    else if (Add_The_Goods == 2) {
      // A001.csv 文档路径
      File fileTwo = new File( "D:\\SuperMarket_Checkout_system\\wd\\test001.csv" );
      if ( !fileTwo.exists() ) {
        fileTwo.createNewFile();
        System.out.println( "文档已存在！" );
      } else {
        try {
          fileTwo.createNewFile();
          System.out.println( "创建的文档路径为：" + fileTwo );
        } catch ( IOException e ) {
          e.printStackTrace();
        }
      } try {
        FileWriter Fw = new FileWriter( fileTwo.getAbsoluteFile() );
        Fw.write( " 001 史诗级 9999.00 " + "\n" );
        Fw.write( " 002 PHP 5680.00 " + "\n" );
        Fw.write( " 003 jQuery 888.00 " + "\n" );
        Fw.write( " 004 MSQL 3468.00 " + "\n" );
        Fw.write( " 005 服务器 67788.00 " + "\n" );
        Fw.write( " 006 小鹿线 25825.00 " + "\n" );
        Fw.flush();
        Fw.close();
        // 提示添加文件是否成功
        System.out.println( "已添加 .csv文档文件，并且录入数据成功！" );
      } catch ( IOException exception ) {
        exception.printStackTrace();
      }
    }
    // 3.手动输入商品信息：为优化部分
    else if (Add_The_Goods == 3) {
      // 定义从键盘接收输入数值的属性
      Scanner scanner = new Scanner(System.in);
      /*
      * 添加商品id
      * 接收从键盘输入的搭配id
      * 添加商品名称
      * 接收从键盘输入的商品名称
      * 添加商品价格
      * 接收从键盘输入的商品价格
      * */
      System.out.println( "请输入商品id：" );
      String SR_id = scanner.nextLine();
      System.out.println( "请输入商品名称：" );
      String SR_name= scanner.nextLine();
      System.out.println( "请输入商品价格：" );
      String SR_priceStr = scanner.nextLine();

      Product product = new Product();
      product.setId( SR_id );
      product.setName( SR_name );
      product.setPrice( Double.parseDouble( SR_priceStr ) );
      productMap.put( SR_id, product );
    }
    // 4.查看输入商品信息：为优化部分
    else if (Add_The_Goods == 4) {
      System.out.println( "商品id            商品名称            价格" );
      for ( String productId : productMap.keySet() ) {
        Product product = productMap.get( productId );
        System.out.println( product.getId() + "              " + product.getName() + "               " + product.getPrice()  );
      }
    }
    // 5.查看商品列表：为优化部分
    else if (Add_The_Goods == 5) {
      while (true) {
        System.out.println( "*********** 请选择需要查看的商品列表的文件格式类型！ **********" );
        System.out.println( "*************** 1. .Txt格式类型！   *****************" );
        System.out.println( "*************** 2. .Csv格式类型！   *****************" );
        System.out.println( "*************** 3. 返回上一级菜单！   *****************" );
        System.out.println( " 请输入你的选择: " );

        //
        Scanner sc = new Scanner( System.in );
        String line = sc.nextLine();
        int liang = Integer.parseInt( line );

        // 1. .Txt格式类型
        if ( liang == 1 ) {
          /*
          * 使用File类打开一个文件
          * 通过字节流或字符流的子类指定输出的位置
          * 进行读操作：所有的内容读到此数组中临时存放
          * 用于记录读取的数据个数
          ***
          ***
          * 将内容读到byte数组中，同时返回个数，若为-1，则内容读到底
          * */
          File fiLe = new File( File.separator + "D:\\SuperMarket_Checkout_system\\wd\\test001.txt" );
          InputStream fis = new FileInputStream( fiLe );
          byte[] buf = new byte[ 1024 ];
          int len;
          String myStr = "";
          while ( ( len = fis.read( buf ) ) != -1 ) {
            myStr += new String( buf, 0, len, "UTF-8" );
          }
          System.out.println( myStr );
          // 关闭输出
          fis.close();
        }
        // 2. .Csv格式类型
        else if ( liang == 2 ) {
          /*
           * 使用File类打开一个文件
           * 通过字节流或字符流的子类指定输出的位置
           * 进行读操作：所有的内容读到此数组中临时存放
           * 用于记录读取的数据个数
           ***
           ***
           * 将内容读到byte数组中，同时返回个数，若为-1，则内容读到底
           * */
          File fiLe = new File( File.separator + "D:\\SuperMarket_Checkout_system\\wd\\test001.csv" );
          InputStream fis = new FileInputStream( fiLe );
          byte[] buf = new byte[ 1024 ];
          int len;
          String myStr = "";
          while ( ( len = fis.read( buf ) ) != -1 ) {
            myStr += new String( buf, 0, len, "UTF-8" );
          }
          System.out.println( myStr );
          // 关闭输出
          fis.close();
        }
        // 3. 返回上一级菜单
        else if ( liang == 3 ) {
          System.out.println( "已返回上一级菜单！" + "\n" );
          break;
        }
        // 输入的数字不在 1~3 的范围，则提示：请重新输入符合的数字
        else if ( liang != 1 || ( liang != 2 ) || ( liang != 3 ) ) {
          System.out.println( "输入的数字有误！" + "\n" + "请重新输入符合的数字。" );
        }
      }
    }
    // 6.MysqlDate 保存到数据库：为优化部分,尚未完成。 此处可忽略.....
    else if (Add_The_Goods == 6) {
      // 此处可忽略.....
    }
    // 7.查看上一次的购买记录；为优化部分
    else if (Add_The_Goods == 7) {
      // 使用File类打开一个文件
      File fiLe = new File( File.separator + "D:\\SuperMarket_Checkout_system\\wd\\A02.txt" );
      InputStream fis = new FileInputStream( fiLe );
      byte[] buf = new byte[ 1024 ];
      int len;
      String myStr = "";
      while ( ( len = fis.read( buf ) ) != -1 ) {
        myStr += new String( buf, 0, len, "UTF-8" );
      }
      System.out.println( myStr );
      // 关闭输出
      fis.close();
    }
  }


  /*
   * 5.为Cashier设计一个运行方法run，完成以下流程：
   *（1）调用登录方法，如果登录失败，则方法直接返回，程序退出。
   *（2）进入主程序循环，打印菜单，菜单包括：1.收银，2.录入商品，3.退出。
   *（3）用户输入1，则调用sales方法；
   *    用户输入2，则调用addProduct方法，
   *    用户输入3，则终止循环，
   *    用户输入其他无效，循环继续打印菜单选项让用户选择。
   */
  public void run() throws Exception {
    while (true) {
      //
      boolean flagLogin = login();
      if ( flagLogin ) {
        System.out.println( "登录系统成功！" + "\n" );
        while ( true ) {
          System.out.println( "***************************************" );
          System.out.println( "********** 欢迎来到超市系统主界面 *********" );
          System.out.println( "*********** 请按照以下提示操作！ **********" );
          System.out.println( "************** 1.收银     **************" );
          System.out.println( "************** 2.录入商品 ***************" );
          System.out.println( "************** 3.退出     **************" );
          System.out.println( " 请输入你的选择: " );
          Scanner sc = new Scanner( System.in );
          String line = sc.nextLine();
          int iF = Integer.parseInt(line);
          if ( iF == 1) {
            // 调用 收银 方法
            sales();
          } else if ( iF == 2 ) {
            System.out.println( "请选择录入方式：" + "\n" + "1.录入ProductTxtFileReader文档" + "\n" + "2.录入ProductCsvFileReader文档" + "\n" + "3.手动输入商品信息" + "\n" + "4.查看手动输入的商品信息" + "\n" + "5.查看商品列表" + "\n" + "6.MysqlDate" + "\n" + "7.查看销售信息" + "\n" + "8.退出上一级菜单！" );
            System.out.println( "请输入数值，选择录入方式：" );
            String addNum = sc.nextLine();
            // 定义一个整数类型的属性接收键盘输入的数值，调用
            int Add_The_Goods = Integer.parseInt( addNum );
            if ( Add_The_Goods == 8 ) {
              System.out.println( "已返回上一级菜单！" );
            } else {
              addProduct( Add_The_Goods );
            }
          } else if ( iF == 3 ) {
            System.out.println( "程序已退出，谢谢你的使用！" + "\n" );
            break;
          } else if ( iF != 1 || ( iF != 2 ) || ( iF != 3 ) ) {
            System.out.println( "输入的数字有误！" + "\n" + "请重新输入符合的数字。" );
          }
        }
      }
    }
  }


  /*	6.为 Cashier 类添加一个 main 方法，
  * 该方法用于启动程序，在main方法中，创建 Cashier 对象，然后调用run方法。
  **/
  public static void main(String[] args) throws Exception {
    Cashier cashier = new Cashier();    // 定义调用run的属性
    cashier.run();      //
  }
}


























