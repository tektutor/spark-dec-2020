object Main {
  
   def main( args: Array[String] ) = {

      if ( args.length > 0 )
      {
         val demo = new Demo();

	 val inputNum = args(0).toInt

         demo.computeSquare( inputNum )
         demo.computeCube( inputNum )
      }
      else {
         println ( "Error, you must supply one number as argument" ) 
      }

   }

}
