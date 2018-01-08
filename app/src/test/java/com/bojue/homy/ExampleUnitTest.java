package com.bojue.homy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {

        Scanner scanner=new Scanner(System.in);

//        int n=scanner.nextInt();

        int n=2;

        if (n<1||n>34)
            return;

        int a[][]=new int[n][n];

        for (int i = 0; i < n; i++) {//初始化
            a[i][0]=a[i][i]=1;
            for (int j = 1; j < i; j++) {
                a[i][j]=a[i-1][j-1]+a[i-1][j];
            }
        }

//        输出

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i ; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }

    }
}

