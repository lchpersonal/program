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

    public static Class complie(String src, String path) throws Exception {
        String fileName = path;
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(src);
        fileWriter.flush();
        fileWriter.close();
        System.out.println(fileName);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMrg = compiler.getStandardFileManager(null, null, null);
        Iterable iterable = fileMrg.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask compilationTask = compiler.getTask(null, fileMrg, null, null, null, iterable);
        compilationTask.call();
        fileMrg.close();
        URL url = new URL("file://H:/");
        URL[] urls = new URL[]{url};
        URLClassLoader classLoader = new URLClassLoader(urls);
        Class clazz = classLoader.loadClass("com.chengli.proxy.base.TankTimeProxy");
        /*删除生成的java文件*/
        //file.delete();
        return clazz;
    }
}
