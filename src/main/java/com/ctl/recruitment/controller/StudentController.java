package com.ctl.recruitment.controller;

import com.ctl.recruitment.pojo.domain.ResumeEntity;
import com.ctl.recruitment.pojo.domain.StudentEntity;
import com.ctl.recruitment.pojo.result.data.CompanyInfo;
import com.ctl.recruitment.pojo.result.data.JobApplicationInfo;
import com.ctl.recruitment.pojo.result.data.JobInfo;
import com.ctl.recruitment.pojo.result.ResultType;
import com.ctl.recruitment.pojo.result.data.StudentInfo;
import com.ctl.recruitment.service.CompanyService;
import com.ctl.recruitment.service.JobService;
import com.ctl.recruitment.service.StudentService;
import com.ctl.recruitment.util.ExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {

    private final JobService jobService;
    private final CompanyService companyService;
    private final StudentService studentService;

    public StudentController(JobService jobService, CompanyService companyService, StudentService studentService) {
        this.jobService = jobService;
        this.companyService = companyService;
        this.studentService = studentService;
    }


    @RequestMapping("/register")
    public ResultType StudentRegister(
            HttpServletRequest request,
            @RequestParam String username,
            @RequestParam String password
            ){
        try {
            StudentEntity student = new StudentEntity();
            student.setUsername(username);
            student.setPassword(password);
            request.getSession().setAttribute("loginUser",studentService.StudentRegister(username,password));
            return ResultType.Success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("注册失败！可能的原因：用户名已经存在");
        }

    }

    @RequestMapping("/send-student-info")
    public ResultType StudentValidate(
            HttpServletRequest request,
            @RequestParam String realName,
            @RequestParam String studentId,
            @RequestParam String identityNum,
            @RequestParam String universityProvince,
            @RequestParam String universityName,
            @RequestParam String enrollYear,
            @RequestParam String schoolName,
            @RequestParam String phone,
            @RequestParam String email
    ){
        try {
            StudentEntity student = (StudentEntity) request.getSession().getAttribute("loginUser");
            if(student == null)
                return ResultType.Error("Server: 更新信息失败，您还未登录");
            student.setStudentId(studentId);
            student.setRealName(realName);
            student.setUniversityProvince(universityProvince);
            student.setUniversityName(universityName);
            student.setEnrollYear(enrollYear);
            student.setSchoolName(schoolName);
            student.setIdentityNum(identityNum);
            student.setPhone(phone);
            student.setEmail(email);
            studentService.saveStudentInfo(student);
            return ResultType.Success();
        }catch (NullPointerException e){
            e.printStackTrace();
            return ResultType.Error("Server: 更新信息失败，出现空指针");
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("Server: 未知错误，更新信息失败！");
        }
    }

    @RequestMapping("/login")
    public ResultType StudentLogin(HttpServletRequest request, String username, String password){
        HttpSession session = request.getSession();
        StudentEntity student = studentService.findByStudentUsername(username);
        if(student == null)
            return ResultType.Error("用户不存在！");
        if(!student.getPassword().equals(password))
            return ResultType.Error("密码错误！");
        session.setAttribute("loginUser",student);
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

    @RequestMapping("/resume/init")
    public ResultType initResume(
            HttpServletRequest request,
            @RequestParam Integer jobId
    ){
        try {
            HttpSession session = request.getSession();
            ResumeEntity resume = new ResumeEntity();
            StudentEntity student = (StudentEntity) session.getAttribute("loginUser");
            if(student == null)
                return ResultType.Error("Server: 更新信息失败，您还未登录");
            resume.setStudentUsername(student.getUsername());
            resume.setJobId(jobId);
            session.setAttribute("newResume",resume);
            return ResultType.Success();
        }catch (Exception e){
            return ResultType.Error("简历创建失败！");
        }
    }

    @RequestMapping("/resume/step1")
    public ResultType CreateResumeStep1(
            HttpServletRequest request,
            @RequestParam String name,
            @RequestParam Integer sex,
            @RequestParam(defaultValue = "default.png") String portraitAddress,
            @RequestParam String city,
            @RequestParam String phone,
            @RequestParam String email
    ){
        try{
            ResumeEntity resume = (ResumeEntity) request.getSession().getAttribute("newResume");
            if(resume == null)
                return ResultType.Error("Server: Session中不存在resume，请按顺序进行操作！");

            resume.setName(name);
            resume.setSex(sex);
            resume.setPortraitAddress(portraitAddress);
            resume.setCity(city);
            resume.setPhone(phone);
            resume.setEmail(email);

            return ResultType.Success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("Server: 保存失败，可能的原因：未登录");
        }
    }

    @RequestMapping("/resume/step2")
    public ResultType CreateResumeStep2(
            HttpServletRequest request,
            @RequestParam String university,
            @RequestParam String eduBegin,
            @RequestParam String eduEnd,
            @RequestParam String degree,
            @RequestParam String majorName,
            @RequestParam Double GPA,
            @RequestParam Integer GPARank,
            @RequestParam String majorCourse,
            @RequestParam String awards
    ){
        try{
            ResumeEntity resume = (ResumeEntity) request.getSession().getAttribute("newResume");
            if(resume == null)
                return ResultType.Error("Server: Session中不存在resume，请按顺序进行操作！");
            resume.setUniversity(university);
            resume.setEduBeginTime(eduBegin);
            resume.setEduEndTime(eduEnd);
            resume.setEduDegree(degree);
            resume.setMajorName(majorName);
            resume.setGpa(GPA);
            resume.setGpaRank(GPARank);
            resume.setMajorCourse(majorCourse);
            resume.setAwards(awards);
            return ResultType.Success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("Server"+ ExceptionUtil.getExceptionInformation(e));
        }

    }

    @RequestMapping("/resume/step3")
    public ResultType CreateResumeStep3(
            HttpServletRequest request,
            @RequestParam String internCompany,
            @RequestParam String internPosition,
            @RequestParam Date internBegin,
            @RequestParam Date internEnd,
            @RequestParam String internDetail,
            @RequestParam String projectName,
            @RequestParam String projectRole,
            @RequestParam String projectDetail,
            @RequestParam Date projectBegin,
            @RequestParam Date projectEnd
    ){
        try{
            ResumeEntity resume = (ResumeEntity) request.getSession().getAttribute("newResume");
            if(resume == null)
                return ResultType.Error("Server: Session中不存在resume，请按顺序进行操作！");
            resume.setInternCompany(internCompany);
            resume.setInternPosition(internPosition);
            resume.setInternStart(internBegin);
            resume.setInternEnd(internEnd);
            resume.setInternDetail(internDetail);
            resume.setProjectName(projectName);
            resume.setProjectRole(projectRole);
            resume.setProjectDetail(projectDetail);
            resume.setProjectStart(projectBegin);
            resume.setProjectEnd(projectEnd);
            return ResultType.Success(studentService.saveResume(resume));
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("保存数据库过程中出现错误！\n"+ ExceptionUtil.getExceptionInformation(e));
        }



    }

    //TODO DELETE
    @RequestMapping("/resume/show-new-resume")
    public ResultType showNewResume(HttpServletRequest request){
        return ResultType.Success(request.getSession().getAttribute("newResume"));
    }

    @RequestMapping("/resume/my-resume")
    public ResultType showMyResumes(HttpServletRequest request){
        StudentEntity student = (StudentEntity) request.getSession().getAttribute("loginUser");
        try {
            return ResultType.Success(studentService.findResumesByUsername(student.getUsername()));
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("简历查找失败！");
        }
    }

    @RequestMapping("/personal-info")
    public ResultType showPersonalInfo(HttpServletRequest request) {
        try {
            StudentEntity student = (StudentEntity) request.getSession().getAttribute("loginUser");
            return ResultType.Success(
                    new StudentInfo(
                            student.getUsername(),
                            student.getRealName(),
                            student.getUniversityName(),
                            student.getPhone(),
                            student.getEmail()
                    )
            );
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("个人信息查找失败！");
        }
    }

    @RequestMapping("/follow/add")
    public ResultType addFollow(HttpServletRequest request,String companyId) {
        try {
            StudentEntity student = (StudentEntity) request.getSession().getAttribute("loginUser");
            studentService.addFollow(student.getUsername(),companyId);
            return ResultType.Success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("关注失败！");
        }
    }

    @RequestMapping("/follow/delete")
    public ResultType deleteFollow(HttpServletRequest request,String companyId) {
        try {
            StudentEntity student = (StudentEntity) request.getSession().getAttribute("loginUser");
            studentService.deleteFollow(student.getUsername(),companyId);
            return ResultType.Success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("删除失败！");
        }
    }

    @RequestMapping("/follow/show")
    public ResultType showMyFollow(HttpServletRequest request){
        try {
            StudentEntity student = (StudentEntity) request.getSession().getAttribute("loginUser");
            return ResultType.Success(
                    studentService.showFollow(student.getUsername())
            );
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("收藏信息查找失败！");
        }
    }

    @RequestMapping("/follow/career-talks")
    public ResultType showCareerTalks(HttpServletRequest request){
        try{
            StudentEntity student = (StudentEntity) request.getSession().getAttribute("loginUser");
            return ResultType.Success(studentService.findCareerTalks(student.getUsername()));
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("未能查找宣讲会");
        }

    }
}
