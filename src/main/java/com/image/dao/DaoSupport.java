package com.image.dao;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("daoSupport")
public class DaoSupport implements DAO {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 保存obj
     * @param str : 引用的方法
     * @param obj : 传入的对象
     * @return
     * @throws Exception
     */
    @Override
    public Object save(String str, Object obj) throws Exception {
        return sqlSessionTemplate.insert(str, obj);
    }

    //批量保存
    void batchSave(String str, List objs) throws Exception{

        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();

        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false)) {
            if (objs != null) {
                for (Object obj : objs) {
                    sqlSession.insert(str,obj);
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }
    }

    //更新
    @Override
    public Object update(String str, Object obj) throws Exception {
        return sqlSessionTemplate.update(str, obj);
    }

    //批量更新
    void batchUpdate(String str, List objs) throws Exception{
        SqlSessionFactory SqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        //批量执行器
        try (SqlSession sqlSession = SqlSessionFactory.openSession(ExecutorType.BATCH, false)) {
            if (objs != null) {
                for (Object obj : objs) {
                    sqlSession.update(str, obj);
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }
    }

    //删除
    @Override
    public Object delete(String str, Object obj) throws Exception {
        return sqlSessionTemplate.delete(str, obj);
    }

    //批量删除
    Object batchDelete(String str, List objs) throws Exception{
        return sqlSessionTemplate.delete(str, objs);
    }


    @Override
    public Object findForObject(String str, Object obj) throws Exception {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    @Override
    public Object findForList(String str, Object obj) throws Exception {
        return sqlSessionTemplate.selectList(str, obj);
    }

    @Override
    public Object findForMap(String sql, Object obj, String key, String value) throws Exception {
        return sqlSessionTemplate.selectMap(sql, obj, key);
    }
}
