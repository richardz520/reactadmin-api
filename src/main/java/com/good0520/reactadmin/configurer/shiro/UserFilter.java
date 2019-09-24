package com.good0520.reactadmin.configurer.shiro;

import com.alibaba.fastjson.JSONObject;
import com.good0520.reactadmin.core.Result;
import com.good0520.reactadmin.core.ResultCode;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Good0520
 * @date 2019/9/23
 */
public class UserFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {
            //设置响应头
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json");
            //设置返回的数据
            //写回给客户端
            PrintWriter out = httpResponse.getWriter();
            Result result = new Result();
            result.setCode(ResultCode.UNAUTHORIZED);
            result.setMessage("登录已过期，请重新登录");
            out.write(result.toString());
            //刷新和关闭输出流
            out.flush();
            out.close();
            return false;
        }
        return true;
    }
}
