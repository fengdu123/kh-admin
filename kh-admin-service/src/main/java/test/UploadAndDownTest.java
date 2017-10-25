package test;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;

import java.io.File;

/**
 * 所在的包名: test
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:
 * @Date: Created in 11:25 2017/7/4
 */
public class UploadAndDownTest {

    @Test
    public void SystemsUtilsTest(){
        File file = SystemUtils.getUserHome();
        System.out.println(file);

        String BANK_FILE_SAVE_TEMP_DIR = SystemUtils.getUserHome() + SystemUtils.FILE_SEPARATOR +
                "files"+SystemUtils.FILE_SEPARATOR+"upload"+SystemUtils.FILE_SEPARATOR+"temp"+SystemUtils.FILE_SEPARATOR+
                "liquidation-admin"+SystemUtils.FILE_SEPARATOR;
        System.out.println(BANK_FILE_SAVE_TEMP_DIR);

        String newStr =  SystemUtils.JAVA_CLASS_VERSION;
        System.out.println(newStr);

        //得到本地的UserHome目录
        System.out.println(SystemUtils.getUserHome());
        //得到本地java的安装目录
        System.out.println(SystemUtils.getJavaHome());


    }
}
