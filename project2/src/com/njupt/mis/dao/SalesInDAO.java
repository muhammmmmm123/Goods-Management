/**
 * ���۽�����DAO
 */
package com.njupt.mis.dao;

import java.sql.ResultSet;
import java.util.Vector;

import com.njupt.mis.common.Constants;
import com.njupt.mis.common.ErrorManager;
import com.njupt.mis.model.SalesIn;

public class SalesInDAO extends ManagerDAO
{

	public SalesInDAO()
	{
		super();
	}
	/**
	 * �����ݿ��������µ����ۼ�¼
	 * @param salesIn ��װ�õ�SalesIn����
	 * @return ִ�н��
	 */
	public boolean addSalesIn(SalesIn salesIn)
	{
		boolean result=false;
		try
		{
			String sql="insert into tb_sales(id,customerid,paytype,salestime,operateperson,number,price,comment,goodsid) values(?,?,?,?,?,?,?,?,?)";
			Object[] params=new Object[]{salesIn.getId(),salesIn.getCustomerId(),salesIn.getPayType(),
					                   salesIn.getTime(),salesIn.getOperatePerson(),salesIn.getNumber(),
					                   salesIn.getPrice(),salesIn.getComment(),salesIn.getGoodsId()};
			result=super.add(sql, params);
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesInDAO.addSalesIn", e);
		}
		return result;
	}
	/**
	 * ��ȡ���е�������Ϣ
	 * @return ������Ϣ����
	 */
	public Vector<SalesIn> getAllSalesIn()
	{
        Vector<SalesIn> result=new Vector<SalesIn>();
		try
		{
			String sql="{call pr_getAllSalesIn()}";
			ResultSet rs=manager.executeQuery(sql, null, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesIn salesIn=new SalesIn(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
											rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
											rs.getString("salestime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesIn);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesInDAO.getAllSalesIn", e);
		}
		return result;
	}
	/**
	 * ��ѯ���ݿ����������������ۼ�¼
	 * @param field ��ѯ���ֶ�
	 * @param value �����ֵ
	 * @return ��ѯ���
	 */
	public Vector<SalesIn> searchSalesIn(String field,String value)
	{
		Vector<SalesIn> result=new Vector<SalesIn>();
		try
		{
			String sql="{call pr_searchSalesIn(?,?)}";
			Object[] params=new Object[]{field,value};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesIn salesIn=new SalesIn(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("salestime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesIn);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesInDAO.searchPortIn", e);
		}
		return result;
	}
	/**
	 * ��ѯ���ݿ����������������ۼ�¼
	 * @param beginTime ��ѯ�Ŀ�ʼʱ��
	 * @param endTime  ��ѯ�Ľ���ʱ��
	 * @return ��ѯ�����
	 */
	public Vector<SalesIn> searchPortInByTime(String beginTime,String endTime)
	{
		Vector<SalesIn> result=new Vector<SalesIn>();
		try
		{
			String sql="{call pr_searchThroughTime(?,?,?,?)}";
			Object[] params=new Object[]{"tb_sales","salestime",beginTime,endTime};
			ResultSet rs=manager.executeQuery(sql, params, Constants.CALL_TYPE);
			while(rs.next())
			{
				SalesIn salesIn=new SalesIn(rs.getString("id"),rs.getString("customerid"),rs.getString("goodsid"),
									  rs.getString("paytype"),rs.getInt("number"),rs.getDouble("price"),
									  rs.getString("salestime"),rs.getString("operateperson"),rs.getString("comment"));
				result.add(salesIn);
			}
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesInDAO.searchPortIn", e);
		}
		return result;
	}
	/**
	 * �ж����۱���Ƿ����
	 * @param id 
	 * @return
	 */
	public boolean isExited(String id)
	{
		return super.isExited("tb_sales", id);
	}
	
	public boolean CheckSto(String id ,int number)
	{
		boolean result=false;
		try{
			String sql="select * from tb_storagecheck where goodsid = ?";
			Object[] params=new Object[]{id};
			ResultSet rs=manager.executeQuery(sql,params,Constants.CALL_TYPE);
			if(rs.next())
		    {
				if(Integer.parseInt(rs.getString("number"))<number)
					result=false;
				else
					result=true;
		    }
			manager.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("SalesInDAO.searchPortIn", e);
		}
		return result;
	}
}