package com.woniuxy.domain;

public class Tree {
	private boolean open = true;
    public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	private Integer tid;

    private String name;

    private String file;

    private Integer pid;

    private String icon;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}