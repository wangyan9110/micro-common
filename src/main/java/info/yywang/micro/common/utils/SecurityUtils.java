package info.yywang.micro.common.utils;


import info.yywang.micro.common.exceptions.SysException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wangyan
 * @date 2014-11-02 17:27
 */
public final class SecurityUtils {

    private final static String PRE_PWD = "com%iydsj&*";

    /**
     * 私有构造器
     */
    private SecurityUtils() {

    }

    /**
     * MD5加密
     *
     * @param str 要加密的字符串
     * @return 加密后的字符串
     */
    public static String md5Encrypt(String str) {
        char[] hexDigits = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = str.getBytes();
            MessageDigest mInst = MessageDigest.getInstance("MD5");
            mInst.update(btInput);
            byte[] md = mInst.digest();
            int mdLength = md.length;
            char[] res = new char[mdLength * 2];
            int index = 0;
            for (int i = 0; i < mdLength; i++) {
                byte by = md[i];
                res[index++] = hexDigits[by >>> 4 & 0xf];
                res[index++] = hexDigits[by & 0xf];
            }
            return new String(res);

        } catch (NoSuchAlgorithmException e) {
            throw new SysException("SecurityUtils.md5Encrypt", e);
        }
    }

    /**
     * 和app相同的加密算法
     * @param str
     * @return
     */
    public static String md5(String str) {
        try {
            MessageDigest bmd5 = MessageDigest.getInstance("MD5");
            bmd5.update(str.getBytes());
            int i;
            StringBuffer buf = new StringBuffer();
            byte[] b = bmd5.digest();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.print(md5Encrypt("123456"));
    }


    public static String passwordEncrypt(String password) {
        return md5Encrypt(PRE_PWD + password);
    }
}
