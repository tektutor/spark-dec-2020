object SwitchDemo {

   def main (args: Array[String]) = {
	
	val x = 3

	x match {
	    case 1 => println ("One")
	    case 2 => println ("Two")
	    case 3 => println ("Three")
	    case 4 => println ("Four")
	    case 5 => println ("Five")
	    case _ => println ("Unknown")
	}

   }

}
