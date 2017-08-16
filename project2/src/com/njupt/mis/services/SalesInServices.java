/**
 * 销售服务类
 */
package com.njupt.mis.services;

import java.util.Vector;

import com.njupt.mis.dao.PortInDAO;
import com.njupt.mis.dao.SalesInDAO;
import com.njupt.mis.handler.SalesInServicesHandler;
import com.njupt.mis.model.SalesIn;

public class SalesInServices implements SalesInServicesHandler
{
    SalesInDAO salesInDAO=null;
	public SalesInServices()
	{
		super();
	}
	
	public boolean addSalesIn(SalesIn salesIn)
	{
		salesInDAO=new SalesInDAO();
		boolean result=true;
		result=salesInDAO.addSalesIn(salesIn);
		//修改库存量
		GoodsServices goodsServices=new GoodsServices();
		goodsServices.changeGoodsNumber(salesIn.getGoodsId(), -salesIn.getNumber());
		return  result;
	}
	
	public Vector<SalesIn> getAllSalesIn()
	{
		salesInDAO=new SalesInDAO();
		return salesInDAO.getAllSalesIn();
	}
	
	public Vector<SalesIn> searchSalesIn(String field, String value)
	{
		salesInDAO=new SalesInDAO();
		return salesInDAO.searchSalesIn(field, value);
	}
	
	public Vector<SalesIn> searchPortInByTime(String beginTime,String endTime)
	{
		salesInDAO=new SalesInDAO();
		return salesInDAO.searchPortInByTime(beginTime, endTime);
	}
	
	public boolean isExited(String id)
	{
		salesInDAO=new SalesInDAO();
		return salesInDAO.isExited(id);
	}
	
	public boolean CheckSto(String id,int number)
	{
		salesInDAO=new SalesInDAO();
		return salesInDAO.CheckSto(id,number);
	}
}
