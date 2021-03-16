package com.bbxx.pojo;

/**
 * 多对多的中间表
 */
public class MiddleVO {
    private Integer uId;
    private Integer rId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }
}
