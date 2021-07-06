package com.liuz.gulimall.member.enumTest;

/**
 *  学习测试枚举类
 *          使用情况： 当需要定义一组常量的时候，强烈建议使用枚举类 【情况固定，一年四季，一周七天  只能用不能重新赋值】
 *          理解： 当一个类的对象只有有限个，确定的，我们称此类为枚举类
 *          如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 *          定义的枚举类默认继承于 Java.long.Enum类
 *
 */
public enum EnumTest {
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天")
    ;


    private String desc;

    // 构造方法
    EnumTest(String desc) {
        this.desc = desc;
    }
}
