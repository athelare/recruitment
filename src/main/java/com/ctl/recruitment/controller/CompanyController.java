package com.ctl.recruitment.controller;

import com.ctl.recruitment.pojo.result.data.JobApplicationItem;
import com.ctl.recruitment.pojo.result.JobApplicationTable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompanyController {
    @RequestMapping("tempTable1")
    public JobApplicationTable tempTable1(){
        JobApplicationItem item = new JobApplicationItem();
        List<JobApplicationItem> ls = new ArrayList<>();
        item.setApplicationId("001");
        item.setName("技术研发岗位");
        item.setResume("asfs");
        item.setSchool("DHU");
        item.setSubmit_time("2019");
        ls.add(item);

        JobApplicationTable tb = new JobApplicationTable();
        tb.setData(ls);
        tb.setCode(0);
        tb.setMsg("");
        tb.setCount(300);

        return tb;
    }
}
