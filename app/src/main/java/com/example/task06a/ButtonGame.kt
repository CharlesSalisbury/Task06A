package com.example.task06a

class ButtonGame {
    var counter: Int = 0
    fun buttonPressed(oper: Char): Unit {
        when (oper) {
            'p' -> counter = counter + 1
            'm' -> counter = counter - 1
        }
        // Call fireGameChange from anywhere in this class which can change the game state
        fireGameChange()

    }
    // Variable which will hold a reference to the function onGameChange which is declared
// in the BoardView class
    var onGameChangeListener: GameChangeListener? = null
    // Function, which will, when called, store a reference back to the View (the thing
// listening for a change) in the variable onGameChangeListener.
// This enables the game class to alert the view class when the game state changes
    fun setGameChangeListener(listenerImp: GameChangeListener) {
        onGameChangeListener = listenerImp
    }
    // This will execute the onGameChange method defined in whichever View is referred
// to by the variable onGameChangeListener
    fun fireGameChange() {
        onGameChangeListener?.onGameChange(this)
    }


}
