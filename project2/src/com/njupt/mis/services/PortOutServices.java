/**
 * 退货服务类
 */
package com.njupt.mis.services;

import java.util.Vector;

import com.njupt.mis.dao.PortOutDAO;
import com.njupt.mis.handler.PortOutServicesHandle;
import com.njupt.mis.model.PortOut;

public class PortOutServices implements PortOutServicesHandle
{
    PortOutDAO portOutDAO=null;
    
	public PortOutServices()
	{
		super();
	}

	
	public boolean addPortOut(PortOut portOut)
	{
		portOutDAO=new PortOutDAO();
		boolean result=true;
		result=portOutDAO.addPortOut(portOut);;
		//修改库存量
		GoodsServices goodsServices=new GoodsServices();
		goodsServices.changeGoodsNumber(portOut.getGoodsId(), -portOut.getNumber());
		return result;
	}

	
	public Vector<PortOut> getAllPortOut()
	{
		portOutDAO=new PortOutDAO();
		return portOutDAO.getAllPortOut();
	}

	
	public Vector<PortOut> searchPortOut(String field, String value)
	{
		portOutDAO=new PortOutDAO();
		return portOutDAO.searchPortOut(field, value);
	}

	
	public Vector<PortOut> searchPortInByTime(String beginTime,String endTime)
	{
		portOutDAO=new PortOutDAO();
		return portOutDAO.searchPortInByTime(beginTime, endTime);
	}

	
	public boolean isExited(String id)
	{
		portOutDAO=new PortOutDAO();
		return portOutDAO.isExited(id);
	}
	
	
	public boolean CheckSto(String id,int number)
	{
		portOutDAO=new PortOutDAO();
		return portOutDAO.CheckSto(id,number);
	}

}
