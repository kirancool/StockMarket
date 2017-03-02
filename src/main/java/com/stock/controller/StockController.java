package com.stock.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.stock.bean.StockBean;
import com.stock.bean.StockPriceHigh;
import com.stock.bean.StockPriceLow;
import com.stock.service.StockService;

@Controller
@RequestMapping(value = "/stocks")
public class StockController {
	@Autowired
	 private StockService stockService;
	
	@RequestMapping(value = "/getStockPriceOpen", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getStockPriceOpen() throws SQLException
			 {	
		return stockService.getStockPriceOpen();
	}

	/*@RequestMapping(value = "/getStockPriceHigh", method = RequestMethod.GET)
	public @ResponseBody List<StockPriceHigh> getStockPriceHigh() throws SQLException
			 {	
		return stockService.getStockPriceHigh();
	}*/
	@RequestMapping(value = "/getStockPriceHigh", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getStockPriceHigh() throws SQLException
			 {	
		return stockService.getStockPriceHigh();
	}
	/*@RequestMapping(value = "/getStockPriceLow", method = RequestMethod.GET)
	public @ResponseBody List<StockPriceLow> getStockPriceLow() throws SQLException
			 {	
		return stockService.getStockPriceLow();
	}*/
	@RequestMapping(value = "/getStockPriceLow", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getStockPriceLow() throws SQLException
			 {	
		return stockService.getStockPriceLow();
	}
}
