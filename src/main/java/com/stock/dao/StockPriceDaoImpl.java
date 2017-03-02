package com.stock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import org.springframework.stereotype.Repository;
import com.stock.bean.StockBean;

@SuppressWarnings("deprecation")
@Repository("stockPriceDao")

public class StockPriceDaoImpl implements StockPriceDao{
	int count;
	 private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	 /*SparkConf conf = new SparkConf()
	     .setAppName("HiveConnector")
		.setMaster("local[4]")
		.set("spark.driver.allowMultipleContexts", "true");
	    JavaSparkContext sc = new JavaSparkContext(conf);*/
	   SparkSession ssc = SparkSession.builder().master("local").appName("test").enableHiveSupport().getOrCreate();
	    	 
	public List<Map<String, Object>> getStockPriceOpen() throws SQLException {
		 
		 /*try {

			  Class.forName(driverName);
		  } catch (ClassNotFoundException e) {
		   
		    e.printStackTrace();
		  }
		  
		  Connection con = DriverManager.getConnection("jdbc:hive2://10.10.0.30:10000/kiran", "hive", "");
		  Statement stmt = con.createStatement();*/
		  Dataset<Row> sql = ssc.sql("select count(stock_price_open) as count,stock_price_open from kiran.stockmarketdata group by stock_price_open ORDER BY stock_price_open ASC limit 20");
		 /* //Dataset<Row> sql = sc.sql("select stock_price_open,count(*) from stockmarketdata group by stock_price_open limit 5");
                 
		 // String sql= "select stock_price_open,count(*) from stockmarketdata group by stock_price_open limit 5";
		//  ResultSet res = stmt..executeQuery(sql);
		  if (res.next()) {
		    System.out.println(res.getString(1));
		  }
		//  res = stmt.executeQuery(sql);
		 
		//  while (res.next()) {
		   // System.out.println(String.valueOf(res.getString(1)) + "\t" + res.getString(2));
			  StockBean sps= new StockBean();
				 String emps=String.valueOf(res.getString(1)));
				// Integer emp1=Integer.valueOf(res.(getString(2)));
				   sps.setStock_price_open(emps);
				  // sps.setCount(emp1);
					stockList.add(sps);
		  
			 // }
			return stockList;*/
		  List<Map<String, Object>> stockList = new ArrayList<>();
		  StockBean sps= new StockBean();
		 
		  Row[] dataRows = (Row[]) sql.collect();
		 
		  String[] columns = sql.columns();
		 
		    for (Row row : dataRows) {
		    		    		
		    	Map<String, Object> object= new HashMap<String, Object>();
		          
		        	   for(String column : columns)
		        	   {
		        		 
		        		   object.put(column, row.getAs(column));
		        		  
		        
		                 }
		        	   stockList.add(object);
		        	   
		      //     }
		    }
		    
	
		return stockList;
		
			 
		  
	}

	
}
