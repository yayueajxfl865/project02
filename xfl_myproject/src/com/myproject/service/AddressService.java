package com.myproject.service;

import java.util.List;

import com.myproject.dao.AddressDao;
import com.myproject.entity.Address;

public class AddressService {
	
	private AddressDao addressDao=new AddressDao();
	
	public Address getAddressById(String yb_userid)
	{
		return addressDao.getAddressById(yb_userid);
	}
	
	public int addAddress(Address adr) {
		
		return addressDao.addAddress(adr);
	}
	
	public int updateAddress(Address adr) {
		
		return addressDao.updateAddress(adr);
	}
	
	public List<Address> getAddressByybId(String yb_userid){
		
		return addressDao.getAddressByybId(yb_userid);
	}

}
