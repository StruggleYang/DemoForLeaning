package com.chinaBank;

import java.util.Scanner;

public class bank {
	// 取钱
	public void drawMoney() {
		System.out.println("******【取钱】******");
		Scanner in = new Scanner(System.in);
		System.out.println("【请输入取款金额】：");
		int inMoney = in.nextInt();
		if(inMoney<= users.userMoney) {
			users.userMoney = users.userMoney-inMoney;
			System.out.println("----------【取款"+inMoney+"元成功，余额为："+users.userMoney+"元】----------");
		}else{
			System.out.println("----------【余额不足】----------");
		}
	}
	// 查询余额
	public void selectMoney() {
		System.out.println("******【查询】******");
		System.out.println("【账户余额为】:"+users.userMoney);
	}
}
