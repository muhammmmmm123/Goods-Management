package com.njupt.mis;
import java.net.*;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JFrame;
import java.util.Vector;

import com.njupt.mis.model.Goods;
import com.njupt.mis.model.StorageGoods;
import com.njupt.mis.common.CommonFactory;
import com.njupt.mis.handler.*;

import com.njupt.mis.model.Goods;
import com.njupt.mis.view.*;
import com.njupt.mis.view.LoginFrame;


public class Server {  
	private ServerSocket server;  
	private Socket client;  
	public Server() {  
		boolean flag = true;  
		try {  
			server = new ServerSocket(8888);    //�˿�  
			System.out.println("���������ڵȵ��ͻ�������......");  
			while (flag) {  
				client = server.accept();   //����  
				new ServerThread(client).start();  }  
			server.close();  
		} catch (Exception e) {  }   }     
	public static void main(String[] args) {  
		new Server(); 
			
		}  
	private class ServerThread extends Thread {  
		private Socket clientThread;  
		private PrintStream out;  
		private BufferedReader in;  
		private boolean flag = true;  
		public ServerThread(Socket client) {  
			this.clientThread = client;  
			System.out.println("������ͻ��˳ɹ��������ӣ���ʼͨѶ����");  
		}  public void run() {  
			try {  
				/* 
				 * ��ʱ�жϣ����ó�ʱʱ��300�룬�ж����ӻ���300���ڿͻ����޻�Ӧ��Ϣ����Ϊ�ж� 
				 * ȱ����Ǳ���ѳ�ʱʱ�����úܳ�������ͻ��˴���Ҳ��Ϊ��ʱ�����޷��ж��Ƿ�˿� 
				 */  
				clientThread.setSoTimeout(300000);  
				out = new PrintStream(client.getOutputStream());  
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));  
				while (flag) {  
					String str = in.readLine(); //����  
					System.out.println("�ͻ��ˣ�" + str);
					
					if(str!=null)
					{      
						  
						
					}
					
					out.println("�����ɹ����յ�������Ϣ����");  
				}  
				client.close();  
			} catch (Exception e) {  
				//����쳣�������쳣����������ӶϿ�  
				if (e.getMessage() == "Connection reset") {  
					System.out.println("�ͻ����ѶϿ����ӣ���");  
				}    }  }  } } 
