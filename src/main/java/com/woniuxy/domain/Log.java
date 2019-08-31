package com.woniuxy.domain;

import java.util.Date;

public class Log {
    private Integer logid;

    private Integer uid;

    private String action;

    private Date actiontime;

    private String uname;

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getActiontime() {
        return actiontime;
    }

    public void setActiontime(Date actiontime) {
        this.actiontime = actiontime;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

	@Override
	public String toString() {
		return "Log [logid=" + logid + ", uid=" + uid + ", action=" + action + ", actiontime=" + actiontime + ", uname="
				+ uname + "]";
	}
    
}