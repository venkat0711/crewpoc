package com.delta.css.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.delta.css.excp.DbSvcExcp;

/**
 * Using this methods business need to communicate with database
 * 
 */

@Component
public class BsDbCon {
   
   @Autowired
    private DataSrcConfig dbConfig;
   
    public BsDbCon() {
    	dbConfig = new  DataSrcConfig();
    	
    }

    @SuppressWarnings("rawtypes")
    public Collection getRows(String statementId, Object parameterObj) throws DbSvcExcp {
        List list;
        SqlSession sqlSession = null;
        try {
        	sqlSession =dbConfig.getSqlSessionFactory().openSession();
            list = sqlSession.selectList(statementId, parameterObj);
        } catch (Exception e) {
            throw new DbSvcExcp(e);
        } finally {
        	if (sqlSession!=null)
            sqlSession.close();
        }
        return list;
    }
}
