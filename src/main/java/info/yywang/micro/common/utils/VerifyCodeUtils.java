package info.yywang.micro.common.utils;

import java.util.Random;

/**
 * @author yanyan.wang
 * @date 2016-04-23 18:18
 */
public class VerifyCodeUtils {

    /**
     * 获取验证码
     *
     * @param length
     * @return
     */
    public static String getCode(int length) {
        String no = "";
        int num[] = new int[length];
        int c = 0;
        for (int i = 0; i < length; i++) {
            num[i] = new Random().nextInt(10);
            c = num[i];
            for (int j = 0; j < i; j++) {
                if (num[j] == c) {
                    i--;
                    break;
                }
            }
        }
        if (num.length > 0) {
            for (int i = 0; i < num.length; i++) {
                no += num[i];
            }
        }
        return no;
    }

}
