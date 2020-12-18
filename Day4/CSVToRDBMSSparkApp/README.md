### To compile this project
> sbt package

### To execute the spark driver app
> spark-submit --class "CSVToRDBMSSparkApp" --master "local" --driver-class-path mysql-connector-java-8.0.22.jar target/scala-2.12/csvtordbms_2.12-1.0.jar 
