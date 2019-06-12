package com.ctl.recruitment.controller;

import com.ctl.recruitment.pojo.domain.AdministratorEntity;
import com.ctl.recruitment.pojo.result.DataTable;
import com.ctl.recruitment.pojo.result.ResultType;
import com.ctl.recruitment.repository.AdminDao;
import com.ctl.recruitment.service.CompanyService;
import com.ctl.recruitment.service.StudentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final
    AdminDao adminDao;

    private final StudentService studentService;
    private final CompanyService companyService;

    public AdminController(AdminDao adminDao, StudentService studentService, CompanyService companyService) {
        this.adminDao = adminDao;
        this.studentService = studentService;
        this.companyService = companyService;
    }

    @RequestMapping("/login")
    public ResultType adminLogin(HttpServletRequest request, @RequestParam String username,@RequestParam String password){
        AdministratorEntity admin = adminDao.findByAdminUsername(username);
        if(admin == null)
            return ResultType.Error("不存在该用户名！");
        if(!admin.getPassword().equals(password))
            return ResultType.Error("密码错误！");
        request.getSession().setAttribute("loginAdmin",admin);
        return ResultType.Success();
    }

    @RequestMapping("/list/{type}")
    public DataTable getInfoList(HttpServletRequest request, @PathVariable String type){
        if(null == request.getSession().getAttribute("loginAdmin"))
            return DataTable.Error("管理员未登录！");
        switch (type.charAt(0)){
            case 's':{
                return new DataTable<>(0,"",studentService.findUnverified().size(),studentService.findUnverified());
            }
            case 'c':{
                return new DataTable<>(0, "", companyService.findUnverifiedCompanies().size(), companyService.findUnverifiedCompanies());
            }
            default:break;
        }
        return DataTable.Error("查看列表出现错误！");
    }
    @RequestMapping("/done/{type}")
    public DataTable getDoneList(HttpServletRequest request, @PathVariable String type){
        if(null == request.getSession().getAttribute("loginAdmin"))
            return DataTable.Error("管理员未登录！");
        switch (type.charAt(0)){
            case 's':{
                return new DataTable<>(0,"",studentService.findVerified().size(),studentService.findVerified());
            }
            case 'c':{
                return new DataTable<>(0, "", companyService.findVerifiedCompanies().size(), companyService.findVerifiedCompanies());
            }
            default:break;
        }
        return DataTable.Error("查看列表出现错误！");
    }


    @RequestMapping("/pass/{type}")
    public ResultType getInfoList(HttpServletRequest request, @PathVariable String type,@RequestParam String username){
        if(null == request.getSession().getAttribute("loginAdmin"))
            return ResultType.Error("管理员未登录！");
        switch (type.charAt(0)){
            case 's':{
                adminDao.passStudent(username);
                return ResultType.Success();
            }
            case 'c':{
                adminDao.passCompany(username);
                return ResultType.Success();
            }
            default:break;
        }
        return ResultType.Error("Server: 未能通过该用户的身份验证");
    }

    @RequestMapping("/deny/{type}")
    public void deny(@PathVariable String type){}

}
