package com.niit.shopingcart.dao;

import java.util.List;


import com.niit.shopingcart.model.Supplier;

public interface SupplierDAO {


	public List<Supplier> list();

	public Supplier get(String id);

	public boolean saveOrUpdate(Supplier supplier);

	public void delete(String id);


}
