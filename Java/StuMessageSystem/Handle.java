import java.util.Scanner;
/**
 * @author 1107--stuggleYang
 */
/*主界面*/
public class Handle {
	public static void main(String[] args) {
		Class h = new Class(); //班级对象
		h.inSystem(); // 系统主界面
		Scanner input = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("-------------【请选择业务】：");
			int inNum = input.nextInt();
			switch(inNum){
				case 1:
					h.Login(); // 登录
					break;
				case 2:
					h.add(); // 添加
					break;
				case 3:
					h.queryAll(); // 查询全部
					break;
				case 4:
					h.queryForNum(); // 按学号姓名查询
					break;
				case 5:
					h.update(); // 修改
					break;
				case 6:
					h.delete(); // 删除
					break;
				case 7: 
					flag =false; // 退出
					System.out.println("------------【退出成功】-------------");
					break;
				default:
					System.out.println("------------【输入有误】-------------");
			}	
		}
	}
}
