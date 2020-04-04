package com.qintess.hibernate.generics;

import com.qintess.hibernate.generics.modelo.Produto;
import com.qintess.hibernate.generics.modelo.ItemVenda;
import com.qintess.hibernate.generics.modelo.Venda;
	
	

	import java.util.Properties;

	import org.hibernate.SessionFactory;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.cfg.Environment;
	import org.hibernate.service.ServiceRegistry;




	public class HibernateConfig {
		
		//responsável por fazer a sessão com o hibernate
		//fazer toda a parte de configuração
		private static SessionFactory sessionFactory;
		
		//método
		public static SessionFactory getSessionFactory() {
			
			if(sessionFactory == null) {
				
				try {
					
					Configuration configuration = new Configuration ();
					
					//funciona como hash map, chaves e valores
					Properties  prop = new Properties();
					
					//configuração de conexão ao banco de dadoa
					prop.put(Environment.DRIVER,"org.h2.Driver");
					prop.put(Environment.URL, "jdbc:h2:~/db~bd_hibernate");
					prop.put(Environment.USER, "sa");
					prop.put(Environment.PASS, "");
					prop.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");// o DIALECT, passa particulares no sql
					
					//mostra as execuções de sql no console
					prop.put(Environment.SHOW_SQL,"true");
					
					//a cada vez que for criado uma banco sera criado e dropado, usado em ambiente de teste
					prop.put(Environment.HBM2DDL_AUTO,"update");
					
					//pegar as propriedades e coloca nas configurações
					configuration.setProperties(prop);
					
					//parte chata
					//esse addAnnotatedClass vai  ser cada uma das entidades queexiste no banco de dados
					//vai ter que passar todas as entidades pra mapear no java
					//passa a classe anotada - todas as condigurações ser
					configuration.addAnnotatedClass(Produto.class);
					configuration.addAnnotatedClass(Venda.class);
					configuration.addAnnotatedClass(ItemVenda.class);
					
					//registro do serviço do hibernate
					ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
														.applySettings(configuration.getProperties())
														.build();
					
					sessionFactory = configuration.buildSessionFactory(serviceRegistry);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return sessionFactory;
			
		}

	


}
