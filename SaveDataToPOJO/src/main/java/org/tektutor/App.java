package org.tektutor;

import static org.apache.spark.sql.functions.concat;
import static org.apache.spark.sql.functions.expr;
import static org.apache.spark.sql.functions.lit;

import java.io.Serializable;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class App {

	public static void main ( String[] args ) {

		App app = new App();
		app.start();

	}

	private void start() {

		SparkSession spark = SparkSession.builder()
			.appName( "Read data into POJO" )
			.master ( "local" )
			.getOrCreate();

		Dataset<Row> df = spark.read().format("csv")
		     .option("inferschema", "true")
		     .option("header", "true")
		     .load( "books.csv");

		System.out.println ("Books ingested in a dataframe ...");
		df.show();
		df.printSchema();

		Dataset<Book> bookDs = df.map( 
			new BookMapper(),Encoders.bean(Book.class));

		bookDs.show();
		bookDs.printSchema();

	}
}
