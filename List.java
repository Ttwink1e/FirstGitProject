package com.lxy.prepare;

import java.util.Scanner;

public class List {
	private String[] pname = new String[5];	//�û���
	private String[] dish = new String[]{"������˿","��������","������","���̼�","��������"};		//��Ʒ����
	private String[] address = new String[5];	//�ջ���ַ
	private int[] time = new int[5];		//�ջ�ʱ��
	private int[] num = new int[5];				//��Ʒ����
	private double[] dishPrice = new double[]{38,27,20,35,12};		//��Ʒ�۸�
	private int[] praise = new int[5];//��������
	private int[] states = new int[5];		//����״̬0(Ԥ��)/1(�ʹ�)
	private double[] sumPrice = new double[5];		//�����ܼ۸�
	private String[] dish_dc = new String[5];	//������Ʒ
	Scanner input = new Scanner(System.in);
	
	
	//get set������
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
	
	//��ҳ��
	public void index_printf(){
		Scanner input = new Scanner(System.in);
		System.out.println("\t******************************************");
		System.out.println("\t*            ��ӭʹ�ÿ�Զ���ϵͳ                                 *");
		System.out.println("\t*1.��Ҫ����                                                                                 *");
		System.out.println("\t*2.�鿴�ʹ�                                                                                 *");
		System.out.println("\t*3.ǩ�ն���                                                                                 *");
		System.out.println("\t*4.ɾ������                                                                                 *");
		System.out.println("\t*5.��Ҫ����                                                                                 *");
		System.out.println("\t*6.�˳�ϵͳ                                                                                 *");
		System.out.println("\t******************************************");
		System.out.println("\n\n");
		System.out.println("******************************************");
		System.out.println("��ѡ��");
		
		//��֧ѡ��
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
			System.out.println("ллʹ�û�ӭ�´ι���");
			break;
		default:
			break;
		}
	}
	
	//ѡ��1�����ͽ���
	public void dc_printf(){
		System.out.println("*****��Ҫ����*****");
		System.out.print("�����붩����������");
		String pnameInput = input.next();	
		System.out.println("���\t����\t����\t������");
		for(int k =0;k<5;k++){
			System.out.println((k+1)+"\t"+dish[k]+"\t"+dishPrice[k]+"\t"+praise[k]);
			
		}
		System.out.print("��ѡ����Ҫ��Ĳ�Ʒ���1-5��");
		int noDish = input.nextInt();
		while(noDish < 1||noDish > 5){
			System.out.println("����Ĳ�Ʒ�����ڣ�");
			System.out.print("������ѡ����Ҫ��Ĳ�Ʒ���1-5��");
			noDish = input.nextInt();
		}
		System.out.print("��ѡ������Ҫ�ķ���(���10��)��");
		int numInput = input.nextInt();
		while(numInput < 1||numInput>10){
			System.out.println("����ķ�������");
			System.out.print("������ѡ������Ҫ�ķ���(���10��)��");
			numInput = input.nextInt();
		}
		System.out.print("�������Ͳ�ʱ��(�Ͳ�ʱ����10�㵽20�����������)��");
		int timeInput = input.nextInt();
		while(timeInput < 10||timeInput>20){
			System.out.println("���������ʱ������");
			System.out.print("������ѡ������Ҫ�ķ���(���10��)��");
			timeInput = input.nextInt();
		}
		System.out.print("�������Ͳ͵�ַ:");
		String addressInput = input.next();
		double psPrice = 0;
		double sumPriceInput = dishPrice[noDish-1]*numInput;
		if(sumPriceInput < 50&&sumPriceInput > 0){
			psPrice =5;
		}	
		System.out.println("���ͳɹ���");
		System.out.println("�������ǣ�"+dish[noDish-1]+"\t"+numInput+"��");
		System.out.println("�Ͳ�ʱ�䣺"+timeInput);
		System.out.println("�ͷѣ�"+sumPriceInput+"Ԫ,�Ͳͷ�"+psPrice+"Ԫ���ܼƣ�"
				+(sumPriceInput+psPrice)+"Ԫ");
		
		//��������
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
	
	//ѡ��2���鿴�ʹ�����
	public void ck_printf(){
		System.out.println("*****�鿴�ʹ�*****");
		for(int i=0;i<pname.length;i++){
			if(pname[i]!=null){
				System.out.println("���\t������\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
				System.out.print((i+1)+"\t"+pname[i]+"\t"+dish_dc[i]+"\t"+num[i]+"��\t"
						+time[i]+"\t"+address[i]+"\t"+sumPrice[i]+"\t");
				if(states[i]==0){
					System.out.println("��Ԥ��");
				}else{
					System.out.println("�����");
				}
			}
		}
		back();
	}
	
	//ѡ��3��ǩ�ն�������
	public void qs_printf(){
		System.out.println("*****ǩ�ն���*****");
		System.out.println("������Ҫǩ�յĶ����ţ�");
		int m = input.nextInt();
		boolean flag = false;
		for(int k = 0;k < pname.length;k++){
			if(pname[k] != null&&states[k] == 0&&(k+1) == m){
				states[k]=1;
				System.out.println("����ǩ�ճɹ���");
				flag = true;
				break;
			}else if(pname[k] != null&&states[k] == 1&&(k+1) == m){
				System.out.println("������ǩ�գ��벻Ҫ�ظ�ǩ�գ�");
				flag = true;
				break;
			}
			
		}
		if(flag==false){
			System.out.println("���ҵĶ���������!");
		}
		back();
	}
	
	//ѡ��4��ɾ����������
	public void sc_printf(){
		System.out.println("*****ɾ������*****");
		System.out.println("������Ҫɾ���Ķ����ţ�");
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
						System.out.println("����ɾ���ɹ���");
					}
					
					flag = true;
					
				}
			}else if(pname[k] != null&&k==(m-1)&&states[k] == 0){
				System.out.println("������û��ǩ�գ��޷�ɾ����");
				flag = true;
			}
			if(flag == true){
				
				break;
			}	
		}
		if(flag == false){
			System.out.println("û��Ҫɾ���Ķ���!");
		}
		back();
	}

	//ѡ��5�����޽���
	public void dz_printf(){
		System.out.println("*****��Ҫ����*****");
		//����ѵ㶩������Ϣ
		for(int i=0;i<pname.length;i++){
			if(pname[i]!=null){
				System.out.println("���\t������\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
				System.out.print((i+1)+"\t"+pname[i]+"\t"+dish_dc[i]+"\t"+num[i]+"��\t"
						+time[i]+"\t"+address[i]+"\t"+sumPrice[i]+"\t");
				if(states[i]==0){
					System.out.println("��Ԥ��");
				}else{
					System.out.println("�����");
				}
			}
		}
		
		
//		System.out.println("���\t����\t����\t������");
//		for(int k =0;k<5;k++){
//			System.out.println((k+1)+"\t"+dish[k]+"\t"+dishPrice[k]+"\t"+praise[k]);
//			
//		}
		System.out.println("������Ҫ���޵Ķ����ţ�");
		int m = input.nextInt();
		boolean flag = false;
		for(int i=0;i < pname.length;i++){
			if(pname[i] != null&&states[i] == 1&&i == (m-1)){
				for(int j = 0;j < pname.length;j++){
					if(dish_dc[i].equals(dish[j])){
						praise[j]++;
						System.out.println("�������޳ɹ���");
						flag = true;
						break;
					}
				}
				if(flag == true)	break;
			}else if(pname[i] != null&&states[i] == 0&&i == (m-1)){
				System.out.println("��û��ǩ�ն������޷����е��ޣ�");
				flag = true;
				break;
			}
		}
		if(flag == false){
			System.out.println("���ҵĶ��������ڣ�");
		}
		System.out.println("���\t����\t����\t������");
		for(int k =0;k<5;k++){
			System.out.println((k+1)+"\t"+dish[k]+"\t"+dishPrice[k]+"\t"+praise[k]);
			
		}
		back();
	}

	//����������
	public void back(){
//		Scanner input = new Scanner(System.in);
		int i=1;
		while(i!=0){
			System.out.println("����0���أ�");
			i = input.nextInt();
			if(i!=0)	System.out.println("��������");
		}
		if(i == 0){
			index_printf();
		}
	}
	
	
	
}
