package spider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Spider {

	/**
	 * ��ҳ���棬��ȡ��ҳԴ�뼰���ݣ�ͨ��URI��IO��
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*����url����*/
			URL url = new URL("http://read.qidian.com/chapter/_AaqI-dPJJ4uTkiRw_sFYA2/-doT6biEpYlOBDFlr9quQA2");
			/*��������*/
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			/*��ȡurl�����е�������*/
			InputStream is=conn.getInputStream();
			//  ��������ֽ���ת��Ϊ�ַ���
			InputStreamReader isr=new InputStreamReader(is);
			//  ���������������ַ����ж�ȡ�ı�
			BufferedReader br=new BufferedReader(isr);
			String str;
			while((str=br.readLine())!=null){
				str=new String(str.getBytes(),"utf-8");
				System.out.println(str);
			}
			//  �رո���
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
