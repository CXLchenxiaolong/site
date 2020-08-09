package com.site.webapp.filter;

import com.alibaba.fastjson.JSON;
import com.site.common.ServerResponse;
import com.site.common.constants.SystemConstants;
import com.site.common.enums.ResponseCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @Description:根据TOKEN获取用户信息，并放入session中
 * @Author: CXL
 * @Date: 2020/8/8 8:41 下午
 */
@Slf4j
@Component
@WebFilter(urlPatterns = { "/api/v1/*" }, filterName = "tokenAuthFilter")
public class TokenAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        String token = req.getHeader("token");//header方式

        boolean isFilter = false;

        ServerResponse serverResponse = ServerResponse.success();

        String method = ((HttpServletRequest) request).getMethod();
        if (method.equals("OPTIONS")) {
            rep.setStatus(HttpServletResponse.SC_OK);
        }else{
            if (null == token || token.isEmpty()) {
                serverResponse = ServerResponse.fail(ResponseCodeEnum.TOKEN_NULL);
            } else {
//                if (TokenUtil.volidateToken(token)) {
//                    resultInfo.setCode(Constant.SUCCESS);
//                    resultInfo.setMsg("用户授权认证通过!");
//                    isFilter = true;
//                } else {
//                    serverResponse = ServerResponse.fail(ResponseCodeEnum.TOKEN_ILLEGAL);
//                }
                //用户信息放入session后面统一通过session取出
                req.getSession().setAttribute(SystemConstants.USER_INFO,null);
            }
            if (!serverResponse.getRespCode().equals(ResponseCodeEnum.SUCCESS.getCode())) {
                PrintWriter writer = null;
                OutputStreamWriter osw = null;
                try {
                    osw = new OutputStreamWriter(response.getOutputStream(),
                            "UTF-8");
                    writer = new PrintWriter(osw, true);
                    String jsonStr = JSON.toJSONString(serverResponse);
                    writer.write(jsonStr);
                    writer.flush();
                    writer.close();
                    osw.close();
                } catch (UnsupportedEncodingException e) {
                    log.error("过滤器返回信息失败:" + e.getMessage(), e);
                } catch (IOException e) {
                    log.error("过滤器返回信息失败:" + e.getMessage(), e);
                } finally {
                    if (null != writer) {
                        writer.close();
                    }
                    if (null != osw) {
                        osw.close();
                    }
                }
                return;
            }else{
                filterChain.doFilter(request, response);
            }

        }

    }

    @Override
    public void destroy() {

    }
}
