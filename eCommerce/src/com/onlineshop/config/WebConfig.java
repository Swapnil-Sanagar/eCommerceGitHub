package com.onlineshop.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.onlineshop.pojo.Address;
import com.onlineshop.pojo.Cart;
import com.onlineshop.pojo.Category;
import com.onlineshop.pojo.Order;
import com.onlineshop.pojo.OrderDetails;
import com.onlineshop.pojo.Payment;
import com.onlineshop.pojo.Product;
import com.onlineshop.pojo.ShippingAddress;
import com.onlineshop.pojo.User;
import com.onlineshop.pojo.UserRole;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.onlineshop")
@EnableTransactionManagement
@Import({ SecurityConfiguration.class })
public class WebConfig extends WebMvcConfigurerAdapter {
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("jsp/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Bean
	public MessageSource setupMessageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasenames("validation");
		return bundleMessageSource;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/");
	}

	@Bean
	public View jsonTemplate() {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		return view;
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/online_shopping");
		dataSource.setUsername("root");
		dataSource.setPassword("sw@pnil1989");
		return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory() {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(
				getDataSource());

		sessionBuilder.addAnnotatedClasses(Product.class,Category.class,User.class,Address.class,UserRole.class,Cart.class,ShippingAddress.class,Order.class,OrderDetails.class,Payment.class);
		sessionBuilder.addProperties(getHibernateProperties());
		return sessionBuilder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    return properties;
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	 
	    return transactionManager;
	}
	
	/*@Autowired
	@Bean(name = "productDao")
	public ProductDAO getProductDao(SessionFactory sessionFactory) {
	    return new ProductDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "categoryDao")
	public CategoryDAO getCategoryDao(SessionFactory sessionFactory) {
	    return new CategoryDAOImpl(sessionFactory);
	}*/
}
