package com.example.task06a

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View

class BoardView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    //circle and text colors
    private val plusCol: Int = Color.RED
    private val minusCol: Int = Color.YELLOW
    private val backCol: Int= Color.argb(100,128,255,0 )
    private val textCol: Int = Color.BLACK
    //paint variables
    private var plusPaint: Paint
    private var backPaint: Paint
    private var minusPaint: Paint
    private var wordsPaint: Paint
    // Other variables
    private val textShim: Int = 60


    init {
        //paint object for drawing circles in onDraw -- also configure it
            plusPaint = Paint().apply {
                style = Paint.Style.FILL
                setAntiAlias(true)
                //set the paint color using the circle color specified
                setColor(plusCol)
            }
            backPaint = Paint().apply {
                // Set up the paint style
                setStyle(Paint.Style.FILL)
                setColor(backCol)
            }
            minusPaint = Paint().apply {
                setStyle(Paint.Style.FILL)
                setAntiAlias(true)
                setColor(minusCol)
            }
            wordsPaint = Paint().apply {
                setColor(textCol)
                //set text properties
                setTextAlign(Paint.Align.CENTER)
                setTextSize(200.toFloat())
                setTypeface(Typeface.SANS_SERIF)
        }

}
    override fun onDraw(canvas: Canvas) {
        //draw the View
        // Measure the size of the canvas, we could take into account padding here
        val canvasWidth = width.toFloat()
        val canvasHeight = height.toFloat()
        //get half of the width and height to locate the centre of the screen
        val viewWidthHalf = canvasWidth / 2f
        val viewHeightThird = canvasHeight / 3f
        // Background
        canvas.drawRect(0f, 0f, canvasWidth, canvasHeight, backPaint)

        // Retrieve the value of score from the game class
        val score = 0.toString()
        canvas.drawText(score, viewWidthHalf, 200f, wordsPaint)

        // Circles
        val radius: Float = viewWidthHalf/3
        canvas.drawCircle(viewWidthHalf, viewHeightThird, radius, plusPaint)
        canvas.drawText("+", viewWidthHalf, viewHeightThird + textShim, wordsPaint)
        canvas.drawCircle(viewWidthHalf, viewHeightThird*2, radius, minusPaint)
        canvas.drawText("-", viewWidthHalf, (viewHeightThird*2) + textShim, wordsPaint)

    }

}