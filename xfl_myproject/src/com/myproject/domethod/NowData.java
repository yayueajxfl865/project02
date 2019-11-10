
package com.myproject.domethod;
import java.util.Date;
import java.text.SimpleDateFormat;
public class NowData {//规范化获取当前系统时间
	public static void main(String[] args) { 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date()));
		}
	

}
