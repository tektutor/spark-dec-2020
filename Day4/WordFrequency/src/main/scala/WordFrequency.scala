import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordFrequency {

	def main ( args: Array[String] ) {

		val conf = new SparkConf()
                    .setAppName( "Word Count" )
		    .setMaster( "local" )

		val sparkCtx = new SparkContext ( conf )

		val linesRDD = sparkCtx.textFile ( "README.txt" )

		val countRDD = linesRDD.flatMap ( line => ( line.split( " " ) ) )
		  .map( word => ( word, 1 ) )
                  .reduceByKey ( _ + _ )		

		countRDD.saveAsTextFile ( "output.txt" )

	}

}
