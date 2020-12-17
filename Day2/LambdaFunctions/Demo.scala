class Demo {

    def squareIt(value: Int): Int = {
       value * value
    }

    def cubeIt(value: Int): Int = {
       value * value * value
    }

    def computeSquare( x: Int ) = {
       val result = computeLambda ( x, squareIt )
       println ( s"Square of $x = $result" )
    }

    def computeCube( x: Int ) = {
       val result = computeLambda ( x, cubeIt )
       println ( s"Cube of $x = $result" )
    }

    /**
     * This function take two args.
     * First argument is an Int for which you wish to compute square and cube values
     * Second argument is a function that take and returns an Int
     * The computed result will then be return as Int
    **/
    private def computeLambda( x: Int, f: Int => Int ): Int = {
       val result = f( x )
       return result
    }

}
