package org.tektutor;

import static org.apache.spark.sql.functions.concat;
import static org.apache.spark.sql.functions.expr;
import static org.apache.spark.sql.functions.lit;

import java.io.Serializable;

import org.apache.spark.api.java.function.*;
import org.apache.spark.sql.*;

import java.util.Arrays;

public class App {

	public static void main ( String[] args ) {

		App app = new App();
		app.start();

	}

	private void start() {

		SparkSession spark = SparkSession.builder()
			.appName( "Word Count" )
			.master ( "local" )
			.getOrCreate();

		Dataset<String> df 
		  = spark.read().text("words.txt").as(Encoders.STRING());
		
		Dataset<String> words = df.flatMap( s -> {
		   return Arrays.asList(s.toLowerCase().split(" ")).iterator();
		}, Encoders.STRING() );

		Dataset<Row> t = 
			words.groupBy("value").count().toDF("word","count");

		t = t.sort( functions.desc("count"));
		t.toJavaRDD().saveAsTextFile("out.txt");
	}
}
