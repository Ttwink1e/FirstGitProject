package com.lxy.prepare;

import java.util.Scanner;

public class List {
	private String[] pname = new String[5];	//用户名
	private String[] dish = new String[]{"鱼香肉丝","宫保鸡丁","地三鲜","大盘鸡","兰州拉面"};		//商品名字
	private String[] address = new String[5];	//收货地址
	private int[] time = new int[5];		//收货时间
	private int[] num = new int[5];				//商品数量
	private double[] dishPrice = new double[]{38,27,20,35,12};		//商品价格
	private int[] praise = new int[5];//点赞数量
	private int[] states = new int[5];		//订单状态0(预定)/1(送达)
	private double[] sumPrice = new double[5];		//订单总价格
	private String[] dish_dc = new String[5];	//订单商品
	Scanner input = new Scanner(System.in);
	
	
	//get set方法：
	public String[] getPname() {
		return pname;
	}
	public void setPname(String[] pname) {
		this.pname = pname;
	}
	public String[] getDish() {
		return dish;
	}
	public void setDish(String[] dish) {
		this.dish = dish;
	}
	public String[] getAddress() {
		return address;
	}
	public void setAddress(String[] address) {
		this.address = address;
	}
	public int[] getTime() {
		return time;
	}
	public void setTime(int[] time) {
		this.time = time;
	}
	public int[] getNum() {
		return num;
	}
	public void setNum(int[] num) {
		this.num = num;
	}
	public double[] getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(double[] dishPrice) {
		this.dishPrice = dishPrice;
	}
	public int[] getPraise() {
		return praise;
	}
	public void setPraise(int[] praise) {
		this.praise = praise;
	}
	public int[] getStates() {
		return states;
	}
	public void setStates(int[] states) {
		this.states = states;
	}
	public double[] getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double[] sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String[] getDish_dc() {
		return dish_dc;
	}
	public void setDish_dc(String[] dish_dc) {
		this.dish_dc = dish_dc;
	}
	
	//主页面
	public void index_printf(){
		Scanner input = new Scanner(System.in);
		System.out.println("\t******************************************");
		System.out.println("\t*            欢迎使用快吃订餐系统                                 *");
		System.out.println("\t*1.我要订餐                                                                                 *");
		System.out.println("\t*2.查看餐袋                                                                                 *");
		System.out.println("\t*3.签收订单                                                                                 *");
		System.out.println("\t*4.删除订单                                                                                 *");
		System.out.println("\t*5.我要点赞                                                                                 *");
		System.out.println("\t*6.退出系统                                                                                 *");
		System.out.println("\t******************************************");
		System.out.println("\n\n");
		System.out.println("******************************************");
		System.out.println("请选择：");
		
		//分支选择
		int i =input.nextInt();
		switch (i) {
		case 1:
			dc_printf();
			break;
		case 2:
			ck_printf();
			break;
		case 3:
			qs_printf();
			break;
		case 4:
			sc_printf();
			break;
		case 5:
			dz_printf();
			break;
		case 6:
			System.out.println("谢谢使用欢迎下次光临");
			break;
		default:
			break;
		}
	}
	
	//选择1，订餐界面
	public void dc_printf(){
		System.out.println("*****我要定餐*****");
		System.out.print("请输入订餐人姓名：");
		String pnameInput = input.next();	
		System.out.println("序号\t菜名\t单价\t点赞数");
		for(int k =0;k<5;k++){
			System.out.println((k+1)+"\t"+dish[k]+"\t"+dishPrice[k]+"\t"+praise[k]);
			
		}
		System.out.print("请选择您要点的菜品编号1-5：");
		int noDish = input.nextInt();
		while(noDish < 1||noDish > 5){
			System.out.println("输入的菜品不存在！");
			System.out.print("请重新选择您要点的菜品编号1-5：");
			noDish = input.nextInt();
		}
		System.out.print("请选择您需要的份数(最多10份)：");
		int numInput = input.nextInt();
		while(numInput < 1||numInput>10){
			System.out.println("输入的份数有误！");
			System.out.print("请重新选择您需要的份数(最多10份)：");
			numInput = input.nextInt();
		}
		System.out.print("请输入送餐时间(送餐时间是10点到20点间整点配送)：");
		int timeInput = input.nextInt();
		while(timeInput < 10||timeInput>20){
			System.out.println("输入的配送时间有误！");
			System.out.print("请重新选择您需要的份数(最多10份)：");
			timeInput = input.nextInt();
		}
		System.out.print("请输入送餐地址:");
		String addressInput = input.next();
		double psPrice = 0;
		double sumPriceInput = dishPrice[noDish-1]*numInput;
		if(sumPriceInput < 50&&sumPriceInput > 0){
			psPrice =5;
		}	
		System.out.println("订餐成功！");
		System.out.println("您订的是："+dish[noDish-1]+"\t"+numInput+"份");
		System.out.println("送餐时间："+timeInput);
		System.out.println("餐费："+sumPriceInput+"元,送餐费"+psPrice+"元，总计："
				+(sumPriceInput+psPrice)+"元");
		
		//增加数据
		for(int b=0;b<pname.length;b++){
			if(pname[b]==null){
				pname[b] = pnameInput;
				dish_dc[b] = dish[noDish-1];
				num[b] = numInput;
				address[b] = addressInput;
				time[b] = timeInput;
				sumPrice[b] = sumPriceInput+psPrice;
				states[b] = 0;
				break;
			}
		}
		back();
	}
	
