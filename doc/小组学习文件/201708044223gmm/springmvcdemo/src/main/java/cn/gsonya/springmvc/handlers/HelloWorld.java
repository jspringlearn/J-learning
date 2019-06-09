package cn.gsonya.springmvc.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gsonya
 * @title
 * @Package cn.gsonya.springmvc
 * @date 2019/6/5 16:16
 */
@Controller
public class HelloWorld {
    //@RequestMapping("/springmvc.xml")
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }
}
