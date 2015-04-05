package com.kevin.aeas.operation.db.mybatis;

import com.kevin.aeas.object.BasicException;
import com.kevin.aeas.object.FirstCourse;
import com.kevin.aeas.operation.db.mybatis.inter.MyBatisFirstCourse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class MyBatisBaseOperation<T> {
    protected static SqlSessionFactory sqlSessionFactory;
    protected T proxy;
    static{
        try{
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected Class<T> mybatisMapper;
    public MyBatisBaseOperation(Class<T> mybatisMapper){
        this.mybatisMapper = mybatisMapper;
        this.proxy = (T)  Proxy.newProxyInstance(MyBatisBaseOperation.class.getClassLoader(),
                                 new Class[]{mybatisMapper}, new MyBatisInvocationHandler<>(mybatisMapper));
    }


    public static class MyBatisInvocationHandler<T> implements InvocationHandler{
        private Class<T> mybatisMapper;
        public MyBatisInvocationHandler(Class<T> mybatisMapper){
            this.mybatisMapper = mybatisMapper;
        }

        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable{
            if(method.getName().startsWith("get")){
                return invokeWithoutTransaction(method, args);
            }else{
                return invokeWithTransaction(method, args);
            }
        }

        private Object invokeWithTransaction(Method method, Object[] args){
            SqlSession session = null;
            try {
                session = sqlSessionFactory.openSession();
                T myBatisInstance = session.getMapper(mybatisMapper);
                method.invoke(myBatisInstance, args);
                session.commit();
            }catch (Exception e){
                session.rollback();
                throw new BasicException(e);
            }finally {
                session.close();
            }
            return null;
        }

        private Object invokeWithoutTransaction(Method method, Object[] args) throws Throwable{
            Object result = null;
            SqlSession session = null;
            try {
                session = sqlSessionFactory.openSession();
                T myBatisInstance = session.getMapper(mybatisMapper);
                result = method.invoke(myBatisInstance, args);
            }catch(Exception e){
                throw new BasicException(e);
            }finally {
                session.close();
            }
            return result;
        }
    }
}
