import org.apache.spark.sql.SparkSession

object Loan {

  def main ( args: Array[String] ) = {

        val spark = SparkSession.builder.appName("Loans").getOrCreate();
	
	val df = spark.read
		      .option("header","true")
                      .option("inferSchema","true")
                      .csv("loans.csv") 

	//df.createOrReplaceTempView("LOANS")

        val output 
              = df.groupBy("CustID")
                  .sum("amountInINR")
                  .as("TotalLoanAmount")
                  .orderBy("CustID")

        output.show()
  }

}
