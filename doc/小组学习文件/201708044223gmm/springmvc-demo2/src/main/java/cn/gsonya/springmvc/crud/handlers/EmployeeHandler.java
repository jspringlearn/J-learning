package cn.gsonya.springmvc.crud.handlers;

import cn.gsonya.springmvc.crud.dao.DepartmentDao;
import cn.gsonya.springmvc.crud.dao.EmployeeDao;
import cn.gsonya.springmvc.crud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private DepartmentDao departmentDao;

    //修改
    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id",required = false)Integer id,Map<String,Object>map){
        if(id!=null){
            Employee employees=employeeDao.get(id);
            map.put("employee",employees);
        }
    }

    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String input(@PathVariable("id")Integer id,Map<String,Object>map){
        map.put("employee",employeeDao.get(id));
        map.put("departments",departmentDao.getDepartments());
        return "input";
    }

    //删除
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    //添加
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String save(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //显示所有员工
    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public String input(Map<String,Object>map){
        map.put("departments",departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "input";
    }

    @RequestMapping("/emps")
    public String list(Map<String,Object> map){
        map.put("employees",employeeDao.getAll());
        return "list";
    }
}
