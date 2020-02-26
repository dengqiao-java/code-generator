package com.dengqiao.codegenerator.exception;

import com.alibaba.fastjson.JSON;
import com.dengqiao.codegenerator.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dengqiao
 * @date 2019-09-17 09:52
 */
@Component
@Slf4j
public class RRExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        R r = new R();
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setCharacterEncoding("utf-8");

            if ((ex instanceof RRException)) {
                r.put("code", Integer.valueOf(((RRException) ex).getCode()));
                r.put("msg", ((RRException) ex).getMessage());
            } else if ((ex instanceof DuplicateKeyException)) {
                r = R.error("数据库中已存在该记录");
            } else {
                r = R.error();
            }

            log.error(ex.getMessage(), ex);

            String json = JSON.toJSONString(r);
            response.getWriter().print(json);
        } catch (Exception e) {
            log.error("RRExceptionHandler 异常处理失败", e);
        }
        return new ModelAndView();
    }
}
