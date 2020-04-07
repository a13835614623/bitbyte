package com.zzk.bitbyte.po;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class RecordKey {
    @NotBlank(message = "用户不能为空!")
    private String recordUser;

    private Date recordTime;

    public String getRecordUser() {
        return recordUser;
    }

    public void setRecordUser(String recordUser) {
        this.recordUser = recordUser == null ? null : recordUser.trim();
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}