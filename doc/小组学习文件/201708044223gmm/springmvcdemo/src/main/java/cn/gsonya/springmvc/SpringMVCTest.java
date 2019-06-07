package cn.gsonya.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author gsonya
 * @title
 * @Package cn.gsonya.springmvc
 * @date 2019/6/5 18:59
 */
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
    private static final String SUCCESS ="success";

    //更新
    @RequestMapping(value = "/testRestPut/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public String testRestPut(@PathVariable Integer id){
        System.out.println("testRest PUT:"+id);
        return SUCCESS;
    }

    //删除
    @RequestMapping(value = "/testRestDelete/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String testRestDelete(@PathVariable Integer id){
        System.out.println("testRest DELETE:"+id);
        return SUCCESS;
    }

    //增添
    @RequestMapping(value = "/testRestPost",method = RequestMethod.POST)
    public String testRestPost(){
        System.out.println("testRest POST");
        return SUCCESS;
    }

    //查询
    @RequestMapping(value = "/testRestGet/{id}",method = RequestMethod.GET)
    public String testRestGet(@PathVariable Integer id){
        System.out.println("testRest GET:"+id);
        return SUCCESS;
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("testVariable"+id);
        return SUCCESS;
    }

    @RequestMapping(value = "testParamsAndHeaders",params = {"username","age!=10"})
    public String testParamsAndHeaders(){
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    @RequestMapping(value = "/testMethod",method = RequestMethod.POST)
    public String testMethod(){
        System.out.println("testMethod");
        return SUCCESS;
    }

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("testRequestMapping");
        return SUCCESS;
    }
}
