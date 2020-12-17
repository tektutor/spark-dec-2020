object Main {
  
   def main( args: Array[String] ) = {

      if ( args.length > 0 )
      {
         val demo = new Demo();
         demo.computeSquare( args(0).toInt )
         demo.computeCube( args(0).toInt )
      }
      else {
         println ( "Error, you must supply one number as argument" ) 
      }

   }

}
