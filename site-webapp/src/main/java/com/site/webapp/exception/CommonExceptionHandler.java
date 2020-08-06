package com.site.webapp.exception;


import com.alibaba.fastjson.JSON;
import com.site.common.ServerResponse;
import com.site.common.enums.ResponseCode;
import com.site.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



/**
 * @author sa
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {


    /**
     * 拦截Exception类的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception e) {
        String errorinfo = getStackTraceStr(e);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Map<String, Object> result = new LinkedHashMap<>();
        Map<String,String[]> requestMsg = request.getParameterMap();
        for(String key :requestMsg.keySet())
        {
            for(int i=0;i<requestMsg.get(key).length;i++)
            {
                //打印所有请求参数值
                log.info("key="+key+";value="+ requestMsg.get(key)[i]);
            }
        }
        result.put("respCode", "9999");
        result.put("url",request.getRequestURL().toString());
        result.put("param", JSON.toJSONString(requestMsg));
        result.put("stackTrace", errorinfo);
        log.error("错误堆栈-" + 110 + ": " + errorinfo);
        return result;
    }

    private String getStackTraceStr(Exception e) {
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            StringBuffer error = stringWriter.getBuffer();
            return error.toString();
        } catch (Exception e2) {
            return "获取堆栈信息异常";
        }
    }

    /**
     *  * 拦截 CommonException 的异常   * @param ex   * @return  
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ServerResponse exceptionHandler(BusinessException ex) {
        ServerResponse<String> response = new ServerResponse<String>(ex.getErrCode(), ex.getErrMsg());
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ServerResponse<String> handleBindException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder builder = new StringBuilder();
        for (FieldError error : fieldErrors) {
            builder.append(error.getDefaultMessage() + "\n");
        }
        ServerResponse<String> response = new ServerResponse<String>(ResponseCode.ARGUMENT_NOT_VALID.getCode(), builder.toString());
        return response;
    }

    /**
     * 处理请求单个参数不满足校验规则的异常信息
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ServerResponse<String> constraintViolationExceptionHandler(HttpServletRequest request, ConstraintViolationException exception) {
        ServerResponse<String> response = new ServerResponse<String>(ResponseCode.ARGUMENT_NOT_VALID.getCode(), exception.getMessage());
        return response;
    }


}
