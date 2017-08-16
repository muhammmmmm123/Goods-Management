/**
 * 供应商类
 */

package com.njupt.mis.model;

public class Provider extends Person
{

	public Provider()
	{
		super();
	}

	public Provider(String id, String providerName, String zip, String address,
			String telephone, String connectionPerson,
			String phone, String bank, String account, String email, String fax)
	{
		super(id, providerName, zip, address, telephone, connectionPerson, phone,
				 bank, account,email, fax);
	}

	public Provider(String id, String name, String zip, String address,
			String telephone, String connectionPerson,
			String phone, String bank, String account, String email, String fax,
			int available)
	{
		super(id, name, zip, address, telephone,  connectionPerson, phone, 
				bank, account, email,fax,available);
		// TODO Auto-generated constructor stub
	}

}
