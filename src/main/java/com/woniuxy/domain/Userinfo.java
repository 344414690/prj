package com.woniuxy.domain;

import java.util.List;

public class Userinfo {
	//查询出用户数放的集合
	private List trees;
	public List getTrees() {
		return trees;
	}
	public void setTrees(List trees) {
		this.trees = trees;
	}
	//查询出用户角色放的集合
	private List roles;
    public List getRoles() {
		return roles;
	}
	public void setRoles(List roles) {
		this.roles = roles;
	}

	private Integer uid;

    private String uname;

    private String upwd;

    private Boolean isdelete;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }
}