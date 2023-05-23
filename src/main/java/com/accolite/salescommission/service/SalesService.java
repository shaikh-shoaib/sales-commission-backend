package com.accolite.salescommission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.accolite.salescommission.model.Product;
import com.accolite.salescommission.model.Sales;
import com.accolite.salescommission.model.SalesCommission;
import com.accolite.salescommission.model.Salesman;
import com.accolite.salescommission.popupinfo.ProductInfo;
import com.accolite.salescommission.popupinfo.SalesmanInfo;
import com.accolite.salescommission.repository.SalesRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalesService {
	
	@Autowired
	private SalesRepository salesRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String saveSales(Sales sales) {
		
		Map<Integer, Double> salesmanCommission = new HashMap<>();
		Map<Integer, List<String>> salesmanInfo = new HashMap<>();

		for(Salesman salesman : sales.getSalesman() ) {
			salesmanCommission.put(salesman.getSalesman_id(), salesman.getCommission_rate());
			List<String> temp = new ArrayList<String>();
			temp.add(salesman.getSalesman_area());
			temp.add(salesman.getSalesman_name());
			salesmanInfo.put(salesman.getSalesman_id(), temp);
		}
	
		int id = 1;
		for(Product product : sales.getProducts()) {
			int salesAmount = product.getPrice_per_unit()*product.getQuantity();
			double commission = salesAmount*salesmanCommission.get(product.getSalesman_id())/100;
			String salesmanArea = salesmanInfo.get(product.getSalesman_id()).get(0);
			String salesmanName = salesmanInfo.get(product.getSalesman_id()).get(1);
			SalesCommission salesCommission = new SalesCommission(id,product.getProduct_name(),product.getQuantity(),salesAmount,salesmanName,commission,salesmanArea,LocalDate.now());
	    	salesRepository.save(salesCommission);
	    	id++;
		}
		
		return "sales saved successfully!";
	}
	
	public List<ProductInfo> getProductInfoByName(String name) {
    	String query = "SELECT product_name, salesman_area as area, SUM(product_quantity) as totalQuantity, SUM(sales_amount) as totalSales\r\n"
    			+ "FROM sales_commission \r\n"
    			+ "WHERE product_name = ? \r\n"
    			+ "GROUP BY product_name, salesman_area;";
        List<ProductInfo> productInfo = jdbcTemplate.query(query, new Object[]{name}, new BeanPropertyRowMapper<>(ProductInfo.class));
    	return productInfo;
    }
	
	public List<SalesmanInfo> getSalesmanInfoByName(String name) {
    	String query = "SELECT salesman_area AS area,\r\n"
    			+ "    SUM(sales_amount) AS totalValue,\r\n"
    			+ "	SUM(salesman_commission) AS commission\r\n"
    			+ "FROM sales_commission\r\n"
    			+ "WHERE salesman_name = ? \r\n"
    			+ "GROUP BY salesman_name,salesman_area;";
    	List<SalesmanInfo> salesmanInfo = jdbcTemplate.query(query, new Object[]{name}, new BeanPropertyRowMapper<>(SalesmanInfo.class));
    	return salesmanInfo;
    }
	
	public List<SalesCommission> getCommissionByDate(LocalDate date) {
		String query = "SELECT * FROM sales_commission WHERE created_date = ?";
        List<SalesCommission> salesCommission = jdbcTemplate.query(query, new Object[]{date}, new BeanPropertyRowMapper<>(SalesCommission.class));
    	return salesCommission;
	}
	
//	public Map<String, Double> getAllSalesmanCommission() {
//		Map<String, Double> map = new HashMap<>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","Shoaib@123");
//					PreparedStatement statement=con.prepareStatement("select salesman_name,sum(salesman_commission) from sales_commission group by salesman_name");
//					ResultSet rs=statement.executeQuery()){
//				while(rs.next()) {
//					String name=rs.getString(1);
//					double commission=rs.getDouble(2);
//					map.put(name,commission);
//				}
//			}catch(SQLException e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		catch(ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
//		return map;
//	}
	
	public List<SalesCommission> getAllSales() {
		
		return salesRepository.findAll();
	}
	
	public SalesCommission getById(int id) {
		
		return salesRepository.findById(id).get();
	}
	
}
