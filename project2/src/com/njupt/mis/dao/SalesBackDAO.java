/**
 * �����˻���DAO
 */
package com.njupt.mis.dao;

import java.sql.ResultSet;
import java.util.Vector;

import com.njupt.mis.common.Constants;
import com.njupt.mis.common.ErrorManager;
import com.njupt.mis.model.SalesBack;

public class SalesBackDAO extends ManagerDAO
{

	public SalesBackDAO()
	{
		super();
	}
	
	/**
	 * �����ݿ��������µ��˻���¼
	 * @param SalesBack ��װ�õ�SalesIn����
	 * @return ִ�н��
	 */
	public boolean addSalesBack(SalesBack salesBack)
	{
		boolean result=false;
		try
		{
			String sql="insert into tb_salesback(id,customerid,paytype,salesbacktime,operateperson,number,price,comment,goodsid) values(?,?,?,?,?,?,?,?,?)";
			Object[] params=new Object[]{salesBack.getId(),salesBack.getCustomerId(),salesBack.getPayType(),
										 salesBack.getTime(),salesBack.getOperatePerson(),salesBack.getNumber(),
										 salesBack.getPrice(),salesBack.getComment(),salesBack.getGoodsId()};
			result=super.add(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesBackDAO.addSalesBack", e);
		}
		return result;
	}
	/**
	 * ��ѯ���ݿ������������������˻���¼
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	public Vector<SalesBack> searchSalesBack(String field,String value)
	{
		Vector<SalesBack> result=new Vector<SalesBack>();
		try
		{
			String sql="{call pr_searchSalesBack(?,?)}";
			Object[] params=new Object[]{field,value};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesBack salesBack=new SalesBack(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("salesbacktime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesBack);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesBackDAO.searchSalesBack", e);
		}
		return result;
	}
	/**
	 * ��ѯ���ݿ������������������˻���¼
	 * @param beginTime ��ѯ�Ŀ�ʼʱ��
	 * @param endTime  ��ѯ�Ľ���ʱ��
	 * @return ��ѯ���
	 */
	public Vector<SalesBack> searchSalesBackByTime(String beginTime,String endTime)
	{
		Vector<SalesBack> result=new Vector<SalesBack>();
		try
		{
			String sql="{call pr_searchThroughTime(?,?,?,?)}";
			Object[] params=new Object[]{"tb_salesback","salesbacktime",beginTime,endTime};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesBack salesBack=new SalesBack(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("salesbacktime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesBack);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesBackDAO.searchSalesBack", e);
		}
		return result;
	}
	/**
	 * ��ȡ���е������˻���Ϣ
	 * @return �����˻���Ϣ����
	 */
	public Vector<SalesBack> getAllSalesBack()
	{
        Vector<SalesBack> result=new Vector<SalesBack>();
		try
		{
			String sql="{call pr_getAllSalesBack()}";
			ResultSet rs=manager.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesBack salesBack=new SalesBack(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
											rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
											rs.getString("salesbacktime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesBack);
			}
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesBackDAO.getAllSalesBack", e);
		}
		return result;
	}
	/**
	 * �ж������˻ر���Ƿ����
	 * @param id 
	 * @return
	 */
	public boolean isExited(String id)
	{
		return super.isExited("tb_salesback", id);
	}
	
	public boolean CheckSalesOut(String id,String Cid,int number)
	{
		boolean result=false;
		int outSum=0;
		int sum=0;
		int backSum=0;
		try{
			String sql="select * from tb_sales where goodsid = ? and customerid = ?";
			Object[] params=new Object[]{id,Cid};
			ResultSet rs=manager.executeQuery(sql,params,Constants.CALL_TYPE);
			while(rs.next())
			{
				outSum+=Integer.parseInt(rs.getString("number"));
			}
			String sql2="select * from tb_salesback where goodsid = ? and customerid = ?";
			ResultSet rs2=manager.executeQuery(sql2,params,Constants.CALL_TYPE);
			while(rs2.next())
			{
				backSum+=Integer.parseInt(rs2.getString("number"));
			}
			sum=outSum-backSum;
		if(sum<number)
			result=false;
		else
			result=true;
		}
		catch (Exception e)
		{
			ErrorManager.printError("PortOutDAO.addPortOut", e);
		}
		return result;
	}

}