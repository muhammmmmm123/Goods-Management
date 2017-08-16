package com.njupt.mis.services;

import java.util.Vector;

import com.njupt.mis.common.Constants;
import com.njupt.mis.common.ErrorManager;
import com.njupt.mis.dao.SqlManager;
import com.njupt.mis.handler.StorageGoodsHandler;
import com.njupt.mis.model.Customer;
import com.njupt.mis.model.StorageGoods;

import java.sql.*;

public class StorageGoodsServices implements StorageGoodsHandler
{
	SqlManager manage=null;
	
	public StorageGoodsServices()
	{
		super();
		manage=SqlManager.createInstance();
		manage.connectDB();
	}
	public Vector<StorageGoods> getAllStorageGoods()
	{
		Vector<StorageGoods> result=new Vector<StorageGoods>();
		
   /* 	try
		{
    		
			
			
			
			//String sql="select id from tb_goods ";
			//ResultSet rs=manage.executeQuery(sql, null, Constants.CALL_TYPE);
			String sql2="select * from tb_storagecheck where goodsid="+rs.getString("id");
			ResultSet rs2=manage.executeQuery(sql2, null, Constants.CALL_TYPE);
            rs2.getString("number");
			while(rs.next())
			{
			StorageGoods storage=new StorageGoods(rs.getString("id"),rs.getString(arg0));
				result.add(storage);
			}
			manage.closeDB();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CustomerDAO.getAllCustomer", e);
		}*/
		return result;	
	}
}

