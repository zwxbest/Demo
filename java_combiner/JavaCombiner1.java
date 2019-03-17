package com.nizouba.java_combiner;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zwxbest on 2018/3/15.
 */
public class JavaCombiner {

    public int add()
    {

    }

    public static void  main(String[] args)
    {
        if(args.length<2)
        {
            System.out.println("请输入两个文件的文件名，按空格分割，如果文件名中有空格，请加引号");
            return;
        }
        File file1=new File(args[0]);
        if(!file1.exists())
        {
            System.out.println("第1个文件不存在，请确认路径是否正确");
            return;
        }
        File file2=new File(args[1]);
        if(!file2.exists())
        {
            System.out.println("第2个文件不存在，请确认路径是否正确");
            return;
        }
        try {
           String file= mergeJavaFile(file1,file2);
            PrintStream ps = new PrintStream(new FileOutputStream(UUID.randomUUID()+".java"));
            ps.println(file);
            ps.close();
        }
        catch (Exception e)
        {
            System.out.println("处理失败，请确认是Java文件且无错误");
            return;
        }

    }

    public static String mergeJavaFile(File newfile,File oldfile) throws Exception
    {
        CompilationUnit newunit= JavaParser.parse(newfile);
        CompilationUnit oldunit= JavaParser.parse(oldfile);
        mergeImports(newunit.getImports(),oldunit.getImports());
        NodeList<TypeDeclaration<?>>  newtype=  newunit.getTypes();
        NodeList<TypeDeclaration<?>>  oldtype=  oldunit.getTypes();
        //暂时只考虑一个文件只有一个类
        //合并method
        NodeList<BodyDeclaration<?>> newMmeber=newtype.get(0).getMembers();
        NodeList<BodyDeclaration<?>> oldMmeber=oldtype.get(0).getMembers();

        List<MethodDeclaration> newMethodDeclarations=new ArrayList<>();
        List<MethodDeclaration> oldMethodDeclarations=new ArrayList<>();
        List<FieldDeclaration> oldFieldDeclarations=new ArrayList<>();
        List<FieldDeclaration> newFieldDeclarations=new ArrayList<>();
        getMethodAndFileds(newMethodDeclarations,newFieldDeclarations,newMmeber);
        getMethodAndFileds(oldMethodDeclarations,oldFieldDeclarations,oldMmeber);

        MergeMethods(oldMmeber,oldMethodDeclarations,newMethodDeclarations );
        MergeFiedls(oldMmeber,oldFieldDeclarations,newFieldDeclarations );
        return oldunit.toString();

    }
    private static void getMethodAndFileds(List<MethodDeclaration> methodDeclarations,List<FieldDeclaration>  fieldDeclarations,NodeList<BodyDeclaration<?>> members)
    {
        for(BodyDeclaration member:members )
        {
            if(member instanceof MethodDeclaration)
            {
                methodDeclarations.add((MethodDeclaration)member);
            }
            else if(member instanceof FieldDeclaration)
            {
                fieldDeclarations.add((FieldDeclaration)member);
            }
        }
    }

    //合并import，添加到imports2
    public static void mergeImports(NodeList<ImportDeclaration> imports1,NodeList<ImportDeclaration> imports2)
    {
        boolean findSameImport;
        for(int i=0;i<imports1.size();i++){
            ImportDeclaration importDeclaration1=imports1.get(i);
            findSameImport = false;
            for(int j=0;j<imports1.size();j++)
            {
                ImportDeclaration importDeclaration2=imports2.get(j);
                if(importDeclaration2.equals(importDeclaration1))
                {
                    findSameImport=true;
                    break;
                }
            }
            if(findSameImport==false)
            {
                //添加不存在的
                imports2.add(importDeclaration1);
            }
        }
    }

    private static void  MergeFiedls(NodeList<BodyDeclaration<?>> allOldMethods,List<FieldDeclaration> oldFields, List<FieldDeclaration> newFields)
    {
        boolean findSameField;
        for(int i=0;i<newFields.size();i++)
        {
            findSameField=false;
            FieldDeclaration newField=newFields.get(i);
            for(int j=0;j<oldFields.size();j++)
            {
                FieldDeclaration oldField=oldFields.get(j);
                if(newField.equals(oldField))
                {
                    findSameField=true;
                }
            }
            if(findSameField==false)
            {
                allOldMethods.add(newField);
            }
        }
    }

    /**
     * 参照重载定义
     * 参数,方法名都相同则为同一方法
     * @param oldMethods
     * @param newMethods
     */
    private static void MergeMethods(NodeList<BodyDeclaration<?>> allOldMethods,List<MethodDeclaration> oldMethods, List<MethodDeclaration> newMethods) {
        boolean findSameMethod=false;
        for (int i=0;i<newMethods.size();i++) {
            findSameMethod=false;
            MethodDeclaration newMethod = newMethods.get(i);
            for (int j = 0; j < oldMethods.size(); j++) {
                MethodDeclaration oldMethod = oldMethods.get(j);
                //方法名相同
                if (newMethod.getName().toString().equals(oldMethod.getName().toString()))
                {
                    boolean sameParameters = true;
                    NodeList<Parameter> oldParameters = oldMethod.getParameters();
                    NodeList<Parameter>  newParameters = newMethod.getParameters();
                    //参数要求顺序
                    if (oldParameters.size() != newParameters.size()) {
                        sameParameters = false;//继续遍历oldmethod
                        continue;
                    }
                    for (int k = 0; k < oldParameters.size(); k++) {
                        //类型不匹配,
                        if (oldParameters.get(k).getType().toString().equals(newParameters.get(k).getType().toString()) == false) {
                            sameParameters = false;
                            break;
                        }
                    }
                    //返回值,名称,参数类相同,同一方法
                    if (sameParameters == true) {
                        findSameMethod=true;
                        break;//跳出oldmethod,继续遍历newmethod
                    }
                }
            }
            if(findSameMethod==false)
            {
                allOldMethods.add(newMethod);
            }
        }
    }


}
