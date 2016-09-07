package info.yywang.micro.common.exceptions;


import info.yywang.micro.common.dto.ApiResult;

/**
 * @author yanyan.wang
 * @date 2016-04-14 17:52
 */
public class ApiException extends RuntimeException {

    private ApiResult<String> apiResult;

    public ApiException(String code, String msg) {
        apiResult = ApiResult.error(code, msg);
    }

    public ApiResult<String> getApiResult() {
        return apiResult;
    }
}
