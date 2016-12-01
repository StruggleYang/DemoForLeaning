package com.chinaBank;

import java.util.Scanner;

public class users {
	static String [] name = new String [100]; // 定义数组来存储用户
	static String [] pwd = new String [100]; // 定义数组来存储密码
	static int userMoney = 1000;
	//系统主界面提示
	public void Tishi() {
		System.out.println("---------欢迎来到Bank系统------------"+"\n"
				+"----------------1.登录---------------\n"
				+"----------------2.注册---------------\n"
				+"----------------3.查询---------------\n"
				+"----------------4.取款---------------\n"
				+"----------------5.退出---------------\n");
	}
	//登录
	public void loginUser() {
		System.out.println("******【登录】******");
		Scanner in = new Scanner(System.in);
		
		for(int i = 3;i >=1;i--) { // 只能登陆三次
			System.out.println("【请输入用户名】：");
			String inName = in.next();
			System.out.println("【请输入密码】：");
			String inPwd = in.next();
			int x =0; 
			for(int y = 0;y <= name.length-1;y++) { // 遍历数组，查看是否在数组中存在和输入相符合的用户名和密码
				if(inName.equals(name[y]) && inPwd.equals(pwd[y])){
					System.out.println("-----【登录成功】-----");
					return;
				}
				x=y;
			}
			if (!inName.equals(name[x]) || !inPwd.equals(pwd[x])) { //如果最终都没有找到相同的，则登陆失败
				System.out.println("-----【登录失败，还有"+(i-1)+"次登录次数】-------");
			}
		}
	} 
	//注册
	public void reigst() {
		System.out.println("******【注册】******");
		Scanner in = new Scanner(System.in);
		System.out.println("【请输入注册用户名】：");
		int  num = 0;
		for (int add = 0;add <=name.length-1;add++) { 
			if(name[add]!=null) { // 判断数组从0开始的角标是否有数据，如果有数据则查找下一个，直到找到为空的位置
				num++;
			}
			else{
				break;
			}
		}
		name[num] = in.next();
		System.out.println("【请输入注册密码】：");
		pwd[num] = in.next();
		userMoney = 1000; //将金额设置为1000
		System.out.println("-----【注册成功,已为你存入1000元额度，输入1登录】-----");
	}
}
