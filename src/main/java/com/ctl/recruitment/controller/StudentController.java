package com.ctl.recruitment.controller;

import com.ctl.recruitment.pojo.result.data.CompanyInfo;
import com.ctl.recruitment.pojo.result.data.JobApplicationInfo;
import com.ctl.recruitment.pojo.result.data.JobInfo;
import com.ctl.recruitment.pojo.result.ResultType;
import com.ctl.recruitment.service.CompanyService;
import com.ctl.recruitment.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {

    private final JobService jobService;
    private final CompanyService companyService;

    public StudentController(JobService jobService, CompanyService companyService) {
        this.jobService = jobService;
        this.companyService = companyService;
    }


    @RequestMapping("/register")
    public ResultType StudentRegister(
            @RequestParam String username,
            @RequestParam String password
            ){
        return ResultType.Success();
    }

    @RequestMapping("/studentValidate")
    public ResultType StudentValidate(){
        return null;
    }

    @RequestMapping("/login")
    public ResultType StudentLogin(HttpServletRequest request, String username, String password){
        return ResultType.Success();
    }

    @RequestMapping("/findJobs")
    public List<JobInfo>findJobs(
            HttpServletRequest request,
            String jobType,
            String place
    ){
        return null;
    }

    @RequestMapping("/sendResume")
    public ResultType sendResume(
            HttpServletRequest request,
            Integer resumeId,
            Integer targetJobId
    ){
        return null;
    }

    @RequestMapping("/myJobApplications")
    public JobApplicationInfo myJobApplications(HttpServletRequest request){
        return null;
    }


    @RequestMapping("/find/job-name")
    public ResultType findJobByJobName(@RequestParam String city,@RequestParam String name){

        try{
            List<JobInfo> res = jobService.findJobsByCityAndName(city,name);
            return ResultType.Success(res);
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("服务器查找失败");
        }
    }

    @RequestMapping("/find/company-name")
    public ResultType findCompanyByName(@RequestParam String city,@RequestParam String name){

        try{
            List<CompanyInfo> res = companyService.findCompaniesByCityAndName(city,name);
            return ResultType.Success(res);
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("服务器查找失败");
        }
    }


}
