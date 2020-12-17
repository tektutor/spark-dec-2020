object Loops {

	def main ( args: Array[String] )  = {
		var x = 0	
		for ( x <- 1 to 5 ) {
			println ( x )
		}

		while ( x < 10 ) {
			println ( x )
			x += 1
		}

		do {
			println ( x )
			x -= 1
		} while ( x > 0 )
	
  }

}
