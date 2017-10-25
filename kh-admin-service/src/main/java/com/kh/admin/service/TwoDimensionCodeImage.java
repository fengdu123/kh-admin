package com.kh.admin.service;

import jp.sourceforge.qrcode.data.QRCodeImage;

import java.awt.image.BufferedImage;

/**
 * 所在的包名: com.kh.admin.model
 * 所在的项目名：kh-admin
 *
 * @Author:wangyp
 * @Description:
 * @Date: Created in 11:58 2017/6/30
 */
public class TwoDimensionCodeImage implements QRCodeImage {

    BufferedImage bufImg;

    public TwoDimensionCodeImage(BufferedImage bufImg) {
        this.bufImg = bufImg;
    }

    @Override
    public int getHeight() {
        return bufImg.getHeight();
    }

    @Override
    public int getPixel(int x, int y) {
        return bufImg.getRGB(x, y);
    }

    @Override
    public int getWidth() {
        return bufImg.getWidth();
    }
}
