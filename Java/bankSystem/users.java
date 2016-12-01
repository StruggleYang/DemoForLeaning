package com.chinaBank;

import java.util.Scanner;

public class users {
	private String usersName ;
	private String usersPwd ;
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
		for(int i = 3;i >=1;i--) {
			System.out.println("【请输入用户名】：");
			String inName = in.next();
			System.out.println("【请输入密码】：");
			String inPwd = in.next();
			if(inName.equals(this.usersName) && inPwd.equals(this.usersPwd)){
				System.out.println("-----【登录成功】-----");
				break;
			}else if(this.usersName==null && this.usersPwd==null) {
				System.out.println("【还未注册用户,请注册】");
				break;
			}
			else{
				System.out.println("-----【登录失败，还有"+(i-1)+"次登录次数"+"】-----");
			}
		}
	} 
	//注册
	public void reigst() {
		System.out.println("******【注册】******");
		Scanner in = new Scanner(System.in);
		System.out.println("【请输入注册用户名】：");
		this.usersName = in.next();
		System.out.println("【请输入注册密码】：");
		this.usersPwd = in.next();
		System.out.println("-----【注册成功，输入1登录】-----");
	}
}
