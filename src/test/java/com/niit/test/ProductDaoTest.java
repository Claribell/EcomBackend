package com.niit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

public class ProductDaoTest {

	static ProductDao productDao;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext annotationConfigAppContext = new AnnotationConfigApplicationContext();

		annotationConfigAppContext.scan("com.niit.*");
		annotationConfigAppContext.refresh();
		productDao = (ProductDao) annotationConfigAppContext.getBean("productDao");
	}

	@Ignore
	@Test

	public void addProductTest() {
		Product product = new Product();

		product.setProductname("Laptop bag");
		product.setDescription("American Tourister Logix 02 33 L Laptop Backpack(Blue)");
		product.setStock(13);
		product.setPrice(3480);
		product.setManufacturer("American Tourister");
		product.setCode("TRK348A");

		assertTrue("problem in creating productItem", productDao.addProduct(product));
	}

	@Test

	public void deleteTest() {
		Product product = new Product();
		product.setId(7);
		product.setProductname("SlingBag");
		product.setDescription("Caprese Women's Sling Bag (Rose Gold) ");
		product.setStock(12);
		product.setPrice(1800);
		product.setManufacturer("caprese");

		assertTrue("problem in deleting productItem", productDao.delete(product));
	}

}
