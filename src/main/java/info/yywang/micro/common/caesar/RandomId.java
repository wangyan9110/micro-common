package info.yywang.micro.common.caesar;

import java.util.Random;

/**
 * 通过凯撒算法编码获取唯一的8位数字
 * <p>
 * 可用于对于顺序数值加密
 * </p>
 */
public class RandomId {

    private Random random;

    private String table;

    private static RandomId randomId = new RandomId();

    private RandomId() {
        random = new Random();
        table = "9612350487";
    }

    public static RandomId getInstance() {
        return randomId;
    }

    /**
     * 编码
     *
     * @param number
     * @return
     */
    public String decode(int number) {
        String result = null;
        String numberStr = String.format("%05d", number);
        int key = random.nextInt(10),
                seed = random.nextInt(100);
        Caesar caesar = new Caesar(table, seed);
        numberStr = caesar.encode(key, numberStr);
        result = numberStr
                + String.format("%01d", key)
                + String.format("%02d", seed);
        return result;
    }
}