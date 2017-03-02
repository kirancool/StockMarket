package com.stock.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stock.bean.StockBean;
import com.stock.bean.StockPriceHigh;
import com.stock.bean.StockPriceLow;



public interface StockService {

	
		public List<Map<String, Object>> getStockPriceOpen() throws SQLException ;

		//public List<StockPriceHigh> getStockPriceHigh() throws SQLException;
		public List<Map<String, Object>> getStockPriceHigh() throws SQLException ;
		//public List<StockPriceLow> getStockPriceLow() throws SQLException; 
		public List<Map<String, Object>> getStockPriceLow() throws SQLException ;

}
