package cn.gsonya.springmvc.crud.handlers;

import cn.gsonya.springmvc.crud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author gsonya
 * @title
 * @Package cn.gsonya.springmvc.crud.handlers
 * @date 2019/6/9 19:05
 */
@Controller
public class EmployeeHandler {
    @Autowired
    private EmployeeDao employeeDao;
    @RequestMapping("/emps")
    public String list(Map<String,Object> map){
        map.put("employee",employeeDao.getAll());
        return "list";
    }
}
