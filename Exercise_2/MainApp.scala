//MainApp.scala

object MainApp extends App {
    
    // we create the inputVector as a 1x3 matrix (height x width)
    val inputVector : Array[Array[Double]] = Array(Array(0.1,-0.2,0.3))
    
    println("inputVector:")
    ToolBox.printMatrix(inputVector)
    println()
    
    // because we have 3 nodes in the hidden layer, we create a 3x3 matrix
    val weights1 : Array[Array[Double]] = Array(
        Array(0.1,-0.2,0.3),
        Array(0.2,0.3,-0.4),
        Array(0.3,-0.4,0.5)
    )
    
    println("weights1:")
    ToolBox.printMatrix(weights1)
    println()
    
    println("scalar product of inputVector and weights1:")
    ToolBox.printMatrix(ToolBox.scalarProduct(inputVector, weights1))
    println()
    
    val hiddenVector = ToolBox.applyActivationFunction(
        "sig",
        ToolBox.scalarProduct(inputVector, weights1)
    )
    
    println("hiddenVector (scalar product with activation func applied):")
    ToolBox.printMatrix(hiddenVector)
    println()
    
    // our output layer has exactly one value, hence we create a 3x1 matrix
    val weights2 : Array[Array[Double]] = Array(
        Array(0.1),
        Array(0.3),
        Array(-0.2)
    )
    
    println("weights2:")
    ToolBox.printMatrix(weights2)
    println()
    
    
    // apply all the activation functions ...
    val outputSig  = ToolBox.applyActivationFunction(
        "sig",
        ToolBox.scalarProduct(hiddenVector, weights2)
    )
    val outputTanh = ToolBox.applyActivationFunction(
        "tanh",
        ToolBox.scalarProduct(hiddenVector, weights2)
    )
    val outputRect = ToolBox.applyActivationFunction(
        "rect",
        ToolBox.scalarProduct(hiddenVector, weights2)
    )
    
    // ... and print.
    println("output (raw) for comparison:")
    ToolBox.printMatrix(ToolBox.scalarProduct(hiddenVector, weights2))
    println()
    
    println("output (sig):")
    ToolBox.printMatrix(outputSig)
    println()
    
    println("output (tanh):")
    ToolBox.printMatrix(outputTanh)
    println()
    
    println("output (rect):")
    ToolBox.printMatrix(outputRect)
    println()
    
}
