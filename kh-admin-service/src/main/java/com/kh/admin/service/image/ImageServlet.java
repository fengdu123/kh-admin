package com.kh.admin.service.image;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 所在的包名: com.kh.admin.service.image
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:  生成验证码
 * @Date: Created in 21:19 2017/10/26
 */

@Service
public class ImageServlet {

    /**
     * 定义BufferedImage对象
     * 获得Graphics对象
     * 听过Random类产生随机验证码信息
     * 使用Graphics绘制图片
     * 记录验证码信息到session中
     * 使用ImageIO输出图片
     *
     * 1.获取页面的验证码
     * 2.获取session中保存的验证码
     * 3.比较验证码
     * 4.返回校验结果
     */

    private static Random r = new Random();
    private static char[] chs = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final int NUMBER_OF_CHS = 4;
    private static final int IMG_WIDTH = 65;
    private static final int IMG_HEIGHT = 25;


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);    // 实例化BufferedImage
        Graphics g = image.getGraphics();
        Color c = new Color(200, 200, 255);                                             // 验证码图片的背景颜色
        g.setColor(c);
        g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);                                        // 图片的边框

        StringBuffer sb = new StringBuffer();                                           // 用于保存验证码字符串
        int index;                                                                      // 数组的下标
        for (int i = 0; i < NUMBER_OF_CHS; i++) {
            index = r.nextInt(chs.length);                                              // 随机一个下标
            g.setColor(new Color(r.nextInt(88), r.nextInt(210), r.nextInt(150)));       // 随机一个颜色
            g.drawString(chs[index] + "", 15 * i + 3, 18);                              // 画出字符
            sb.append(chs[index]);                                                      // 验证码字符串
        }

        request.getSession().setAttribute("piccode", sb.toString());                    // 将验证码字符串保存到session中
        ImageIO.write(image, "jpg", response.getOutputStream());                        // 向页面输出图像
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }



}
