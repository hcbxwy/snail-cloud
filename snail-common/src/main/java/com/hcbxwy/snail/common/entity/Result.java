package com.hcbxwy.snail.common.entity;

import com.hcbxwy.snail.common.enums.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 接口返回值
 *
 * @author Billson
 * @date 2020/7/1 20:35
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {

    private String code;
    private String message;
    private Object data;

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ErrorCodeEnum.SUCCESS);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setResultCode(ErrorCodeEnum.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Result failure(ErrorCodeEnum errorCodeEnum) {
        Result result = new Result();
        result.setResultCode(errorCodeEnum);
        return result;
    }

    private void setResultCode(ErrorCodeEnum errorCodeEnum) {
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getMsg();
    }
}
