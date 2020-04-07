package com.zzk.bitbyte.po;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Record extends RecordKey {
    @NotBlank(message = "记录内容不能为空!")
    private String recordContent;

    private Date createat;

    private Date updateat;

    public String getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent == null ? null : recordContent.trim();
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public Date getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Date updateat) {
        this.updateat = updateat;
    }
}