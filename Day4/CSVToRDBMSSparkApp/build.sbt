name := "CSVToRDBMS"
version := "1.0"
scalaVersion := "2.12.10"
libraryDependencies ++= Seq(
	"org.apache.spark" %% "spark-sql" % "3.0.1",
	"mysql" % "mysql-connector-java" % "8.0.19"
)
