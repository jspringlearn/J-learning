package cn.gsonya.springmvc.handlers;

import cn.gsonya.springmvc.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author gsonya
 * @title
 * @Package cn.gsonya.springmvc
 * @date 2019/6/5 18:59
 */
/*
* index方法返回一个ModelAndView其中包括视图index.jsp 和 两个键值放入model当中，
* 在没有加入@sessionattributes注解的时候，放入model当中的键值是request级别的。
* 现在因为在Controller上面标记了@SessionAttributes(value={"attr1","attr2"})
* 那么model中的attr1,attr2会同步到session中，这样当你访问index
* 然后在去访问index2的时候也会获取这俩个属性的值。
* */
@SessionAttributes(value = {"user"},types = {String.class})
@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {
    private static final String SUCCESS ="success";

    @RequestMapping("/testView")
    public String testView(){
        System.out.println("testView");
        return "helloView";
    }

    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false)Integer id,Map<String,Object>map){
        if(id!=null){
            //模拟从数据库中获取对象
            User user=new User(1,"Tom","123456","tom@www.com",12);
            System.out.println("从数据库中获取一个对象："+user);
            map.put("user",user);
        }
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("修改："+user);
        return SUCCESS;
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("names", Arrays.asList("Tom","Jerry"));
        return SUCCESS;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName=SUCCESS;
        ModelAndView modelAndView=new ModelAndView(viewName);
        //添加模型数据到ModelAndView 中
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }

    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request, HttpServletResponse response, Writer out)throws IOException{
        System.out.println("testServletAPI,"+request+","+response);
        out.write("hello springmvc");
    }

    @RequestMapping("/testPojo")
    public String testPojo(User user){
        System.out.println("testPojo:"+user);
        return SUCCESS;
    }

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
