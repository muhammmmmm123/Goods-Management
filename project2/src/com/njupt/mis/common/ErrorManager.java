/**
 * ��������
 */
package com.njupt.mis.common;

public abstract class ErrorManager
{
	/**
	 * ���������Ϣ
	 * @param name ʹ�ø÷���������+������
	 * @param e �������
	 */
	public static void printError(String name,Exception e)
	{
		System.out.println(name+" Error!"+e.getMessage());
		e.printStackTrace();
	}
}
