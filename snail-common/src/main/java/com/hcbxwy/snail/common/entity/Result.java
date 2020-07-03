package com.hcbxwy.snail.common.entity;

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
        return init();
    }

    public static Result success(Object data) {
        Result result = init();
        result.setData(data);
        return result;
    }

    private static Result init() {
        return Result.builder()
                .code("00000")
                .message("操作成功")
                .build();
    }
}
