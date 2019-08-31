package com.example.demo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.mapper.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniuxy.dao.LogMapper;
import com.woniuxy.dao.NationMapper;
import com.woniuxy.domain.Log;
import com.woniuxy.domain.Nation;
import com.woniuxy.domain.PageBean;
import com.woniuxy.service.impl.LogServiceImpl;
import com.woniuxy.tools.Spell;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrjApplicationTests {
	@Resource
	private LogServiceImpl logService;
	
	@Resource
	private NationMapper nationMapper;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testName() throws Exception {
		List<Nation> list = nationMapper.selectByExample(null);
		for (Nation nation : list) {
			String spell = Spell.c(nation.getNation());
			String simplspell = Spell.simpleSpell(nation.getNation());
			nation.setSpell(spell);
			nation.setSimplespell(simplspell);
			nationMapper.updateByPrimaryKey(nation);
			}
		
	}

}
