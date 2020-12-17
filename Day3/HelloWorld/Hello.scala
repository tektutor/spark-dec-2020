object Hello {

   def main ( args : Array[String] ) = {
        
       println ( "Inside main function ..." )

       val hello1 = new HelloWorld("First Object")
       println ( hello1.sayHello() )


       val hello2 = new HelloWorld("Second Object")
       hello1.setMessage("Obj 1")
       println ( hello2.sayHello() )
       println (hello1.sayHello())

   }

}
