/* 二、设计读取文件的接口和实现类
* 3.
*
*
* */

// 导入包
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProductCsvFileReader implements ProductFileReader {
  // 重写方法类
  @Override
  public List < Product > readProduct( File file ) throws Exception {
    List< Product > productList = new ArrayList<>();
    FileInputStream fis = new FileInputStream( file );
    BufferedReader br = new BufferedReader( new InputStreamReader( fis ) );
    String line;
    //
    while ( ( line = br.readLine() ) != null ) {
      String[] stringArr = line.split( "," );
      Product product = new Product();
      product.setId( stringArr[ 0 ] );
      product.setName( stringArr[ 1 ] );
      product.setPrice( Double.parseDouble( stringArr[ 2 ] ) );
      productList.add( product );
    }
    //
    fis.close();
    return productList;
  }
}
