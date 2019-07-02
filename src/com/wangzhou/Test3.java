package com.wangzhou;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/29
 * Time:16:33
 **/
public class Test3 {
    public class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int cn = sc1.nextInt();
        int[][] dis = new int[cn][cn];
        char[][] mp = new char[cn][cn];
        Node a = new Test3().new Node(-1, -1);
        Node ed = new Test3().new Node(-1, -1);
        Queue<Node> q = new LinkedList();
        for (int i = 0; i < cn; i++) {
            Scanner sc2 = new Scanner(System.in);
            String s = sc2.next();
            for (int i1 = 0; i1 < s.length(); i1++) {
                char c = s.charAt(i1);
                mp[i][i1] = c;
                if (c == '*') {
                    a.x = i;
                    a.y = i1;
                    q.add(a);
                    dis[i][i1] = 0;
                }else if (c == '@') {
                    ed.x = i;
                    ed.y = i1;
                    dis[i][i1] = -1;
                } else {
                    dis[i][i1] = -1;
                }
            }
        }
        int[] r1 = new int[]{-1, 0, 1, 0};
        int[] r2 = new int[]{0, 1, 0, -1};
        while (!q.isEmpty()) {
            Node p = q.remove();
            for (int i = 0; i < 4; i++) {
                int x = p.x + r1[i];
                int y = p.y + r2[i];
                if ( x >= 0 && x < cn && y >= 0 && y < cn && mp[x][y] != '#'&&dis[x][y] == -1) {
                    Node pp = new Test3().new Node(x, y);
                    q.add(pp);
                    dis[x][y] = dis[p.x][p.y] + 1;
                    if (x == ed.x && y == ed.y) {
                        break;
                    }
                }
            }
//            if (dis[ed.x][ed.y] != -1) break;
        }
        System.out.println(dis[ed.x][ed.y]);
    }

}
