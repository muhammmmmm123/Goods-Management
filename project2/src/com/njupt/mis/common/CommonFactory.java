/**
 * �����࣬��������������Ķ���
 */
package com.njupt.mis.common;

import com.njupt.mis.handler.CustomerServicesHandler;
import com.njupt.mis.handler.GoodsServicesHandler;
import com.njupt.mis.handler.OperatorServicesHandler;
import com.njupt.mis.handler.PortInServicesHandle;
import com.njupt.mis.handler.PortOutServicesHandle;
import com.njupt.mis.handler.ProviderServicesHandler;
import com.njupt.mis.handler.SalesBackServicesHandler;
import com.njupt.mis.handler.SalesInServicesHandler;

public class CommonFactory
{
	/**
	 * ��ȡGoodsService��Ķ���
	 * @return GoodsService��Ķ���
	 */
	public static GoodsServicesHandler getGoodsServices()
	{
		try
		{
			return (GoodsServicesHandler)Class.forName(Constants.GOODS_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getGoodsServices", e);
		}
		return null;
	}
	
	/**
	 * ��ȡCustomerServices��Ķ���
	 * @return CustomerServices��Ķ���
	 */
	public static CustomerServicesHandler getCustomerServices()
	{
		try
		{
			return (CustomerServicesHandler)Class.forName(Constants.CUSTOMER_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getCustomerServices", e);
		}
		return null;
	}
	/**
	 * ��ȡProviderServices��Ķ���
	 * @return ProviderServices��Ķ���
	 */
	public static ProviderServicesHandler getProviderServices()
	{
		try
		{
			return (ProviderServicesHandler)Class.forName(Constants.PROVIDER_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getProviderServices", e);
		}
		return null;
	}
	/**
	 * ��ȡOperatorServices��Ķ���
	 * @return OperatorServices��Ķ���
	 */
	public static OperatorServicesHandler getOperatorServices()
	{
		try
		{
			return (OperatorServicesHandler)Class.forName(Constants.OPERATOR_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getOperatorServices", e);
		}
		return null;
	}
	/**
	 * ��ȡPortInServices��Ķ���
	 * @return PortInServices��Ķ���
	 */
	public static PortInServicesHandle getPortInServices()
	{
		try
		{
			return (PortInServicesHandle)Class.forName(Constants.PORTIN_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.PortInServicesHandle", e);
		}
		return null;
	}
	/**
	 * ��ȡPortOutServices��Ķ���
	 * @return PortOutServices��Ķ���
	 */
	public static PortOutServicesHandle getPortOutServices()
	{
		try
		{
			return (PortOutServicesHandle)Class.forName(Constants.PORTOUT_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getPortOutServices", e);
		}
		return null;
	}
	
	/**
	 * ��ȡSalesBackServices��Ķ���
	 * @return SalesBackServices��Ķ���
	 */
	public static SalesInServicesHandler getSalesInServices()
	{
		try
		{
			return (SalesInServicesHandler)Class.forName(Constants.SALESIN_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.SalesInServicesHandler", e);
		}
		return null;
	}
	/**
	 * ��ȡSalesBackServices��Ķ���
	 * @return SalesBackServices��Ķ���
	 */
	public static SalesBackServicesHandler getSalesBackServices()
	{
		try
		{
			return (SalesBackServicesHandler)Class.forName(Constants.SALESBACK_SERVICES_CLASS).newInstance();
		}
		catch (Exception e)
		{
			ErrorManager.printError("CommontFactory.getSalesBackServices", e);
		}
		return null;
	}
}