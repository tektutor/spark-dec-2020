object DataStructures {

   def main ( args: Array[String] ) = {

	//Tuples
	val fruits = ( "Apple", "Orange", "Grapes" )
	println ( fruits )

	//Print individual values
	//Note Tuple index starts from 1
	println ( "Value at Index 1 = ", fruits._1 )
	println ( "Value at Index 2 = ", fruits._2 )
	println ( "Value at Index 3 = ", fruits._3 )

	//List
	val ecommerceList = List("Amazon", "FlipKart", "EBay");
	println ( ecommerceList )

	//Print individual values
	//Note List index starts from 0
	println ( "Value at Index 0 = ", ecommerceList(0) )
	println ( "Value at Index 0 = ", ecommerceList.head )
	println ( "Values excluding Index 0 = ", ecommerceList.tail )

	//Printing each value from List
	for ( shop <- ecommerceList ) { println ( shop ) }

	println ( "###### Reverse List ######" )
	val reverseList = ecommerceList.map ( (shop: String) => { shop.reverse } )
	for ( shop <- reverseList ) { println (shop) }  

	val numberList = List(1,2,3,4,5)
	val sum = numberList.reduce ( (x: Int, y: Int) => x + y )
	println ( s"Total = $sum" )

	val excludeFives = numberList.filter( (x:Int) => x != 5 )
	println ( "Values excluding 5 #####", excludeFives )

	println ( "Max value = ", numberList.max )
	println ( "Sum = ", numberList.sum )

	println ( "Contains 2 ", excludeFives.contains ( 2 ) )
	println ( "Contains 5 ", excludeFives.contains ( 5 ) )

	//Map - aka Dictionary in some languages
	val contacts = Map( "Jegan" -> "123-456-7890", "Sriram" -> "435-533-5324" )
	println ( contacts )

	println ( contacts("Sriram") )
        println ( contacts.contains("Rishi") )	

	val Rishi = util.Try ( contacts("Rishi") ) getOrElse "Contact not found"
	println ( Rishi )

   }

}
