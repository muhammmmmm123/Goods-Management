package com.njupt.mis;
import javax.swing.JFrame;
import com.njupt.mis.view.LoginFrame;

public class MIS
{
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);//外观修饰，先调用该方法，再生成对象，才会生效。
		@SuppressWarnings("unused")
		LoginFrame loginFrame=new LoginFrame();
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
}