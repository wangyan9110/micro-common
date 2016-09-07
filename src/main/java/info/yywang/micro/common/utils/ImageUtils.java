package info.yywang.micro.common.utils;


import info.yywang.micro.common.exceptions.BizException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

/**
 * @author yanyan.wang
 * @date 2016-02-19 20:40
 */
public class ImageUtils {

    public static OutputStream cutPic(InputStream in,
                                      int width, int height) {
        return cutPic(in, width, height, "jpg");
    }

    public static OutputStream cutPic(InputStream in,
                                      int width, int height, String format) {
        try {
            Iterator iterator = ImageIO.getImageReadersByFormatName(format);
            ImageReader reader = (ImageReader) iterator.next();
            ImageInputStream iis = ImageIO.createImageInputStream(in);
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            int imageIndex = 0;
            Rectangle rect = new Rectangle((reader.getWidth(imageIndex) - width) / 2, (reader.getHeight(imageIndex) - height) / 2, width, height);
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0, param);
            OutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(bi, format, outputStream);
            return outputStream;
        } catch (Exception e) {
            throw new BizException(e.getMessage(), e);
        }
    }
}

