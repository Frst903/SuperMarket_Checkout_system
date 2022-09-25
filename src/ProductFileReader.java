/* 二、设计读取文件的接口和实现类
* 1.定义一个ProductFileReader接口，
*
*
* */

import java.io.File;
import java.util.List;

public interface ProductFileReader {
  List< Product > readProduct( File file ) throws Exception;
}
