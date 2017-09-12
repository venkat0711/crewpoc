package com.delta.css.test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.delta.css.excp.BsnObjExcp;
import com.delta.css.excp.DataAcesExcp;
import com.delta.css.excp.DbSvcExcp;
import com.delta.css.utils.CssApiCnst;

public class CrewPocExpTest {
	static BsnObjExcp bsnObjExcp = new BsnObjExcp(new Exception());
	static DataAcesExcp dataAcesExcp = new DataAcesExcp(new Exception());
	static DbSvcExcp dbSvcExcp = new DbSvcExcp(new Exception());

	@BeforeClass
	public static void setUp() throws Exception {
		bsnObjExcp = new BsnObjExcp(CssApiCnst.SERVLET_EXCEPTION, new Exception());
		bsnObjExcp = new BsnObjExcp(CssApiCnst.SERVLET_EXCEPTION);
		dataAcesExcp = new DataAcesExcp(CssApiCnst.SERVLET_EXCEPTION, new Exception());
		dataAcesExcp = new DataAcesExcp(CssApiCnst.SERVLET_EXCEPTION);
		dbSvcExcp = new DbSvcExcp(CssApiCnst.SERVLET_EXCEPTION, new Exception());
		dbSvcExcp = new DbSvcExcp(CssApiCnst.SERVLET_EXCEPTION);
	}

	@Test
	public void testBsnObjExcp() {
		bsnObjExcp.getException();
		bsnObjExcp.getRootCause();
		bsnObjExcp.toString();
	}

	@Test
	public void testDataAcesExcp() {
		dataAcesExcp.getException();
		dataAcesExcp.getRootCause();
		dataAcesExcp.toString();
	}

	@Test
	public void testDbSvcExcp() {
		dbSvcExcp.getException();
		dbSvcExcp.getRootCause();
		dbSvcExcp.toString();
	}

}
