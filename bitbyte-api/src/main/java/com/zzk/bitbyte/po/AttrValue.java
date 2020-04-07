package com.zzk.bitbyte.po;

import java.util.Date;

public class AttrValue extends AttrValueKey {
    private Date createat;

    private Date updateat;

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