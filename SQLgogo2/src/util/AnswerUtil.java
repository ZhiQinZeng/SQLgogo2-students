package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

public class AnswerUtil {
	
	@Test
	public void test() throws IOException{
		//通过类加载器读取src目录中的 properties文件
		URL url = AnswerUtil.class.getClassLoader().getResource("words.txt");
		String pathname = url.toString();
		System.out.println(pathname);
		FileInputStream fis = new FileInputStream("E:/SQLgogo代码备份/SQLgogogai/SQLgogo2/SQLgogo2/WebRoot/WEB-INF/classes/words.txt");
		byte[] buff = new byte[1024]; 
		int hasread = 0;
		StringBuffer res = new StringBuffer();
		while((hasread=fis.read(buff))>0){
			//System.out.println(new String(buff,0,hasread));
			res.append(new String(buff,0,hasread));
		}
		System.out.println(res.toString());
		System.out.println(res.length());
		String[] str = res.toString().split("\n");
		System.out.println(str);
	}
}
