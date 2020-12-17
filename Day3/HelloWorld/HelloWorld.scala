class HelloWorld(var message: String) {

     def anotherMethod() = {
        println ( "Another method" )
     }

     def setMessage ( msg: String ) = {
        this.message = msg
     }

     def sayHello() : String = {
        return "Hello " + this.message + " !"
     }

}
