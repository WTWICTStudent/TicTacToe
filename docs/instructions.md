# Android TicTacToe

## Instructions

This simple game has a host of (15) bugs that prevent users from playing the game. Work your way through the code, working out what the bug is (by interacting with the app on the phone emulator and amending the code).

Tools required:

1. Android Studio - installed mobile app IDE
2. A phone emulator - selected and installed within Android Studio. We will use the Pixel 2 API 30
3. GitHub (that contains the TicTacToe source code) - web based
4. TicTacToe project - the source code

If you have not built Android phone app before it can be a little daunting.
For now we will only focus on the core app code for the game. Contained in:

app\src\main\java\code\with\cal\tictactoe\MainActivity.kt

There are plenty of other files (mobile phone development support code and screen presentation code), we will explain some of those later. For now consider MainActivity.tk to be the only file we will be modifying, it contains the code that defines how the game is run.

So here's a quick breakdown of the methods and control flow of the program (see MainActivity.tk)

1. Oncreate - called by the Android framework code for initialising the TicTacToe application
2. InitBoard - adds the button bindings to a list (boardList). A list that we use to access and change the button state (e.g. display X when the X player selects the button on the TicTacToe board).
3. boardTapped - is triggered when the player clicks on the TicTacToe board cell. Checks to see if the button is clicked, then checks for victory and finally if the board is full (with X's and O's)
4. checkForVistory - checks for winning horizontal, vertical of diagonal lines and returns true if X's or O's have won
5. result - displays an end of game dialog box, stating who won the game, the win count for each player and a reset button
6. resetBoard - called when a player clicks on the reset option in the result dialog box
7. fullBoard - called after every button click to check if the TicTacToe board is full. By iterating through the boardList (list of buttons). If the board is full the function should return true
8. addToBoard - add's appropriate text to the button (X or O) and sets the turn label to the next player
9. setTurnLabel - set's the next turn label (at the top of the TicTacToe board)

As stated above the program has 15 bugs, your task is to work through the code, make changes and (re)run the TicTacToe application to test. Keep repeating until you have fixed all the bugs and have a fully working TicTacToe game.

Initially as the code stands, the TicTacToe board displays with the turn marker set.... but the board does not responed to player clicks - why!

## New Features

There is much more to the application than MainActivity.kt (which contains the game logic), the board, turn status, player selections and game state also need to be displayed on the phone (or emulator).

You can find the presentation files in app/res. The key file is app/res/layout/activity_main.xml. If you open this file in Android Studio you will see an xml file that contains the layout details and the graphical widgets (buttons etc) to display. You can swap between design and code view. The design view presents a graphical representation of the screen layout.

We have used LinearLayout to structure the TicTacToe board. Take a look at the file and see if you can work out how the code maps to what we can see in the design view. Where are the buttons defined in the xml file? How are the vertical and horizontal lines for the board defined?

Also take a peek at app\res\values folder. It conatins files that define the look (colour schemes and styles). Where is the application title defined? What about the application colours?

After debugging and fixing the program, play around with these files to create an application that uses the WTW branding (colours).

If you get through this. Well done, we have an additional coding task that will give you the chance to create your own algorithms for some common problems.