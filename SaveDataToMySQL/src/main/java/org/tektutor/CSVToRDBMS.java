package org.tektutor;

import static org.apache.spark.sql.functions.concat;
import static org.apache.spark.sql.functions.lit;

import java.util.Properties;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

public class CSVToRDBMS {

	public static void main ( String[] args ) {
		CSVToRDBMS demo = new CSVToRDBMS();
		demo.start();
	}

	private void start() {

		SparkSession spark = SparkSession.builder()
			.appName("CSV To RDBMS Demo")
			.master("local")
			.getOrCreate();
		
		Dataset<Row> df = spark.read().format("csv")
		     .option("header","true")
		     .load("authors.csv");
	
		df = df.withColumn( 
					"author", 
					concat(df.col("lname"),
					lit( " ," ),
					df.col("fname")
	        )).drop(df.col("lname")).drop(df.col("fname"));

		df.printSchema();

		String dbConnectionUrl = "jdbc:mysql://localhost/tektutor";

		Properties prop = new Properties();
		prop.setProperty ( "driver", "com.mysql.jdbc.Driver" );
		prop.setProperty ( "user",   "root" );
		prop.setProperty ( "password", "Root@123" );

		df.write().mode(SaveMode.Overwrite)
		  .jdbc( dbConnectionUrl, "author", prop );

		System.out.println ("Successfully saved the transformation");
	}
}
