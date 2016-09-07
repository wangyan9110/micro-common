package info.yywang.micro.common.dto;

import lombok.Data;

import java.util.List;

/**
 * @author yanyan.wang
 * @date 2016-04-06 15:57
 */
@Data
public final class ApiResult<T> {

    public static final String INFO = "SUCCESS";

    /**
     * the code
     */
    private String code;

    /**
     * list data
     */
    private List<T> datas;

    /**
     * data
     */
    private T data;

    /**
     * 消息
     */
    private String msg;

    /**
     * api信息构造器
     *
     * @param data 返回信息
     */
    private ApiResult(String code, T data) {
        this.data = data;
        this.code = code;
    }

    /**
     * api信息构造器
     *
     * @param datas 返回信息
     */
    private ApiResult(String code, List<T> datas) {
        this.datas = datas;
        this.code = code;
    }


    /**
     * @param code
     * @param msg
     */
    public ApiResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功的返回值
     *
     * @param data
     * @return
     */
    public static <T> ApiResult success(T data) {
        return new ApiResult(ApiResult.INFO, data);
    }

    /**
     * 成功的返回值
     *
     * @param datas
     * @return
     */
    public static <T> ApiResult success(List<T> datas) {
        return new ApiResult(ApiResult.INFO, datas);
    }

    /**
     * 返回失败消息
     *
     * @param code
     * @param msg
     * @return
     */
    public static ApiResult error(String code, String msg) {
        return new ApiResult(code, msg);
    }

    /**
     * 返回正常消息
     *
     * @param msg
     * @return
     */
    public static ApiResult info(String msg) {
        return new ApiResult(INFO, msg);
    }
}
