package com.example.laizihan.startfornewlife.javaTest;

import java.util.List;

/**
 * 创建时间：2016年04月12日 上午1:02
 * 创建人：赖梓瀚
 * 类名：ClassLoaderTest
 * 用途：
 */
public class ClassLoaderTest {


    public static class MyClassLoader extends ClassLoader{

        @Override
        public Class<?> loadClass(String className) throws ClassNotFoundException {
            return super.loadClass(className);
        }

        @Override
        protected Class<?> findClass(String className) throws ClassNotFoundException {
            return super.findClass(className);
        }
    }


    private void autoBoxing(){
//        List<Integer> aa = [1,2,3];
    }

}
