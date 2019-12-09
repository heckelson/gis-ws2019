// ToolBox.scala

import java.text.DecimalFormat
import scala.math._

object ToolBox {
    // height and width correspond to the dimensions of the arrays
    def height(input: Array[Array[Double]]) : Int = { input.length }
    def width(input: Array[Array[Double]]) : Int = { input(0).length }

    // creates a new matrix with the dimesions 'swapped', then adds the matrix values corresponding to the input matrix
    def transpose(input : Array[Array[Double]]) : Array[Array[Double]] = {
        val newHeight = height(input)
        val newWidth  = width(input)
        
        var result = Array.ofDim[Double](newWidth, newHeight)
        
        
        for(i <- 0 to newHeight - 1) {
            for (j <- 0 to newWidth - 1) {
                result(j)(i) = input(i)(j)
            }
        }
        
        result
    }

    def printMatrix(matrix : Array[Array[Double]]) : Unit = {
        val mheight : Int = height(matrix)
        val mwidth  : Int = width(matrix)
        
        // formats decimals like this: 0,5184
        val df = new DecimalFormat("#0.0000")
        
        for (i <- 0 to mheight - 1) {
            print("(")
            for (j <- 0 to mwidth - 1) {
                print(" " + df.format(matrix(i)(j)))
            }
            print(" )\n")
        }
        
    }
    
    // calculates the scalar (or dot) product of two matrices, or vector × matrix. The result is stored as a matrix.
    def scalarProduct(first : Array[Array[Double]],
                      second: Array[Array[Double]]) : Array[Array[Double]] = {
        
        
        val newHeight : Int = height(first)
        val newWidth  : Int = width(second)
        
        // check to make sure only valid pairs are used.
        if (width(first) != height(second)) {
            throw new IllegalArgumentException("These matrices are incompatible. Have you considered ToolBox.transpose()?");
        }
        
        // create the 
        var result = Array.ofDim[Double](newHeight, newWidth)
    /*
        example:
                        j j   
                     i( 3 4 )          j           j
        i( 1 2 3 ) * i( 5 6 ) = i( 1*3+2*5+3*7 1*4+2*6+3*8 )
                     i( 7 8 )
    
    */
    
        // sorry for O(n^3)
        for (x <- 0 to newHeight - 1) {
            for (y <- 0 to newWidth - 1) {
                for(k <- 0 to width(first) - 1) {
                    result(x)(y) += first(x)(k) * second(k)(y)
                }
            }
        }
        
        result
    }
    
    // choose the activation function according to the string 'func', then apply the one which got chosen.
    def applyActivationFunction(func : String,
                    matrix: Array[Array[Double]]) : Array[Array[Double]] = {
    
        var newMatrix = matrix
    
        val mheight : Int = height(matrix)
        val mwidth : Int = width(matrix)
        
        // here is a couple lambda functions for activation functions
        val sig  = (x: Double) => 1.0/2 * (1.0 + math.tanh(x/2.0))
        val tanh = (x: Double) => math.tanh(x)
        val rect = (x: Double) => math.max(0,x)
        val none = (x: Double) => x
        
        val activationFunction = func match {
            case "sig"  => sig
            case "tanh" => tanh
            case "rect" => rect
            case _      => none // this is the default case
        }
        
        // apply the function on all values in the matrix
        for(i <- 0 to mheight - 1) {
            for (j <- 0 to mwidth - 1) {
                newMatrix(i)(j) = activationFunction(matrix(i)(j))
            }
        }
        
        newMatrix
    }
    
}
