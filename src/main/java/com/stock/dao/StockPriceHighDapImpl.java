package com.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Repository;

import com.stock.bean.StockBean;
import com.stock.bean.StockPriceHigh;

@Repository("stockPriceHighDao")
public class StockPriceHighDapImpl implements StockPriceHighDao {
	 private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	 SparkSession ssc = SparkSession.builder().master("local").appName("test").enableHiveSupport().getOrCreate();
	/*public List<StockPriceHigh> getStockPriceHigh() throws SQLException*/
	 public List<Map<String, Object>> getStockPriceHigh() throws SQLException{
		/*try {

			  Class.forName(driverName);
		  } catch (ClassNotFoundException e) {
		   
		    e.printStackTrace();
		  }
		  
		  Connection con = DriverManager.getConnection("jdbc:hive2://10.10.0.30:10000/kiran", "hive", "");
		  Statement stmt = con.createStatement();
		 
		  String sql= "select stock_price_high,count(*) from stockmarketdata group by stock_price_high limit 5";
		  ResultSet res = stmt.executeQuery(sql);
		  if (res.next()) {
		    System.out.println(res.getString(1));
		  }
		  res = stmt.executeQuery(sql);
		  List<StockPriceHigh> stockList = new ArrayList<StockPriceHigh>();
		  while (res.next()) {
		   // System.out.println(String.valueOf(res.getString(1)) + "\t" + res.getString(2));
			  StockPriceHigh sps= new StockPriceHigh();
				 String emps=String.valueOf(res.getString(1));
				 Integer emp1=Integer.valueOf(res.getString(2));
				   sps.setStock_price_high(emps);
				   sps.setCount(emp1);
					stockList.add(sps);
		  
			  }*/
		 Dataset<Row> sql = ssc.sql("select count(stock_price_high) as count,stock_price_high from kiran.stockmarketdata group by stock_price_high ORDER BY stock_price_high ASC limit 20");
		 
		 List<Map<String, Object>> stockList1 = new ArrayList<>();
		  Row[] dataRows = (Row[]) sql.collect();
		 
		  String[] columns = sql.columns();
		 
		    for (Row row : dataRows) {
		    		    		
		    	Map<String, Object> object= new HashMap<String, Object>();
		          
		        	   for(String column : columns)
		        	   {
		        		 
		        		   object.put(column, row.getAs(column));
		        		  
		        
		        	   }
		    
		        	   stockList1.add(object);
		    }

		return stockList1;
	}
}
