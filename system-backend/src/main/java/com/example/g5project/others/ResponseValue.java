package com.example.g5project.others;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.Nullable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ResponseValue.java
 * @Description TODO
 * @createTime 2022年03月25日 15:45:00
 */

@ApiModel("通用响应对象")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseValue<T> {

    @ApiModelProperty(value = "响应状态", dataType = "String")
    private final String result;
    @ApiModelProperty(value = "返回码", dataType = "String")
    private final @Nullable
    String errorCode;
    @ApiModelProperty(value = "提示信息", dataType = "String")
    private final @Nullable
    String errormessage;
    @ApiModelProperty(value = "响应内容", dataType = "String")
    private final @Nullable
    T payload;

    public ResponseValue() {
        this.result = "failure";
        this.errorCode = null;
        this.errormessage = null;
        this.payload = null;
    }

    private ResponseValue(String result, @Nullable String errorCode, @Nullable String errormessage, @Nullable T payload) {
        this.result = result;
        this.errorCode = errorCode;
        this.errormessage = errormessage;
        this.payload = payload;
    }

    public static <T> ResponseValue<T> success(@Nullable T payload) {
        return new ResponseValue<>("success", "0", "", payload);
    }

    public static <T> ResponseValue<T> fail(String code, String message) {
        return new ResponseValue<>("failure", code, message, null);
    }

    public String getResult() {
        return result;
    }

    public @Nullable
    String getErrorCode() {
        return errorCode;
    }

    public @Nullable
    String getErrorMessage() {
        return errormessage;
    }

    public @Nullable
    T getPayload() {
        return payload;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return "0".equals(errorCode);
    }
}
