package com.ctl.recruitment.controller;

import com.ctl.recruitment.pojo.domain.CareerTalkEntity;
import com.ctl.recruitment.pojo.domain.CompanyEntity;
import com.ctl.recruitment.pojo.domain.JobEntity;
import com.ctl.recruitment.pojo.domain.ResumeEntity;
import com.ctl.recruitment.pojo.result.ResultType;
import com.ctl.recruitment.pojo.result.data.CareerTalkInfo;
import com.ctl.recruitment.pojo.result.data.CompanyInfo;
import com.ctl.recruitment.pojo.result.DataTable;
import com.ctl.recruitment.pojo.result.data.JobApplicationInfo;
import com.ctl.recruitment.pojo.result.data.JobInfo;
import com.ctl.recruitment.repository.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {


    private final StudentDao studentDao;
    private final CompanyDao companyDao;
    private final JobDao jobDao;
    private final CareerTalkDao careerTalkDao;
    private final ResumeDao resumeDao;

    public CompanyController(StudentDao studentDao, CompanyDao companyDao, JobDao jobDao, CareerTalkDao careerTalkDao, ResumeDao resumeDao) {
        this.studentDao = studentDao;
        this.companyDao = companyDao;
        this.jobDao = jobDao;
        this.careerTalkDao = careerTalkDao;
        this.resumeDao = resumeDao;
    }

    /*
    * 公司登录函数，接受companyId和密码，存入session。
    * */
    @RequestMapping("/login")
    public ResultType companyLogin(HttpServletRequest request, @RequestParam String companyId,@RequestParam String password){
        CompanyEntity c = companyDao.findByCompanyId(companyId);
        if(c == null)return ResultType.Error("公司账号不存在！");
        if(!c.getPassword().equals(password))return ResultType.Error("密码错误！");
        request.getSession().setAttribute("loginCompany",c);
        return ResultType.Success();
    }

    /*公司注册*/
    @RequestMapping("/register")
    public ResultType companyRegister(
            HttpServletRequest request,
            @RequestParam String companyId,
            @RequestParam String password,
            @RequestParam String email){
        if(companyDao.findByCompanyId(companyId)!= null)
            return ResultType.Error("注册失败：公司Id已经存在！");
        CompanyEntity c = new CompanyEntity();
        c.setCompanyId(companyId);
        c.setPassword(password);
        c.setEmail(email);
        try {
            companyDao.save(c);
            request.setAttribute("loginCompany",c);
            return ResultType.Success(); }
        catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("注册失败，未知错误");
        }
    }


    /*公司提交自己的信息进行公司身份验证*/
    @RequestMapping("/validate")
    public ResultType CompanyValidate(
            HttpServletRequest request,
            @RequestParam String companyName,
            @RequestParam String province,
            @RequestParam String city,
            @RequestParam String address,
            @RequestParam String type,
            @RequestParam String phone,
            @RequestParam String website,
            @RequestParam String detail){
        HttpSession session = request.getSession();
        CompanyEntity c = (CompanyEntity) session.getAttribute("loginCompany");
        try{
            c.setName(companyName);
            c.setProvince(province);
            c.setCity(city);
            c.setAddress(address);
            c.setType(type);
            c.setPhone(phone);
            c.setWebsite(website);
            c.setDetail(detail);
            companyDao.save(c);
            session.setAttribute("loginCompany",c);
            return ResultType.Success(); }
        catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("未能更新公司验证信息");
        }
    }


    /*公司查看自己的信息*/
    @RequestMapping("/info")
    public ResultType showCompanyInfo(HttpServletRequest request){
        CompanyEntity c =(CompanyEntity) request.getSession().getAttribute("loginCompany");
        if(null == c)return ResultType.Error("未登录");
        try{
            return ResultType.Success(new CompanyInfo(c)); }
        catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("信息查找失败，出现未知错误");
        }
    }


    /*添加新职位*/
    @RequestMapping("/job/new")
    public ResultType addJob(
            HttpServletRequest request,
            @RequestParam String jobName,
            @RequestParam Date appDeadline,
            @RequestParam Integer requireNum,
            @RequestParam String workHour,
            @RequestParam String detail){
        CompanyEntity c = (CompanyEntity) request.getSession().getAttribute("loginCompany");
        if(c == null)return ResultType.Error("您还未登录！");
        try {
            jobDao.createNewJob(jobName,c.getCompanyId(),requireNum,workHour,appDeadline,detail);
            return ResultType.Success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("工作添加失败");
        }
    }

    /*查看职位*/
    @RequestMapping("/job/list")
    public DataTable<JobInfo> findAllJobs(
            HttpServletRequest request,
            @RequestParam(required = false,defaultValue = "1")Integer page,
            @RequestParam(required = false,defaultValue = "30")Integer limit
    ){
        CompanyEntity companyEntity = (CompanyEntity) request.getSession().getAttribute("loginCompany");
        if(companyEntity==null)
            return new DataTable<>(1,"处于未登录状态",0,null);

        String companyId = companyEntity.getCompanyId();
        List<JobEntity> jobEntities= jobDao.findByCompanyId(companyId,(page-1)*limit,limit);
        List<JobInfo>res = new ArrayList<>();
        for(JobEntity j:jobEntities)
            res.add(new JobInfo(j));
        return new DataTable<>(0,"",jobDao.getCountByCompanyId(companyId),res);
    }


    /*添加宣讲会*/
    @RequestMapping("/career-talk/new")
    public ResultType addCareerTalk(
            HttpServletRequest request,
            @RequestParam String place,
            @RequestParam Timestamp heldTime
    ){
        CompanyEntity companyEntity = (CompanyEntity) request.getSession().getAttribute("loginCompany");
        if(companyEntity==null)
            return ResultType.Error("处于未登录状态。");


        CareerTalkEntity ct = new CareerTalkEntity();
        ct.setCompany(companyEntity);
        ct.setPlace(place);
        ct.setHeldTime(heldTime);
        careerTalkDao.save(ct);
        return ResultType.Success();
    }


    /*查看自己公司举办的宣讲会*/
    /*status:all:全部
             pending:还没有举行的宣讲会
             finished:举办成功的宣讲会*/
    @RequestMapping("/career-talk/list/{type}")
    public DataTable findCareerTalks(
            HttpServletRequest request,
            @PathVariable String type,
            @RequestParam(required = false,defaultValue = "1")Integer page,
            @RequestParam(required = false,defaultValue = "30")Integer limit
    ){
        CompanyEntity companyEntity = (CompanyEntity) request.getSession().getAttribute("loginCompany");
        if(companyEntity==null)
            return DataTable.Error("处于未登录状态。");
        String companyId = companyEntity.getCompanyId();
        Integer bg = (page-1)*limit;

        List<CareerTalkEntity> careerTalkEntities;
        Integer count;
        switch (type.charAt(0)){
            case'p':{
                careerTalkEntities = careerTalkDao.findPendingByCompany(companyId,bg,limit);
                count = careerTalkDao.countPendingByCompany(companyId);
                break;
            }
            case'f':{
                careerTalkEntities = careerTalkDao.findFinishedByCompany(companyId,bg,limit);
                count = careerTalkDao.countFinishedByCompany(companyId);
                break;
            }
            default:{
                careerTalkEntities = careerTalkDao.findAllByCompany(companyId,bg,limit);
                count = careerTalkDao.countAllByCompany(companyId);
                break;
            }
        }

        List<CareerTalkInfo>res = new ArrayList<>();
        for(CareerTalkEntity c:careerTalkEntities){
            res.add(new CareerTalkInfo(c.getCompany().getName(),c.getPlace(),c.getHeldTime()));
        }

        return new DataTable<>(0, "", count, res);
    }


    /*查看自己公司的职位申请*/
    /*type 分为四种类型all,pending,doing,finished*/
    @RequestMapping("/application/list/{type}")
    public DataTable findApplications(
            HttpServletRequest request,
            @PathVariable String type,
            @RequestParam(required = false,defaultValue = "1")Integer page,
            @RequestParam(required = false,defaultValue = "30")Integer limit
    ){
        CompanyEntity companyEntity = (CompanyEntity) request.getSession().getAttribute("loginCompany");
        if(companyEntity==null)
            return DataTable.Error("处于未登录状态。");
        String companyId = companyEntity.getCompanyId();
        Integer bg = (page-1)*limit;

        List<ResumeEntity> resumeEntities;
        Integer count;
        switch (type.charAt(0)){
            case 'p':{
                resumeEntities = resumeDao.findPendingByCompanyId(companyId,bg,limit);
                count = resumeDao.countPendingByCompanyId(companyId);
                break;
            }
            case 'd':{
                resumeEntities = resumeDao.findProcessingByCompanyId(companyId,bg,limit);
                count = resumeDao.countProcessingByCompanyId(companyId);
                break;
            }
            case 'f':{
                resumeEntities = resumeDao.findFinishedByCompanyId(companyId,bg,limit);
                count = resumeDao.countFinishedByCompanyId(companyId);
                break;
            }
            default:{
                resumeEntities = resumeDao.findAllByCompanyId(companyId,bg,limit);
                count = resumeDao.countAllByCompanyId(companyId);
                break;
            }
        }
        List<JobApplicationInfo>res = new ArrayList<>();
        for(ResumeEntity r:resumeEntities){
            res.add(new JobApplicationInfo(
                    r.getResumeId(),
                    r.getJobId(),
                    studentDao.findByUsername(r.getStudentUsername()).getRealName(),
                    jobDao.findByJobId(r.getJobId()).getJobName(),
                    jobDao.findByJobId(r.getJobId()).getCompanyByCompanyId().getName(),
                    r.getStatus()
            ));
        }
        return new DataTable<>(0, "", count, res);
    }


    @RequestMapping("/application/resume")
    public ResultType getResumeInfo(
            HttpServletRequest request,
            @RequestParam Integer resumeId
    ){
        CompanyEntity companyEntity = (CompanyEntity) request.getSession().getAttribute("loginCompany");
        if(companyEntity==null)
            return ResultType.Error("处于未登录状态。");
        return ResultType.Success(resumeDao.findByResumeId(resumeId));
    }

}
