package com.kh.admin.service;

import com.google.zxing.WriterException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * 所在的包名: com.kh.admin.service
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:   用java生成二维码
 * @Date: Created in 11:18 2017/6/30
 */
public class GoogleQRcode {

    @Test
    public void GoogleQRcode() throws WriterException, IOException {
        String text = "你好";
        int width = 100;
        int height = 100;
        String format = "png";
        Hashtable hints= new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
        File outputFile = new File("new.png");
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
    }
}
