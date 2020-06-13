package com.tingxiang.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.openjdk.jol.info.ClassLayout;

public class JVMTest {
	private int a;
	private long b = 2;
	private long[] c = new long[] {};
	private long[] d = new long[] {1,2};
	private static long e;
	private static int f = 0;
	private boolean g;
	private String s = "test";
	private Integer h = 3;
	
	public void test(long b) {
		b = 3;
		System.out.println(b);
		System.out.println(this.b);
	}
	
	public void test1(String s) {
		s = "test11";
		System.out.println(s);
		System.out.println(this.s);
	}
	
	public void test2(Integer h) {
		h = 4;
		System.out.println(h);
		System.out.println(this.h);
	}
	
	public void test3(final long[] d) {
		d[1] = 3;
		System.out.println(d[1]);
		System.out.println(this.d[1]);
	}
	public void test4(long[] d) {
		d = new long[] {0, 1};
		System.out.println(d[1]);
		System.out.println(this.d[1]);
	}
	
	public static void main(String[] args) {
		JVMTest obj = new JVMTest();	
		obj.test(obj.b);
		obj.test1(obj.s);
		obj.test2(obj.h);
		obj.test3(obj.d);
		obj.test4(obj.d);
		System.out.println(ClassLayout.parseInstance(obj).toPrintable());
		System.out.println(ClassLayout.parseInstance(obj.c).toPrintable());
		System.out.println(ClassLayout.parseInstance(obj.d).toPrintable());
		System.out.println(ClassLayout.parseInstance(obj.e).toPrintable());
		System.out.println(ClassLayout.parseInstance(obj.f).toPrintable());
//		try {
//			Thread.sleep(1000000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String s = new String("abc");
		System.out.println(ClassLayout.parseInstance(s).toPrintable());
		String s1 = "abc";
		System.out.println(ClassLayout.parseInstance(s1).toPrintable());
	}
	
	HashMap<String, Object> hash = new HashMap<String, Object>();
	ConcurrentHashMap<String, Object> con = new ConcurrentHashMap<K, V>();
}
