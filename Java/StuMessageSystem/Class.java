import java.util.Scanner;
/**
 * @author 1107--stuggleYang
 */
/*班级类*/
public class Class {
	static Students[] stus = new Students[100]; // 定义一个数组保存学生对象
	
	//系统主界面提示
	public void inSystem(){
		sop("---------------------------【学生管理系统】----------------------------\n"
				+"【1.登录】【2.添加】【3.查询全部】【4.学号&姓名查询】【5.修改】【6.删除】【7.退出】\n"
				+"---------------------------【学生管理系统】----------------------------\n");
	}
	
	//登录
	public void Login() {
		sop("------------【登录】-------------");
		Scanner in = new Scanner(System.in);
		for(int x = 3;x >=1;x--) { // 一旦登录失败，最多登录三次
			sop("【请输入学号】：");
			int inXh = in.nextInt();
			sop("【请输入密码】：");
			String inMm = in.next();
			for(int i = 0;i < stus.length-1;i++) {
				if(stus[i]==null){ // 如果第一个位置就为空，则表示在系统中不存在任何数据，直接返回主界面
					sop("【登录失败,未有任何用户存在】");
					return; //直接结束方法
				}else if(inXh == stus[i].getNum() && inMm.equals(stus[i].getPwd())) { // 找到学号和密码都相符合的则登录成功
					sop("【登录成功】");
					return;
				}else{ // 如果有数据但是输入中无与数据中相符合的，则用掉一次机会，直至三次机会用完
					sop("【登录失败，此用户不存在，你还有"+(x-1)+"次登录机会】");
					break;
				}
			}
		}
	}
		
	//添加
	public void add(){
		sop("+++++++++++++++【添加信息】+++++++++++++++");
		Scanner in = new Scanner(System.in);
		int numAdd=0;  // 定义一个变量来保存最后得到的数据为空的角标
		for (int y=0 ; y < stus.length-1;y++) {
			// 判断是否有数据，如果有，就将本次添加的数据添加到下一个角标，添加到不同位置避免覆盖
			// stus[y].getNum()! 解决因为添加失败后开辟了一个数组位却没有值得情况
	 		if (stus[y]!=null && stus[y].getNum()!=0) { 
	 			numAdd++;
	 		}
		}
		stus[numAdd] = new Students(); // 在得到空位角标后，在空位角标处，添加一个学生对象
		//将所有的输入信息赋给建立的学生对象的属性
		sop("学号：");
		int inNum = in.nextInt();
		sop("姓名：");
		String inName = in.next();
		sop("年龄：");
		int inAge = in.nextInt();
		sop("性别：");
		String inSex = in.next();
		sop("密码：");
		String inPwd = in.next();
		for(int i = 0;i<stus.length;i++) {
			if(stus[i] != null && inNum ==stus[i].getNum()){
				sop("【添加失败，学号"+inNum+"已存在，请重新添加】");
				return;
			}
		}
		stus[numAdd].setNum(inNum);
		stus[numAdd].setName(inName);
		stus[numAdd].setAge(inAge);
		stus[numAdd].setSex(inSex);
		stus[numAdd].setPwd(inPwd);
		// 将所有添加的信息预览一遍
		sop("【添加成功，您添加的内容为】："+"\n学号："+stus[numAdd].getNum()+"\n姓名："+stus[numAdd].getName()+"\n年龄："+stus[numAdd].getAge()
				+"\n性别："+stus[numAdd].getSex()+"\n密码："+stus[numAdd].getPwd());
	}
	
	//查询全部
	public void queryAll() {
		sop("+++++++++++++++【查询所有】+++++++++++++++");
		int flag1 =0; // 定义变量保存所获得的信息量
		for(int i = 0; i < stus.length-1;i++) {
			if(stus[i]!=null) {
				sop("【第"+(i+1)+"条数据】："+"\n学号："+stus[i].getNum()+"\n姓名："+stus[i].getName()+"\n年龄："+stus[i].getAge()
						+"\n性别："+stus[i].getSex()+"\n密码："+stus[i].getPwd());
				flag1++;
			}
		}
		sop("【查询完毕，共"+flag1+"条信息】"); // 提示查询的信息量
	}
	
