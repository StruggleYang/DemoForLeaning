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
	 * ��ҳ���棬����jsoup��ȡ��ҳ�ľ������ݣ����ı�����ͨ��IO��д���ļ�
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// ����jsoup��
		// �����ļ�����,��ȡ��������д�뵽���ļ�
		File file = new File("D:/SX.txt");
		// �����ļ������
		FileOutputStream fos = new FileOutputStream(file);
		// �ַ�-�ֽ�ת����
		OutputStreamWriter osw = new  OutputStreamWriter(fos,"UTF-8");
		// ��������������Ķ���
		BufferedWriter bw=new BufferedWriter(osw);
		// Ҫ��ȡ���ݵ���ҳ��ַ
		Document document = Jsoup.connect("http://read.qidian.com/chapter/_AaqI-dPJJ4uTkiRw_sFYA2/-doT6biEpYlOBDFlr9quQA2").get();
		// ȡ����ҳ������Ԫ��
		Elements eles = document.getAllElements();
		for(int i=0;i<eles.size();i++) {
			//  ����ȡ��ÿһ��Ԫ��
			Element ele = eles.get(i);
			//  ȡ����ҳԪ���������Ƚ�
			if(ele.className().equals("read-content j_readContent")) {
				// ȥ��ͷβ��ǩ
				String str = ele.html().replaceAll("\\<p>", "").replaceAll("\\</p>", "");
				bw.write(str);
				if(str!=null&&str!="") {
					System.out.println("д��ɹ�");
				}
			}
		}
		//  �ر���
		bw.close();
		fos.close();
	}

}
