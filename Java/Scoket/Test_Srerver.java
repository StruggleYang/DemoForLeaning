import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test_Srerver {

	/**
	 * @param 服务器
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		while(true) {
		//  创建服务器，并指定服务器端口号
			ServerSocket so = new ServerSocket(8989);
			System.out.println("服务器创建成功……");
			
			//  监听端口的连接
			Socket s = so.accept();
			System.out.println("客户端连接成功……");
			
			//  获取客户端输入字节流
			InputStream is = s.getInputStream();
			//  转换为字符流
			InputStreamReader rs = new InputStreamReader(is);
			BufferedReader buff = new BufferedReader(rs);
			System.out.println("客户端信息："+buff.readLine());
			
			// 创建输出字节流
			OutputStream os = s.getOutputStream();
			// 创建打印流
			PrintStream pw = new PrintStream(os);
			System.out.println("服务器发送：");
			Scanner can = new Scanner(System.in);
			String x = can.next();
			pw.println(x);
			
			pw.close();
			os.close();
			rs.close();
			buff.close();
			is.close();
			s.close();
			so.close();
		}
	}
}
