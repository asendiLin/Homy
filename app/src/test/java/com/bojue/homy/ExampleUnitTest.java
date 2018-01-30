package com.bojue.homy;

import android.content.Context;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
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
    public void test()  {

        int K=4;//进制
        int L=2;//位数
        long count=0;

        long start = (long) Math.pow(10,L-1);
        long end= (long) Math.pow(10,L);

        for (long i = start; i < end; i++) {
            String str=Long.toString(i,K);
            char[] cArr=str.toCharArray();
            int j = 1;
            for (; j <cArr.length && Math.abs(cArr[j]-cArr[j-1])!=1; j++) {

            }
            if (j==cArr.length){
                count++;
                System.out.println(i);
            }
        }

        System.out.println(count%1000000007);
//        String infile="C:\\copy.sql";
//        String outfile="C:\\copy.txt";
//        //获取源文件和目的文件的输入输出流
//        FileInputStream fin=new FileInputStream(infile);
//        FileOutputStream fout=new FileOutputStream(outfile);
//        //获取输入输出通道
//        FileChannel fcin= fin.getChannel();
//        FileChannel fcout=fout.getChannel();
//
//        //创建缓冲区
//        ByteBuffer buffer=ByteBuffer
//                .allocate(1024);
//        while (true){
//            //重设缓冲区，可以接收新的数据
//            buffer.clear();
//            //从通道的数据读到缓冲区
//            int r=fcin.read(buffer);
//            if (r==-1){
//                break;
//            }
//            //让缓冲区可以将新都如的数据写入另一个通道
//            buffer.flip();
//            //从输出通道中将数据写入缓冲区
//            fcout.write(buffer);
//
//        }
//        Charset charset=Charset.forName("GBK");
//
//        InetSocketAddress socketAddress=new InetSocketAddress("www.baidu.com",80);
//
//        SocketChannel channel = null;
//        try {
//            channel = SocketChannel.open(socketAddress);
//            //打开连接
//            channel.write(charset.encode("GET "+"/ HTTP/1.1"+"\r\n\r\n"));
//            //读取数据
//            ByteBuffer buffer=ByteBuffer.allocate(1024);
//            while (channel.read(buffer)!=-1){
//                buffer.flip();
//                System.out.println(charset.decode(buffer));
//                buffer.clear();//清空缓冲
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (channel!=null){
//                    channel.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }


    public static void sort(Comparable[] a){
        //打乱排序

    }
}

