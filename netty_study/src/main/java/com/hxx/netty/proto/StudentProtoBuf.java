package com.hxx.netty.proto;

/**
 * @Author 一闪一闪亮晶晶丶
 * @Date：2019/11/15 15:02
 * @Version v1.0
 */
public class StudentProtoBuf {
    public static void main(String[] args) throws Exception{
        StudentProto.Student student = StudentProto.Student.newBuilder().setName("张三").setAge(10).setAddress("上海浦东新区").build();
        System.out.println(student);

    }
}
