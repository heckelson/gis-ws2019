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
    // weights for the first layer
    println("weights1:")
    ToolBox.printMatrix(weights1)
    println()
    
    println("scalar product of inputVector and weights1:")
    ToolBox.printMatrix(ToolBox.scalarProduct(inputVector, weights1))
    println()
    
    
    // the vector for the hidden layer, with different activation funcs applied
    val hiddenSig = ToolBox.applyActivationFunction(
        "sig",
        ToolBox.scalarProduct(inputVector, weights1)
    )
    val hiddenTanh = ToolBox.applyActivationFunction(
        "tanh",
        ToolBox.scalarProduct(inputVector, weights1)
    )
    val hiddenRect = ToolBox.applyActivationFunction(
        "rect",
        ToolBox.scalarProduct(inputVector, weights1)
    )
    val hiddenNone = ToolBox.applyActivationFunction(
        "none",
        ToolBox.scalarProduct(inputVector, weights1)
    )
    
    // print
    println("hiddenVector (sig):")
    ToolBox.printMatrix(hiddenSig)
    println()
    println("hiddenVector (tanh):")
    ToolBox.printMatrix(hiddenTanh)
    println()
    println("hiddenVector (rect):")
    ToolBox.printMatrix(hiddenRect)
    println()
    println("hiddenVector (none):")
    ToolBox.printMatrix(hiddenNone)
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
        ToolBox.scalarProduct(hiddenSig, weights2)
    )
    val outputTanh = ToolBox.applyActivationFunction(
        "tanh",
        ToolBox.scalarProduct(hiddenTanh, weights2)
    )
    val outputRect = ToolBox.applyActivationFunction(
        "rect",
        ToolBox.scalarProduct(hiddenRect, weights2)
    )
    val outputNone = ToolBox.applyActivationFunction(
        "rect",
        ToolBox.scalarProduct(hiddenNone, weights2)
    )
    
    // ... and print.
    println("output (raw) for comparison:")
    ToolBox.printMatrix(outputNone)
    println()
    
    println("output (sig):")
    ToolBox.printMatrix(outputSig)
    println("relative error: " + ToolBox.relativeError(0.5, outputSig))
    println()
    
    println("output (tanh):")
    ToolBox.printMatrix(outputTanh)
    println("relative error: " + ToolBox.relativeError(0.5, outputTanh))
    println()
    
    println("output (rect):")
    ToolBox.printMatrix(outputRect)
    println("relative error: " + ToolBox.relativeError(0.5, outputRect))
    println()
    
}

// Zu Folie Backpropagation - weight update
//if j is an output neuron
// if j is a hidden neuron
// steht im Skriptum verkehrt herum
