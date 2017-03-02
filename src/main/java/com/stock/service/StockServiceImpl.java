package com.stock.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.bean.StockBean;
import com.stock.bean.StockPriceHigh;
import com.stock.bean.StockPriceLow;
import com.stock.dao.StockPriceDao;
import com.stock.dao.StockPriceHighDao;
import com.stock.dao.StockPriceLowDao;
@Service("stockService")
public class StockServiceImpl implements StockService{

	@Autowired
	private StockPriceDao stockPriceDao;
	@Autowired
	private StockPriceHighDao stockPriceHighDao;
	@Autowired
	private StockPriceLowDao stockPriceLowDao;
	
	public List<Map<String, Object>> getStockPriceOpen() throws SQLException {
		 
		List<Map<String, Object>> sb = stockPriceDao.getStockPriceOpen();
			  return sb;
		
	}
/*	public List<StockPriceHigh> getStockPriceHigh() throws SQLException {
		List<StockPriceHigh> sb1 = stockPriceHighDao.getStockPriceHigh();
		return sb1;
	}*/

	public List<Map<String, Object>> getStockPriceHigh() throws SQLException {
		 
		List<Map<String, Object>> sb1 = stockPriceHighDao.getStockPriceHigh();
			  return sb1;
		
	}
	
	/*public List<StockPriceLow> getStockPriceLow() throws SQLException {
		List<StockPriceLow> sb2 = stockPriceLowDao.getStockPriceLow();
		return sb2;
	}
*/
	public List<Map<String, Object>> getStockPriceLow() throws SQLException {
		 
		List<Map<String, Object>> sb1 = stockPriceLowDao.getStockPriceLow();
			  return sb1;
	
}
}