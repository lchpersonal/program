package com.chengli.proxy.base;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by chengli on 2015/11/21.
 */
public class Complier {

    public static Class complie(String src,String path) throws Exception {
        String fileName = System.getProperty("user.dir") + path;
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(src);
        fileWriter.flush();
        fileWriter.close();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMrg = compiler.getStandardFileManager(null,null,null);
        Iterable iterable = fileMrg.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask  compilationTask = compiler.getTask(null,fileMrg,null,null,null,iterable);
        compilationTask.call();
        fileMrg.close();

        URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/proxy/target/classes")};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class clazz = classLoader.loadClass("com.chengli.proxy.version002.TankTimeProxy");
        return clazz;
    }
}
