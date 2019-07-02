package com.wangzhou.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/1
 * Time:9:48
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution33 {
    /*
说下思路，如果p是丑数，那么p=2^x * 3^y * 5^z
那么只要赋予x,y,z不同的值就能得到不同的丑数。
如果要顺序找出丑数，要知道下面几个特（fei）点（hua）。
对于任何丑数p：
（一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
（二）如果p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q
现在说说算法思想：
    由于1是最小的丑数，那么从1开始，把2*1，3*1，5*1，进行比较，得出最小的就是1
的下一个丑数，也就是2*1，
    这个时候，多了一个丑数‘2’，也就又多了3个可以比较的丑数，2*2，3*2，5*2，
这个时候就把之前‘1’生成的丑数和‘2’生成的丑数加进来也就是
(3*1,5*1,2*2，3*2，5*2)进行比较，找出最小的。。。。如此循环下去就会发现，
每次选进来一个丑数，该丑数又会生成3个新的丑数进行比较。
*/
    public int GetUglyNumber_Solution1(int index) {
        if(index==0)return 0;
        int p2=0,p3=0,p5=0,num=1;
        List<Integer> list =new ArrayList<>();
        list.add(num);
        while(list.size()<index){
             num=Math.min(list.get(p2)*2,Math.min(list.get(p3)*3,list.get(p5)*5));
            if(list.get(p2)*2==num)p2++;
            if(list.get(p3)*3==num)p3++;
            if(list.get(p5)*5==num)p5++;
            list.add(num);
        }
        return num;
    }

    /*
       上面的暴力方法也应该能解决，但是如果在面试官用这种方法，估计面试官只会摇头吧
   。下面说一个O（n）的算法。
       在上面的特（fei）点（hua）中，既然有p<q, 那么2*p<2*q，那么
   “我”在前面比你小的数都没被选上，你后面生成新的丑数一定比“我”大吧，那么你乘2
   生成的丑数一定比我乘2的大吧，那么在我选上之后你才有机会选上。
   其实每次我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
   数。也就是比较(2*x , 3*y, 5*z) ，x>=y>=z的，
   重点说说下面代码中p的作用：int p[] = new int[] { 0, 0, 0 }; p[0]表示最小用于
   乘2比较数在数组a中的【位置】。 */
    private final int[] d = {2, 3, 5};

    public int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
        int a[] = new int[index];
        a[0] = 1;
        int[] p = new int[]{0, 0, 0};
        int[] num = new int[]{2, 3, 5};
        int cur = 1;
        while (cur < index) {
            int m = min(num[0], num[1], num[2]);
            System.out.println(m);
            if (a[cur - 1] < num[m]) a[cur++] = num[m];
            p[m] += 1;
            num[m] = a[p[m]] * d[m];
        }
        return a[index - 1];
    }

    private int min1(int x2, int x3, int x5) {
        int k = x2 < x3 ? x2 : x3;
        return x3 < k ? x3 : k;
    }

    private int min(int num2, int num3, int num5) {
        int min = Math.min(num2, Math.min(num3, num5));
        return min == num2 ? 0 : min == num3 ? 1 : 2;
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.GetUglyNumber_Solution1(0));
        System.out.println(solution33.GetUglyNumber_Solution1(1));
        System.out.println(solution33.GetUglyNumber_Solution1(2));
        System.out.println(solution33.GetUglyNumber_Solution1(3));
        System.out.println(solution33.GetUglyNumber_Solution1(4));
        System.out.println(solution33.GetUglyNumber_Solution1(5));
        System.out.println(solution33.GetUglyNumber_Solution1(6));
        System.out.println(solution33.GetUglyNumber_Solution1(7));
        System.out.println(solution33.GetUglyNumber_Solution1(8));
        System.out.println(solution33.GetUglyNumber_Solution1(9));
        System.out.println(solution33.GetUglyNumber_Solution1(11));
        System.out.println(solution33.GetUglyNumber_Solution1(12));


    }
}
