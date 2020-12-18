import org.apache.spark.sql.{SparkSession, SaveMode}
import org.apache.spark.sql.functions.{concat, lit, col}

import java.util.Properties

object CSVToRDBMSSparkApp {

   def main ( args: Array[ String ] ) {

	val spark = SparkSession.builder	
		.appName ( "CSV To MySQL" )
		.master  ( "local" )
		.getOrCreate
	
	var df = spark.read.format( "csv" )
	       	.option("header", "true" )
		.load("books.csv")

	df = df.withColumn( "author", concat( col("lname"), lit(" "),col("fname") ) )
	
	//val dbConnectionURL = "jdbc:mysql://localhost/tektutor"
	val dbConnectionURL = "jdbc:mysql://100.26.161.203/tektutor"
	
	val prop = new Properties
	prop.setProperty( "driver", "com.mysql.jdbc.Driver" )
	prop.setProperty( "user", "root" )
	prop.setProperty( "password", "Root@123" )
	
	df.write.mode(SaveMode.Overwrite).jdbc(dbConnectionURL, "books", prop)
	
	spark.stop

	println ("CSV data successfully serialized into MySQL Server !")

   }

}
