# SuperMarket_Checkout_system

#### 介绍
SuperMarket_Checkout_system（超市管理系统）项目

（ 注意：本项目只提供学习使用，禁止用于商业用途，对于违者必将追究相关法律责任！！！ ）

#### 软件架构

Java

### 一、项目结构：

#### SuperMarket_Checkout_system

│  project.txt
│  README.md
│  SuperMarket_Checkout_system.iml
│  项目运行指南.md
│  
├─src					源代码存放目录
│      Cashier.java									Cashier类，负责收银管理
│      MySQLData.java							 数据库存储
│      Product.java									实体信息类，Product类，用于描述超市商品
│      ProductCsvFileReader.java			  读取文件的接口和实现类，ProductFileReader的实现类
│      ProductFileReader.java					读取文件的接口和实现类，定义一个ProductFileReader接口
│      ProductTxtFileReader.java				读取文件的接口和实现类，ProductFileReader 的实现类
│      SalesItem.java								实体信息类，SalesItem类，用于描述销售明细
│      
└─wd				项目的 .txt 和 ,csv 文件存放目录，也可自行修改文件的存放位置
        A001.csv
        A001.txt
        A02.txt
        test001.csv
        test001.txt
        

### 二、项目分析结果：

 1. #### 设计实体信息类

     1. 设计一个Product类，有商品ID、商品名称、商品价格三个属性，要实现getter和setter方法。

     2. ##### 设计一个SalesItem类，有商品ID、商品名称、商品价格和销售数量四个属性，要实现getter和setter方法。

 2. #### 设计读取文件的接口和实现类

     1. ##### 定义一个ProductFileReader接口，有一个方法readProduct(),返回值类型是一个可以保存Product对象的List集合，参数是一个File类型的对象，然后使用throws关键字定义有可能抛出Exception异常。

     2. ##### 定义一个ProductFileReader的实现类ProductTxtFileReader，实现readProduct方法，方法中使用I/O知识，读取传入的File对象，解析其每一行文件，每行文本格式为（商品ID+空格+商品名称+空格+价格，例如“1 可口可乐听装 3.50”），解析每一行则创建一个Product对象并初始化其属性，添加到一个List集合对象中，解析完成后，将得到的List集合使用return返回。 

     3. ##### 定义一个ProductFileReader的实现类ProductCsvFileReader，实现readProduct方法，方法中使用I/O知识，读取传入的File对象，解析其每一行文件，每行文本格式为（商品ID+逗号+商品名称+逗号+价格，例如“1,可口可乐听装,3.50”），解析每一行则创建一个Product对象并初始化其属性，添加到一个List集合对象中，解析完成后，将得到的List集合使用return返回。

 3. #### 设计Cashier收银类

     1. ##### 设计一个Cashier类，定义两个属性，一个用于保存超市所有商品的双列集合HashMap类型的productMap（key为商品ID，value为商品对象），一个用于保存当前销售明细记录的列表集合salesList，在构造方法中初始化这两个集合。

     2. ##### 为Cashier设计一个登录方法login，返回值类型为布尔类型，用于表示登录是否成功，使用for循环，提示输入用户名密码，用户名密码为自己的姓名和学号则登录成功，用户名密码不正确的时候，允许用户输入三次，三次都不正确则登录失败。

     3. ##### 为Cashier设计一个收银方法sales()，（使用循环）：

        ##### （1）打印出所有商品信息，提示用户输入商品ID，输入字符S代表输入结束，输入字符E代表退出；如果用户输入S，流程转至步骤（4）；如果用户输入E，则方法使用return返回；输入其他字符，则默认为商品ID，流程转至步骤（2）。 

        #####（2）用户输入商品ID后，查找商品集合是否有该ID商品，没有则提示没有这个商品ID，找到这个商品ID后回到流程（1）；有则打印该商品信息，并提示用户输入数量。

        ##### （3）用户输入商品数量后，创建一个销售明细对象，添加到销售记录表中，然后打印当前销售记录表的所有销售明细，然后流程回到步骤（1）。

        ##### （4）打印所有销售列表中的销售明细，计算销售明细的总价，打印应收取的总价，然后等待用户输入任意字符回车，用户输入后，清空销售明细记录集合，流程转回步骤（1）。

    ##### 4. 为Cashier设计一个addProduct方法，用于添加商品到商品列表中；使用多态方式，让用户有两种通过不同类型文件添加商品，第一种方式是通过ProductTxtFileReader类的对象，添加.txt文件的商品信息到商品双列结合中；第二种是通过ProductCsvFileReader类的对象，添加.csv文件的商品信息到商品双列结合中。

     ##### 5. 为Cashier设计一个运行方法run，完成以下流程：

    ##### （1）调用登录方法，如果登录失败，则方法直接返回，程序退出。

    ##### （2）进入主程序循环，打印菜单，菜单包括：1.收银，2.录入商品，3.退出。
    
    ##### （3）用户输入1，则调用sales方法；用户输入2，则调用addProduct方法，用户输入3，则终止循环，用户输入其他无效，循环继续打印菜单选项让用户选择。
    
     ##### 6. 为Cashier类添加一个main方法，用于启动程序，在main方法中，创建Cashier对象，然后调用run方法。

       

    ### 三、项目搭建：（ 创建项目，确定自己要编写哪些类和方法，先创建好类 ）
    
    1. 定义一个Product类，实现对应的getter和setter方法。
    
    2. 定义一个SalesItem类，实现对应的getter和setter方法。
    
    3. 定义一个ProductFileReader接口，有一个方法readProduct()。
    
    4. 定义一个ProductFileReader的实现类ProductTxtFileReader，实现readProduct方法。
    
    5. 定义一个ProductFileReader的实现类ProductCsvFileReader，实现readProduct方法。
    
    6. 设计一个Cashier类，定义构造方法
    
    7. 为Cashier设计一个登录方法login；为Cashier设计一个收银方法sales()；为Cashier设计一个addProduct方法；为Cashier设计一个运行方法run；为Cashier类添加一个main方法。
    
       ### 操作结果：请查看源代码！！！

### 四、未修复的bug：

1. 在选择录入 ProductTxtFileReader 文档完成后进入 收银 界面的显示所有商品信息为空不会显示 ProductTxtFileReader 文档录入的数据，如下图所示（ps：录入ProductCsvFileReader文档 也是一种的不会显示）：

   ![image-20220925210314292](C:\Users\35098\AppData\Roaming\Typora\typora-user-images\image-20220925210314292.png)

2. 在选择录入方式时，请勿选择 6.MySQLDate 录入否则会出现项目报错导致停止运行，由于该功能尚未开发！！！忽略即可。

   ![image-20220925210634759](C:\Users\35098\AppData\Roaming\Typora\typora-user-images\image-20220925210634759.png)

   ![image-20220925210544680](C:\Users\35098\AppData\Roaming\Typora\typora-user-images\image-20220925210544680.png)

### 五、本项目可自行div修改学习：

## 注意：本项目只提供学习使用，请勿用于商业用途，对于违者必将追究相关法律责任！！！

## 如发现本项目有被侵权行为请通过下方的联系方式联系我，谢谢！！！

#### 联系方式：

QQ：366392249

QQ邮箱：366392249@qq.com

微信：Frst_08_04

哔哩哔哩：

Gitee：https://gitee.com/Frst903

Github：https://github.com/Frst903