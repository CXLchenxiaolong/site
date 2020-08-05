package com.site.common;


import lombok.Data;

import java.io.Serializable;
import java.rmi.server.UID;

@Data
public class ServerResponse<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String  respCode;

    private String respMsg;


    /**
     * 泛型在返回时可以指定里面返回的内容，也可以不指定， 泛型还可以包含多种类型：String，map，list等
     */
    private T data;




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