	//按学号查询
	public int queryForNum() { //返回值用来返回查询的结果如何
		System.out.println("+++++++++++++++【请输入要查询/修改/删除信息的学号及姓名】+++++++++++++++");
		Scanner in = new Scanner(System.in);
		int flag2 =0;
		sop("【要查询的学号】：");
		int inQuNum = in.nextInt();
		sop("【要查询的姓名】：");
		String inQuName = in.next();
		for(int i = 0;i <stus.length;i++) {
			if(stus[i]==null){ // 如果第一个位置就为空，则表示在系统中不存在任何数据，直接返回主界面
				sop("【查询失败,无此人信息】");
				flag2 = -1; // 无数据
				return flag2; //直接结束方法,返回结果
			}else if(inQuNum == stus[i].getNum() && inQuName.equals(stus[i].getName())) { // 为了更精确找到学号和姓名都相符合的则查询到此人信息
				sop("【查询成功，查询结果如下】："+"\n学号："+stus[i].getNum()+"\n姓名："+stus[i].getName()+"\n年龄："+stus[i].getAge()
						+"\n性别："+stus[i].getSex()+"\n密码："+stus[i].getPwd());
				flag2 = i; // 查询成功返回相应的信息的角标位置
				return flag2;
			}else{ 
				flag2 = -1; // 不存在此条数据
			}
		}
		if(flag2 == -1){// 如果有数据但是输入中无与数据中相符合的则查询失败
			sop("【查询失败，无此人信息】");
		}
		return flag2; // 必须在方法内给出一个返回值，但是在查询后都不会返回此值，保证方法不报错
	}
	
	//修改
	public void update() {
		sop("+++++++++++++++【修改】+++++++++++++++");
		int queryResult = queryForNum(); // 获取查询得到的结果
		Scanner in = new Scanner(System.in);
		if(queryResult == -1) { // 结果为-1，表示系统无数据或无此人信息
			sop("【请在添加或查证后再修改，谢谢】");
		}else{ // 结果为其他，则查询到相关内容
			sop("【是否修改以上信息？(0/否,1/是)】"); // 防止用户误操作
			int updateElect = in.nextInt();
			switch(updateElect) {
				case 0:
					sop("【以上信息未做任何修改】");
					break;
				case 1:
					sop("【请输入修改内容】");
					sop("学号：");
					int inNum = in.nextInt();
					sop("姓名：");
					String inName = in.next();
					sop("年龄：");
					int inAge = in.nextInt();
					sop("性别：");
					String inSex = in.next();
					sop("密码：");
					String inPwd = in.next();
					for(int i = 0;i<stus.length;i++) {
						// 如果修改输入的内容学号不为查询到信息的学号，且在数据中存在此学号，则修改失败
						if(stus[i] != null && inNum != stus[queryResult].getNum() && inNum ==stus[i].getNum()){
							sop("【修改失败，学号"+inNum+"已存在，请重新修改】");
							return; // 结束回到主界面
						}
					}
					// 满足学号唯一才能修改
					stus[queryResult].setNum(inNum);
					stus[queryResult].setName(inName);
					stus[queryResult].setAge(inAge);
					stus[queryResult].setSex(inSex);
					stus[queryResult].setPwd(inPwd);
					// 将所有修改的信息预览一遍
					sop("【修改完毕，您修改后的内容为】："+"\n学号："+stus[queryResult].getNum()+"\n姓名："+stus[queryResult].getName()+"\n年龄："+stus[queryResult].getAge()
							+"\n性别："+stus[queryResult].getSex()+"\n密码："+stus[queryResult].getPwd());
					break;
			}
		}
	}
	
	//删除
	public void delete() {
		System.out.println("+++++++++++++++【删除】+++++++++++++++");
		int queryResult = queryForNum(); // 获取查询得到的结果
		Scanner in = new Scanner(System.in);
		if(queryResult == -1) { // 结果为-1，表示系统无数据或无此人信息
			sop("【请在添加或查证信息后再删除，谢谢】");
		}else{ // 结果为其他，则查询到相关内容
			sop("【是否删除以上信息？(0/否,1/是)】"); // 防止用户误操作
			int deleteElect = in.nextInt();
			switch(deleteElect) {
			case 0:
				sop("【数据未做任何操作】");
				break;
			case 1:
				// 删除操作将查询到的信息所有的清空
				stus[deleteElect] = null;
				sop("【此条信息删除成功】");
				break;
			}
		}
	}
	//打印语句
	public void sop(Object o) { // Object接受任何对象
		System.out.println(o);
	}
}