	//选择2，查看餐袋界面
	public void ck_printf(){
		System.out.println("*****查看餐袋*****");
		for(int i=0;i<pname.length;i++){
			if(pname[i]!=null){
				System.out.println("序号\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t总金额\t订单状态");
				System.out.print((i+1)+"\t"+pname[i]+"\t"+dish_dc[i]+"\t"+num[i]+"份\t"
						+time[i]+"\t"+address[i]+"\t"+sumPrice[i]+"\t");
				if(states[i]==0){
					System.out.println("已预订");
				}else{
					System.out.println("已完成");
				}
			}
		}
		back();
	}
	
	//选择3，签收订单界面
	public void qs_printf(){
		System.out.println("*****签收订单*****");
		System.out.println("请输入要签收的订单号：");
		int m = input.nextInt();
		boolean flag = false;
		for(int k = 0;k < pname.length;k++){
			if(pname[k] != null&&states[k] == 0&&(k+1) == m){
				states[k]=1;
				System.out.println("订单签收成功！");
				flag = true;
				break;
			}else if(pname[k] != null&&states[k] == 1&&(k+1) == m){
				System.out.println("订单已签收，请不要重复签收！");
				flag = true;
				break;
			}
			
		}
		if(flag==false){
			System.out.println("查找的订单不存在!");
		}
		back();
	}
	
	//选择4，删除订单界面
	public void sc_printf(){
		System.out.println("*****删除订单*****");
		System.out.println("请输入要删除的订单号：");
		int m = input.nextInt();
		boolean flag = false;

		for(int k = 0;k < pname.length;k++){
			if(pname[k] != null&&k==(m-1)&&states[k] == 1){
				for(int b = k;b < pname.length-1;b++){
					pname[b] = pname[b+1];
					dish_dc[b] = dish[b+1];
					num[b] = num[b+1];
					address[b] = address[b+1];
					time[b] = time[b+1];
					sumPrice[b] = sumPrice[b+1];
					states[b] = 0;
					if(b == pname.length-2){
						System.out.println("订单删除成功！");
					}
					
					flag = true;
					
				}
			}else if(pname[k] != null&&k==(m-1)&&states[k] == 0){
				System.out.println("订单还没有签收，无法删除！");
				flag = true;
			}
			if(flag == true){
				
				break;
			}	
		}
		if(flag == false){
			System.out.println("没有要删除的订单!");
		}
		back();
	}

	//选择5，点赞界面
	public void dz_printf(){
		System.out.println("*****我要点赞*****");
		//输出已点订单的信息
		for(int i=0;i<pname.length;i++){
			if(pname[i]!=null){
				System.out.println("序号\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t总金额\t订单状态");
				System.out.print((i+1)+"\t"+pname[i]+"\t"+dish_dc[i]+"\t"+num[i]+"份\t"
						+time[i]+"\t"+address[i]+"\t"+sumPrice[i]+"\t");
				if(states[i]==0){
					System.out.println("已预订");
				}else{
					System.out.println("已完成");
				}
			}
		}
		
		
//		System.out.println("序号\t菜名\t单价\t点赞数");
//		for(int k =0;k<5;k++){
//			System.out.println((k+1)+"\t"+dish[k]+"\t"+dishPrice[k]+"\t"+praise[k]);
//			
//		}
		System.out.println("请输入要点赞的订单号：");
		int m = input.nextInt();
		boolean flag = false;
		for(int i=0;i < pname.length;i++){
			if(pname[i] != null&&states[i] == 1&&i == (m-1)){
				for(int j = 0;j < pname.length;j++){
					if(dish_dc[i].equals(dish[j])){
						praise[j]++;
						System.out.println("订单点赞成功！");
						flag = true;
						break;
					}
				}
				if(flag == true)	break;
			}else if(pname[i] != null&&states[i] == 0&&i == (m-1)){
				System.out.println("还没有签收订单，无法进行点赞！");
				flag = true;
				break;
			}
		}
		if(flag == false){
			System.out.println("查找的订单不存在！");
		}
		System.out.println("序号\t菜名\t单价\t点赞数");
		for(int k =0;k<5;k++){
			System.out.println((k+1)+"\t"+dish[k]+"\t"+dishPrice[k]+"\t"+praise[k]);
			
		}
		back();
	}

	//返回主界面
	public void back(){
//		Scanner input = new Scanner(System.in);
		int i=1;
		while(i!=0){
			System.out.println("输入0返回：");
			i = input.nextInt();
			if(i!=0)	System.out.println("输入有误！");
		}
		if(i == 0){
			index_printf();
		}
	}
	
	
	
}
