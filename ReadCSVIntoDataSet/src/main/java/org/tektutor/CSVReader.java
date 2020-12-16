package org.tektutor;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class CSVReader {

	public static void main ( String[] args ) {

		CSVReader csvReader = new CSVReader();
		csvReader.start();	

	}

	public void start() {
		SparkSession spark = SparkSession.builder()
			.appName("CSV to Dataset")
			.master("local")
			.getOrCreate();

		Dataset<Row> df = spark.read().format("csv").option("header", "true")
		     .load( "books.csv" );
		
		df.show(5);
	}

}
