package com.database;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import com.pogo.ProductInfo;

@Repository
public class ProductInfoDatabase {
		
		ProductInfo p = new ProductInfo();
		
		private static SessionFactory sf = getSessionFactory();

		private static SessionFactory  getSessionFactory() {

			if(sf==null) {

				Configuration con = new Configuration().configure();

				ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

				sf = con.buildSessionFactory(reg);
			}

			return sf;
		}	
		
		public ArrayList<ProductInfo> getAllProducts (){
			
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			

			Criteria c = session.createCriteria(ProductInfo.class);
			ArrayList<ProductInfo> products= (ArrayList<ProductInfo>) c.list();

			session.flush();
			session.close();
			
			return products;
		}
	
}
