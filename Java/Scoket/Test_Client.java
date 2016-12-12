import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Test_Client {

	/**
	 * @param 客户端
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		while(true) {
			//  创建一个客户端
			Socket s = new Socket("127.0.0.1",8989);
			System.out.println("客户端创建成功，服务器连接成功");
			// 创建输出字节流
			OutputStream os = s.getOutputStream();
			// 创建打印流
			PrintStream pw = new PrintStream(os);
			System.out.println("客户端发送：");
			Scanner can = new Scanner(System.in);
			String x = can.next();
			pw.println(x);
			
			
			//  获取服务器端字节流
			InputStream is = s.getInputStream();
			//  转换为字符流
			InputStreamReader rs = new 	InputStreamReader(is);
			BufferedReader buff =new BufferedReader(rs);
			//  输出
			System.out.println("服务器消息："+buff.readLine());
			
			buff.close();
			rs.close();
			is.close();
			pw.close();
			os.close();
		}
			
	}

}
