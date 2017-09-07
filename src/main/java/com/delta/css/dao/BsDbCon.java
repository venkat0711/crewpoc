package com.delta.css.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
   
   @Autowired
   private SqlSessionFactory sqlSessionFactory ;
    

    public BsDbCon() {
    	dbConfig = new  DataSrcConfig();
    	
    }

    public Object getRow(String statementId) throws DbSvcExcp {
        Object obj;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            obj = sqlSession.selectOne(statementId);
        } catch (Exception e) {
            throw new DbSvcExcp(e);
        } finally {
            sqlSession.close();
        }
        return obj;
    }

    public Object getRow(String statementId, Object parameterObj) throws DbSvcExcp {
        Object obj;
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            obj = sqlSession.selectOne(statementId, parameterObj);
        } catch (Exception e) {
            throw new DbSvcExcp(e);
        } finally {
            sqlSession.close();
        }
        return obj;
    }

    @SuppressWarnings("rawtypes")
    public Collection getRows(String statementId) throws DbSvcExcp {
        List list;
       // SqlSession sqlSession = sqlSessionFactory.openSession(dbConfig.getDataSource());
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            list = sqlSession.selectList(statementId);
        } catch (Exception e) {
            throw new DbSvcExcp(e);
        } finally {
            sqlSession.close();
        }
        return list;
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
            sqlSession.close();
        }
        return list;
    }
}
