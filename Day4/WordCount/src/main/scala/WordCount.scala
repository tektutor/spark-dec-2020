import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCount {

	def main ( args: Array[String] ) {
		
		val conf = new SparkConf()
			.setAppName("Word Count")
		        .setMaster("local")
		
		var spark = new SparkContext( conf )

		val fileRDD = spark.textFile( "README.txt" )

		val count = fileRDD.flatMap ( line => ( line.split( " " ) ) ).count()
		
  		println ( "###################################")
		println ( s"Total word count is $count" )
  		println ( "###################################")
			
	}

}
