package code.with.cal.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import code.with.cal.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    enum class Turn {
        NOUGHT,
        CROSS
    }

    private var firstTurn = Turn.CROSS
    private var currentTurn = Turn.CROSS

    private var crossesScore = 0
    private var noughtsScore = 0

    private var boardList = mutableListOf<Button>()
    private var mboardList = mutableListOf<Button>()
    private var iboardList = mutableListOf<ImageButton>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()

    }

    private fun initBoard() {

        boardList.add(binding.a0)
        boardList.add(binding.a1)
        boardList.add(binding.a2)
        boardList.add(binding.a3)
        boardList.add(binding.a4)
        boardList.add(binding.b0)
        boardList.add(binding.b1)
        boardList.add(binding.b2)
        boardList.add(binding.b3)
        boardList.add(binding.b4)
        boardList.add(binding.c0)
        boardList.add(binding.c1)
        boardList.add(binding.c2)
        boardList.add(binding.c3)
        boardList.add(binding.c4)
        boardList.add(binding.d0)
        boardList.add(binding.d1)
        boardList.add(binding.d2)
        boardList.add(binding.d3)
        boardList.add(binding.d4)

        mboardList.add(binding.a1)
        mboardList.add(binding.a2)
        mboardList.add(binding.a3)
        mboardList.add(binding.a4)
        mboardList.add(binding.b1)
        mboardList.add(binding.b2)
        mboardList.add(binding.b3)
        mboardList.add(binding.b4)
        mboardList.add(binding.c1)
        mboardList.add(binding.c2)
        mboardList.add(binding.c3)
        mboardList.add(binding.c4)
        mboardList.add(binding.d1)
        mboardList.add(binding.d2)
        mboardList.add(binding.d3)
        mboardList.add(binding.d4)


    }

    // See styles.xml
    fun boardTapped(view: View) {
        if (view !is Button)
            return

        if (boardList.indexOf(view) == 0) {
            addToBoard(view)
        } else if (boardList.indexOf(view) == 5) {
            addToBoard(view)
        } else if (boardList.indexOf(view) == 10) {
            addToBoard(view)
        } else if (boardList.indexOf(view) == 15) {
            addToBoard(view)
        }


        if (checkForVictory(NOUGHT)) {
            noughtsScore++
            result("Noughts Win!")
        } else if (checkForVictory(CROSS)) {
            crossesScore++
            result("Crosses Win!") // Bad: "Noughts Win!", Good: "Crosses Win!"
        } else if (fullBoard()) {
            result("Draw")
        }

    }

    private fun checkForVictory(s: String): Boolean {
        //Vertical Victory
        if (match(binding.a1, s) && match(binding.a2, s) && match(
                binding.a3,
                s
            ) && match(binding.a4, s)
        )
            return true
        if (match(binding.b1, s) && match(binding.b2, s) && match(
                binding.b3,
                s
            ) && match(binding.b4, s)
        )
            return true
        if (match(binding.c1, s) && match(binding.c2, s) && match(
                binding.c3,
                s
            ) && match(binding.c4, s)
        )
            return true
        if (match(binding.d1, s) && match(binding.d2, s) && match(
                binding.d3,
                s
            ) && match(binding.d4, s)
        )
            return true

        //Horizontal Victory
        if (match(binding.a1, s) && match(binding.b1, s) && match(
                binding.c1,
                s
            ) && match(binding.d1, s)
        )
            return true
        if (match(binding.a2, s) && match(binding.b2, s) && match(
                binding.c2,
                s
            ) && match(binding.d2, s)
        )
            return true
        if (match(binding.a3, s) && match(binding.b3, s) && match(
                binding.c3,
                s
            ) && match(binding.d3, s)
        )
            return true
        if (match(binding.a4, s) && match(binding.b4, s) && match(
                binding.c4,
                s
            ) && match(binding.d4, s)
        )
            return true

        //Diagonal Victory
        if (match(binding.a1, s) && match(binding.b2, s) && match(
                binding.c3,
                s
            ) && match(binding.d4, s)
        )
            return true
        if (match(binding.a4, s) && match(binding.b3, s) && match(
                binding.c2,
                s
            ) && match(binding.d1, s)
        )
            return true

        return false
    }

    private fun match(button: Button, symbol: String): Boolean = button.text == symbol

    private fun result(title: String) {
        val message = "\nNoughts $noughtsScore\n\nCrosses $crossesScore"
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setNegativeButton("Exit")
        { _, _ ->
            exit()
        }
        builder.setCancelable(false)
        builder.setPositiveButton("Reset Game")
        { _, _ ->
            resetBoard()
        }
        builder.setCancelable(false)
        builder.show()
    }

    private fun resetBoard() {
        for (button in boardList) {
            button.text = ""

        }

        if (firstTurn == Turn.NOUGHT)
            firstTurn = Turn.CROSS
        else if (firstTurn == Turn.CROSS)
            firstTurn = Turn.NOUGHT

        currentTurn = firstTurn
        setTurnLabel()
    }

    private fun fullBoard(): Boolean {
        // A check to see if the board is full X's and O's,
        // any empty buttons = game continues
        for (button in mboardList) {
            if (button.text == "")
                return false
        }
        return true
    }

    private fun addToBoard(button: Button) {


        val index = boardList.indexOf(button) + 4

        checkloop@ for (i in 0..3) {
            var button2 = boardList[index - i]
            if (button2.text == "") {
                if (currentTurn == Turn.NOUGHT) {
                    button2.setTextColor(Color.RED)
                    button2.text = NOUGHT

                    currentTurn = Turn.CROSS
                } else if (currentTurn == Turn.CROSS) {
                    button2.setTextColor(Color.YELLOW)
                    button2.text = CROSS

                    currentTurn = Turn.NOUGHT

                }
                break@checkloop
            }
        }
        setTurnLabel()

    }


    private fun setTurnLabel() {
        var turnText = ""
        if (currentTurn == Turn.NOUGHT)
            turnText = "Turn $NOUGHT"
        else if (currentTurn == Turn.CROSS)
            turnText = "Turn $CROSS"
        binding.turnTV.text = turnText
    }


    companion object {
        const val NOUGHT = "O"
        const val CROSS = "X"
    }

    private fun exit() {
        this@MainActivity.finish()
    }


}