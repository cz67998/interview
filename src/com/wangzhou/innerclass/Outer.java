package com.wangzhou.innerclass;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/20
 * Time:13:33
 **/
public class Outer {
    private int outerVariable = 1;
    private int commonVariable = 2;
    private static int outerStaticVariable = 3;
    //省略getter/setter

    /**
     * 成员方法
     */
    public void outerMethod() {
        System.out.println("我是外部类的outerMethod方法");
    }

    /**
     * 静态方法
     */
    public static void outerStaticMethod() {
        System.out.println("我是外部类的outerStaticMethod静态方法");
    }

    /**
     * 内部类
     */
    public class  Inner {

        private int commonVariable = 20;

        /**
         * 构造方法
         */
        public Inner() {
        }

        /**
         * 成员方法，访问外部类信息（属性、方法）
         */
        public void innerShow() {
            //当和外部类冲突时，直接引用属性名，是内部类的成员属性
            System.out.println("内部的commonVariable:" + commonVariable);
            //内部类访问外部属性
            System.out.println("outerVariable:" + outerVariable);
            //当和外部类属性名重叠时，可通过外部类名.this.属性名
            System.out.println("外部的commonVariable:" + Outer.this.commonVariable);
            System.out.println("outerStaticVariable:" + outerStaticVariable);
            //访问外部类的方法
            outerMethod();
            outerStaticMethod();
        }
    }

    /**
     *	外部类访问内部类信息
     */
    public void outerShow() {
        Inner inner = new Inner();
        inner.innerShow();
    }

}
class Other {

    public static void main(String[] args) {
        //外部类对象
        Outer outer = new Outer();
        //创造内部类对象
        Outer.Inner inner = outer.new Inner();
        inner.innerShow();
        /*
         * 可在Outer中定义get方法，获得Inner对象,那么使用时，只需outer.getInnerInstance()即可。
         * public Inner getInnerInstance(Inner类的构造方法参数){
         *   return new Inner(参数);
         * }
         */
    }
}
