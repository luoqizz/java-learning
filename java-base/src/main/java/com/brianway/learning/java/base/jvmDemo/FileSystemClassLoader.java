package com.brianway.learning.java.base.jvmDemo;

import java.io.*;

/**
 * Demo03自定义类加载器
 */
public class FileSystemClassLoader extends ClassLoader {
    public String rootDir;//定义根节点

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class c = findLoadedClass(name); //查找当前要加载的类是否存在

        //如果已经加载则返回该类，如果没有则加载新的类。
        if (c != null){
            return c;
        }else{
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);//委派给父类加载器
            }catch (Exception e){
            }

            if (c !=null){
                return c;
            }else{
                byte [] classdate = getClassDate(name);
                if (classdate == null){
                    throw new ClassNotFoundException();
                }else{
                    c = defineClass(name,classdate,0,classdate.length);
                }
            }
        }
        return c;
    }

    private byte[] getClassDate(String name) {
        String path = rootDir +"/"+name.replace(".","/")+".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte [] buffer = new byte[1024];
            int temp = 0;
            while ((temp = is.read(buffer)) != -1){
                baos.write(buffer,0,temp);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
