package com.njupt.mis;
import javax.swing.JFrame;
import com.njupt.mis.view.LoginFrame;


import java.net.*;  
import java.io.*;  
public class Client {   
    private Socket client;  
    public Client() {  
        try {  
  System.out.println("�������ӷ�����......");  
client = new Socket("192.168.218.168", 8888);    //����  
  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));  
PrintStream out = new PrintStream(client.getOutputStream());;  boolean flag = true;  
   System.out.println("�ɹ����ӵ���������ʼͨѶ����"); 
   JFrame.setDefaultLookAndFeelDecorated(true);//������Σ��ȵ��ø÷����������ɶ��󣬲Ż���Ч��
	@SuppressWarnings("unused")
	LoginFrame loginFrame=new LoginFrame();
	JFrame.setDefaultLookAndFeelDecorated(true);
       while (flag) {  
     System.out.printf("��������Ϣ��");  
     out.println(input.readLine());  //����  
       //�ж��Ƿ��������Ͽ�  
    if (isConnected()) {  
      System.out.println("�����ɹ�����");  
          System.out.println("������" + in.readLine());  
 } else {  
 System.out.println("����ʧ�ܣ���");  
    System.out.println("��������Ͽ����ӣ���");  
     client.close();  
     break;   }  }   }
catch (Exception e) {  
    System.out.println(e.getMessage());  
        }  }  
    //�жϷ������Ƿ�Ͽ��ķ�����  
    //ͨ��OutputStream����һ�β������ݣ��������ʧ�ܾͱ�ʾԶ���Ѿ��Ͽ�����  
    //�����������Ĵ��͸��ţ�������sendUrgenData  
    public boolean isConnected() {  
        try {  
            client.sendUrgentData(0xFF);  
            return true;  
        } 
catch (Exception e) {  
     e.printStackTrace();  
     return false;  
        }  
    } 
    public static void main(String[] args) {  
        new Client();  
    }  }  
