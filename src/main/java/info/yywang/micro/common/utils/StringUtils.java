package info.yywang.micro.common.utils;

import org.springframework.util.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangyan
 * @date 2014-11-02 16:47
 */
public final class StringUtils{

    /**
     * 私有构造器
     */
    private StringUtils() {

    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if(str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if(!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 字符串数组转化为字符串
     *
     * @param strings   字符串数组
     * @param delimiter 分隔符
     * @return 字符串
     */
    public static String toString(String[] strings, String delimiter) {
        Assert.notEmpty(strings);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str).append(delimiter);
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.delete(stringBuilder.length() - delimiter.length(), stringBuilder.length());
        }
        return stringBuilder.toString();
    }

    /**
     * 把unicode转成utf8
     *
     * @param str unicode
     * @return utf8
     */
    public static String unicodeToString(String str) {
        String utf8Str = str;
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(utf8Str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            utf8Str = utf8Str.replace(matcher.group(1), ch + "");
        }
        return utf8Str;
    }

    /**
     * 过滤所有特殊字符
     *
     * @param str 字符
     * @return
     */
    public static String filter(String str) {

        // 清除掉所有特殊字符
        String regEx = "[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
}