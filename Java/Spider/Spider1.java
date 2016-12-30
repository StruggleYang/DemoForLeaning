package spider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider1 {

	/**
	 * 网页爬虫，利用jsoup爬取网页的具体内容，如文本，并通过IO流写入文件
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 导入jsoup包
		// 创建文件对象,爬取到的内容写入到此文件
		File file = new File("D:/SX.txt");
		// 创建文件输出流
		FileOutputStream fos = new FileOutputStream(file);
		// 字符-字节转换流
		OutputStreamWriter osw = new  OutputStreamWriter(fos,"UTF-8");
		// 创建输出缓冲流的对象
		BufferedWriter bw=new BufferedWriter(osw);
		// 要获取内容的网页地址
		Document document = Jsoup.connect("http://read.qidian.com/chapter/_AaqI-dPJJ4uTkiRw_sFYA2/-doT6biEpYlOBDFlr9quQA2").get();
		// 取得网页的所有元素
		Elements eles = document.getAllElements();
		for(int i=0;i<eles.size();i++) {
			//  遍历取得每一个元素
			Element ele = eles.get(i);
			//  取得网页元素类名并比较
			if(ele.className().equals("read-content j_readContent")) {
				// 去掉头尾标签
				String str = ele.html().replaceAll("\\<p>", "").replaceAll("\\</p>", "");
				bw.write(str);
				if(str!=null&&str!="") {
					System.out.println("写入成功");
				}
			}
		}
		//  关闭流
		bw.close();
		fos.close();
	}

}
