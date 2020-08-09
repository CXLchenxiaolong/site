package com.site.common;


import com.site.common.enums.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ServerResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String  respCode;

    private String respMsg;


    /**
     * 泛型在返回时可以指定里面返回的内容，也可以不指定， 泛型还可以包含多种类型：String，map，list等
     */
    private T data;



    public static  ServerResponse success() {
        ServerResponse response = new ServerResponse();
        response.setRespCode(ResponseCodeEnum.SUCCESS.getCode());
        response.setRespMsg(ResponseCodeEnum.SUCCESS.getDesc());
        return response;
    }


    public static  <T> ServerResponse success(T data){
        ServerResponse response = new ServerResponse();
        response.setRespCode(ResponseCodeEnum.SUCCESS.getCode());
        response.setRespMsg(ResponseCodeEnum.SUCCESS.getDesc());
        response.setData(data);
        return response;
    }


    public static  <T> ServerResponse fail(ResponseCodeEnum responseCodeEnum){
        ServerResponse response = new ServerResponse();
        response.setRespCode(responseCodeEnum.getCode());
        response.setRespMsg(responseCodeEnum.getDesc());
        return response;
    }


    public static  <T> ServerResponse fail(ResponseCodeEnum responseCodeEnum, T data){
        ServerResponse response = new ServerResponse();
        response.setRespCode(responseCodeEnum.getCode());
        response.setRespMsg(responseCodeEnum.getDesc());
        response.setData(data);
        return response;
    }




    public ServerResponse(String respCode, String respMsg, T data) {
        super();
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.data = data;
    }

    public ServerResponse(String respCode, String respMsg) {
        super();
        this.respCode = respCode;
        this.respMsg = respMsg;
    }




}