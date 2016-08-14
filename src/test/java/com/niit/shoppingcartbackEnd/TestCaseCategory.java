package com.niit.shoppingcartbackEnd;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopingcart.dao.CategoryDAO;
import com.niit.shopingcart.model.Category;

import junit.framework.TestCase;

public class TestCaseCategory extends TestCase {
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	AnnotationConfigApplicationContext context;
	
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
		
		
	}
	@Test
public void categoryListTestCase()
{
List<Category> list = categoryDAO.list();
int rowCount = list.size();
assertEquals("Category List Test Case" , rowCount , 5);


}
	@Test
	public void categoryAddTestCase()
	{
		category.setId("sfsfd");
		category.setName("sdfsdfsdf");
		category.setDescription("werwerwewr");
		boolean flag = categoryDAO.saveOrUpdate(category);
		assertEquals(flag , true);
		
	}
	@Test
public void CategoryGetTestcase()
{
	category = categoryDAO.get("CG001");
	System.out.println(category.getDescription());
	System.out.println(category.getName());
	assertEquals(category.getName(),"reliance");
	
}
}
