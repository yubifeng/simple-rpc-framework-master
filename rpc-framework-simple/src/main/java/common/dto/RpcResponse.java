package common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author fanfanli
 * @date 2021/8/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RpcResponse<T> implements Serializable {

    private static final long serialVersionUID = 715745410605631233L;

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应错误消息体
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 成功响应
     *
     * @param data 数据
     * @param <T>  数据泛型
     *
     * @return RpcResponse
     */
    public static <T> RpcResponse<T> success(T data) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setCode(ResponseCode.SUCCESS.getValue());
        if (null != data) {
            response.setData(data);
        }
        return response;
    }

    /**
     * 失败响应
     * @param responseCode 响应码枚举
     * @param errorMessage 错误消息
     * @param <T> 泛型
     *
     * @return RpcResponse
     */
    public static <T> RpcResponse<T> fail(ResponseCode responseCode, String errorMessage) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setCode(responseCode.getValue());
        response.setMessage(errorMessage);
        return response;
    }



}
