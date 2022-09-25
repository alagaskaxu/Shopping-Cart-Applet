package com.xu.service.impl;
import java.util.Arrays;
import java.util.Scanner;

public class suanfa {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("请输入main数组个数");
        int a=in.nextInt();//输入一个整数
        int ARRAYLENGTH=a;
        int array1[] = new int[ARRAYLENGTH];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个"+a +"位数组，以空格分隔：");
        for(int i = 0; i < array1.length; i++){
            array1[i] = sc.nextInt();
        }
        Arrays.sort(array1);
        System.out.println("数组main为:" + Arrays.toString(array1));
        Scanner in1 =new Scanner(System.in);
        System.out.println("请输入drinks数组个数");
        int b=in.nextInt();//输入一个整数
        int LENGTH=b;
        int array2[] = new int[LENGTH];
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入一个"+b +"位数组，以空格分隔：");
        for(int i = 0; i < array2.length; i++){
            array2[i] = sc1.nextInt();
        }
        //用toString方法打印数组a出来的是数组的首地址
        Arrays.sort(array2);
        System.out.println("数组drinks为:" + Arrays.toString(array2));
        Scanner in2 =new Scanner(System.in);
        System.out.println("请输入一个整数X=");
        int c=in.nextInt();//输入一个整数
        int x=c;
        System.out.println("金额x为"+x);
        int j=array2.length-1;
        int answer=0;
        int i=0;
        while ((i<array1.length)&&(j>=0)) {
            if (array1[i] + array2[j] <=x) {
                answer+=j+1;
                answer=answer%1000000007;
                i+=1;
            }
            else{
                j-=1;
            }
        }
        System.out.println(answer);
    }
}
