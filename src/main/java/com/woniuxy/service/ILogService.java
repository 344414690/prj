package com.woniuxy.service;

import java.util.List;

import com.woniuxy.domain.Log;
import com.woniuxy.domain.PageBean;

public interface ILogService {
	 List findAll(Log log,PageBean pb);
}
