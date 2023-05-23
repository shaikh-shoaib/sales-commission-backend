package com.accolite.salescommission.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.salescommission.aop.LogCustom;
import com.accolite.salescommission.model.Sales;
import com.accolite.salescommission.model.SalesCommission;
import com.accolite.salescommission.popupinfo.ProductInfo;
import com.accolite.salescommission.popupinfo.SalesmanInfo;
import com.accolite.salescommission.service.SalesService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SalesController {

	@Autowired
    private SalesService salesService;
	
    @PostMapping("/sales")
    public String createSales(@RequestBody Sales sales) {
    	
        return salesService.saveSales(sales);
    }
    
    @LogCustom
    @GetMapping("/product-info")
    public List<ProductInfo> getProductInfo(@RequestParam("name") String name) {
    
    	return salesService.getProductInfoByName(name);
    }
    
    @LogCustom
    @GetMapping("/salesman-info")
    public List<SalesmanInfo> getSalesmanInfo(@RequestParam("name") String name) {
    	
    	return salesService.getSalesmanInfoByName(name);
    }
	
	@LogCustom
    @GetMapping("/sales/commission")
    public List<SalesCommission> getSalesCommission(@RequestParam("date") LocalDate date) {
    	
        return salesService.getCommissionByDate(date);
    }
    
//	@LogCustom
//	@GetMapping("/sales/salesman/totalcommission")
//	public Map<String,Double> getSalesmanTotalCommission(){
//		return salesService.getAllSalesmanCommission();
//	}
	
    @GetMapping("/allSales")
    public List<SalesCommission> getSales() {
    	
        return salesService.getAllSales();
    }
    
    @GetMapping("/sales/commission/{id}")
    public SalesCommission getSalesById(@PathVariable int id) {
    	
        return salesService.getById(id);
    }
}
