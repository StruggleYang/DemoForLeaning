package com.chinaBank;

import java.util.Scanner;

public class mainInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		users use = new users();// 实例化用户对象
		bank ban = new bank();// 实例化bank对象
		use.Tishi();// 系统提示信息
		
		Scanner input = new Scanner(System.in);// 实例化输入对象
		boolean flag = true;// 定义变量控制系统循环输入，以及控制系统的退出
		// 循环，使系统不至于只输入一次
		while(flag) {
			System.out.println("【请选择业务】：");
			int num = input.nextInt();
			switch(num) {
				case 1:
					use.loginUser();// 调用登录方法
					break;
				case 2:
					use.reigst();// 调用注册方法
					break;
				case 3:
					ban.selectMoney();// 调用查询方法
					break;
				case 4:
					ban.drawMoney();// 调用取钱方法
					break;
				case 5:
					flag = false;
					System.out.println("【系统退出成功，欢迎下次光临】");
					break;
			}
		}
	}
}
