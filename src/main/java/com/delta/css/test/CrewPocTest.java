package com.delta.css.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.delta.css.bo.CrewRotnAtvyRestBo;
import com.delta.css.excp.DataAcesExcp;
import com.delta.css.vo.CrewInfoInputVo;

public class CrewPocTest {
	static CrewRotnAtvyRestBo crewRotnAtvyRestBo;
	
	 @BeforeClass
	    public static void setUp() throws Exception {
	        crewRotnAtvyRestBo = new CrewRotnAtvyRestBo();
	        
	    }
	 
	 @Test
	public void testUptoDateCount() {
		CrewInfoInputVo crewInfoInputVo = new CrewInfoInputVo();
		crewInfoInputVo.setDate("2017-09-08");
		crewInfoInputVo.setEmplId("0000111111");
		try {
			crewRotnAtvyRestBo.uptoDateCount(crewInfoInputVo);
		} catch (DataAcesExcp e) {
			e.printStackTrace();
		}
	}
	 
	 @Test
	public void testvalidation() {
		String userId = "0000111111";
		String pass = "delta_user";
		crewRotnAtvyRestBo.validation(userId, pass);
	}

}
