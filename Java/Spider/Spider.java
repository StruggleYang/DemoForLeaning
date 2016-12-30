package spider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Spider {

	/**
	 * 网页爬虫，爬取网页源码及内容，通过URI及IO流
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*创建url链接*/
			URL url = new URL("http://read.qidian.com/chapter/_AaqI-dPJJ4uTkiRw_sFYA2/-doT6biEpYlOBDFlr9quQA2");
			/*开启连接*/
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			/*获取url连接中的输入流*/
			InputStream is=conn.getInputStream();
			//  将输入的字节流转换为字符流
			InputStreamReader isr=new InputStreamReader(is);
			//  建立缓冲区，从字符流中读取文本
			BufferedReader br=new BufferedReader(isr);
			String str;
			while((str=br.readLine())!=null){
				str=new String(str.getBytes(),"utf-8");
				System.out.println(str);
			}
			//  关闭各流
			br.close();
			isr.close();
			is.close();
			conn.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
