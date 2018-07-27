package com.example.reflection2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MyClass {

    public static void main(String[] args) {
//        classForName();
//        showDeclaredMethods();
//        showMethod();
//        showDeclaredFields();
//        showFields();
        getAnnotationInfos();
    }

    /**
     * 通过Class对象构造目标类型对象
     */
    private static void classForName() {
        try {
            //获取Class对象
            Class<?> clz = Class.forName("com.example.reflection2.Student");
            //通过Class对象获取Constructor,Student的构造方法有一个字符串参数
            //因此需要传递参数的类型
            Constructor<?> constructor = clz.getConstructor(String.class);
            //通过constructor来创建Student对象
            Object obj = constructor.newInstance("mr.simple");
            System.out.println(" obj : "+obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射获取类中定义的方法
     * 返回所有属性的函数，不包含父类
     */
    private static void showDeclaredMethods() {
        Student student = new Student("mr.simple");
        Method[] methods = student.getClass().getDeclaredMethods();
        for(Method method:methods) {
            System.out.println("declared method name : "+method.getName());
        }

        try {
            Method learnMethod = student.getClass().getDeclaredMethod("learn",String.class);
            //获取方法的参数类型列表
            Class<?>[] paramClasses = learnMethod.getParameterTypes();
            for(Class<?> class1:paramClasses) {
                System.out.println("learn方法的参数类型 ： "+ class1.getName());
            }
            //是否是Private函数，属性是否是private也可以用该方式判断
            System.out.println(learnMethod.getName() + " is private " + Modifier.isPrivate(learnMethod.getModifiers()));
            //为true时，反射的对象在使用时应该取消java语言访问检查
            //为false时，反射的对象在使用时应该实施Java语言访问检查
            learnMethod.setAccessible(true);
            learnMethod.invoke(student,"java ----->");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回类中定义的方法
     * getMethod:返回public类属性函数且包含父类
     */
    private static void showMethod() {
        Student student = new Student("mr.simple");
        Method[] methods = student.getClass().getMethods();
        for(Method method:methods) {
            System.out.println("method name : "+method.getName());
        }
        try {
            Method method = student.getClass().getMethod("learn",String.class);
            Class<?>[] paramClasses = method.getParameterTypes();
            for (Class<?> param:paramClasses) {
                System.out.println("learn方法参数类型 : "+param.getName());
            }
            System.out.println(method.getName()+" is private "+Modifier.isPrivate(method.getModifiers()));
            method.invoke(student,"java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射获取类中定义的属性
     * 返回所有属性的函数，不包含父类
     */
    private static void showDeclaredFields() {
        Student student = new Student("mr.simple");
        Field[] fields = student.getClass().getDeclaredFields();
        for(Field field:fields) {
            System.out.println("declared field name : "+field.getName());
        }

        try {
            Field gradeField = student.getClass().getDeclaredField("mGrade");
            //获取属性值
            System.out.println("my grade is : "+gradeField.getInt(student));
            //设置属性值
            gradeField.setInt(student,10);
            System.out.println("my grade is : "+gradeField.getInt(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射获取类中定义的属性
     * 返回所有属性的函数，不包含父类
     */
    private static void showFields() {
        Student student = new Student("mr.simple");
        Field[] fields = student.getClass().getFields();
        for(Field field:fields) {
            System.out.println(" field name : "+field.getName());
        }

        try {
            Field gradeField = student.getClass().getField("mGrade");
            //获取属性值
            System.out.println("my grade is : "+gradeField.getInt(student));
            //设置属性值
            gradeField.setInt(student,10);
            System.out.println("my grade is : "+gradeField.getInt(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getAnnotationInfos(){
        Student student = new Student("mr.simple");
        Test classTest = student.getClass().getAnnotation(Test.class);
        System.out.println("class Annotation tag : "+classTest.tag());
        Field field = null;
        try {
            field = student.getClass().getDeclaredField("mGrade");
            Test testAnnotation = field.getAnnotation(Test.class);
            System.out.println("属性的Test 注解 tag : "+testAnnotation.tag());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
