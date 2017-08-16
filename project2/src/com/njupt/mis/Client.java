package com.njupt.mis;
import javax.swing.JFrame;
import com.njupt.mis.view.LoginFrame;


import java.net.*;  
import java.io.*;  
public class Client {   
    private Socket client;  
    public Client() {  
        try {  
  System.out.println("正在连接服务器......");  
client = new Socket("192.168.218.168", 8888);    //阻塞  
  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  
 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));  
PrintStream out = new PrintStream(client.getOutputStream());;  boolean flag = true;  
   System.out.println("成功连接到主机，开始通讯！！"); 
   JFrame.setDefaultLookAndFeelDecorated(true);//外观修饰，先调用该方法，再生成对象，才会生效。
	@SuppressWarnings("unused")
	LoginFrame loginFrame=new LoginFrame();
	JFrame.setDefaultLookAndFeelDecorated(true);
       while (flag) {  
     System.out.printf("请输入信息：");  
     out.println(input.readLine());  //阻塞  
       //判断是否与主机断开  
    if (isConnected()) {  
      System.out.println("发生成功！！");  
          System.out.println("主机：" + in.readLine());  
 } else {  
 System.out.println("发生失败！！");  
    System.out.println("与服务器断开连接！！");  
     client.close();  
     break;   }  }   }
catch (Exception e) {  
    System.out.println(e.getMessage());  
        }  }  
    //判断服务器是否断开的方法，  
    //通过OutputStream发送一段测试数据，如果发送失败就表示远端已经断开连接  
    //但会与正常的传送干扰，所以用sendUrgenData  
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
