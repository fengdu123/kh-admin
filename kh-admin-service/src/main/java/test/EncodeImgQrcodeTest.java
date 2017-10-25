package test;

import com.kh.admin.service.DecodeImgQrcode;
import com.kh.admin.service.EncodeImgQrcode;
import org.junit.Test;

import java.io.File;

/**
 * 所在的包名: test
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:
 * @Date: Created in 16:24 2017/6/30
 */
public class EncodeImgQrcodeTest {

    @Test
    public void testWriteToFile() {
        String contents = "http://blog.csdn.net/typa01_kk";
        String format = "jpeg";
        File logoImg = new File("D:"+File.separator+"logo.jpg");
        File img = new File("D:"+File.separator+"csdn.jpg");
        //生成二维码
        EncodeImgQrcode.writeToFile(contents, format, img);
        //添加logo图片
        File img1 = new File("D:"+File.separator+"csdnlogo.jpg");

//        EncodeImgZingLogo.writeToFile(img, logoImg, format, img1);

        //解析二维码
        String content = DecodeImgQrcode.decodeImg(img);
        System.out.println("1:"+content);
//        String content1 = DecodeImgQrcode.decodeImg(img1);
//        System.out.println("2:"+content1);
    }
}
