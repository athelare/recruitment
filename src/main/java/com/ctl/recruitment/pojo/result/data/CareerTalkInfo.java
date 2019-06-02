package com.ctl.recruitment.pojo.result.data;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CareerTalkInfo {
    private static DateFormat df;
    static {
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }

    private String companyName,place;
    private String heldTime;

    public CareerTalkInfo(String companyName, String place, Timestamp heldTime) {
        this.companyName = companyName;
        this.place = place;
        this.heldTime = df.format(heldTime);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getHeldTime() {
        return heldTime;
    }

    public void setHeldTime(String  heldTime) {
        this.heldTime = heldTime;
    }
}
