package com.njupt.mis;
import javax.swing.JFrame;
import com.njupt.mis.view.LoginFrame;

public class MIS
{
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);//������Σ��ȵ��ø÷����������ɶ��󣬲Ż���Ч��
		@SuppressWarnings("unused")
		LoginFrame loginFrame=new LoginFrame();
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
}