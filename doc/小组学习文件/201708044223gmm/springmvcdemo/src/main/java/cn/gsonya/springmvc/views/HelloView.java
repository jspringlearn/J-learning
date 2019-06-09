package cn.gsonya.springmvc.views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @author gsonya
 * @title
 * @Package cn.gsonya.springmvc.views
 * @date 2019/6/9 12:32
 */
@Component
public class HelloView implements View {
    @Override
    public String getContentType(){
        return "text/html";
    }
    @Override
    public void render(Map<String,?>model, HttpServletRequest request,
                       HttpServletResponse response)throws Exception{
        response.getWriter().print("hello view,time:"+new Date());
    }
}
