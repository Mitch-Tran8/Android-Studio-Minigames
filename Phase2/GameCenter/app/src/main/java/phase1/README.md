# How to Set Up and Run

1.  From MarkUs, copy the repository <URL>.

2.  In Android Studio, click “check out project from version control.” Select GIT, and git clone
    <URL>.

3.  In android studio open a project. Make your way to Phase2 and open GameCenter.

4.  Before running the app make sure you have the proper SDK, at least android 8.0.

5.  For the device, choose the Pixel 2 API 27.

6.  Download any files if android studio prompts it.

7.  Run the app.

8.  Login or register (if new user) with email and password.

9.  After you have registered you will be taken back to the login page.


### Running Instrumented Unittests

- We were able to write some instrumented unittests to test activity classes that only have views and
button listeners that lead to a another page.

- Please ensure in build.gradle (Module:app), you have the following testImplementation in
dependencies: androidTestImplementation 'com.android.support.test:rules:1.0.2' (if not, please add).

- Also ensure under buildTypes, you have: debug { testCoverageEnabled true }

- To run, click the Gradle bar on the right hand side of the screen. Go under app -> tasks ->
verification -> click on createDebugCoverageReport. Gradle will take a while to build as it is
in the process of testing (note: it is quite a slow process, takes around 8-9 minutes).

- Once Gradle is done testing and building, go under Project -> Game Center -> app -> reports ->
coverage -> debug -> you should see an index.html file created. Gradle has created the code coverage
report for the instrumented tests in the form of the html file. Right click to open in browser and
you will see the coverage separated by package. Click on each package to view each class.

### To play sliding tiles:

1.  Select the sliding numberTiles game.

2.  Choose complexity of the slidingTilesBoard to start a new game or load from a saved game.

3.  If the user would like to save the game, tap save.

4.  To exit the game, tap the back button.

### To Play Matched (colour Tiles):

1. Selected the matched game.

2. Select either instructions, load from game or start a new game.

3. When selecting either load/new game, you will be taken to a page with all the rounds displayed.
All of the buttons except round1 will be un clickable. Select round 1.

4.  Swap two tiles by selecting the ones you want to swap. Match three tiles in a row horizontally
or vertically. Once you match three tiles, those tiles will disappear and all the tiles ontop of it
will replace them (like bejeweled!). Try to get as many matches as you can within the time limit.
Each round has a required score inorder to proceed to the next round.

5. If you achieved the required score, you will be taken back to the main rounds page, a message
will be displayed, and the next round button will be unlocked.
If you did not achieve the required score, you will be taken back to the main page, and a message
that says "try again" will be displayed. Every time you win/lose a round, the game will be autosaved.

6. If you load a saved game, The round which you played last will be saved as well as the arrangement
of the tiles, and the time. There is a save progress button on the rounds page to save the last
round that you played, and there is a save button in the actual game play to save the tile arrangement.

7. Once you beat all of the levels, a message will be displayed.

### To play Connect numbers:

1. Select the connect numbers game.

2. To play against AI, select the one player mode. To play with a partner, select the two player mode.

-  Under the one player mode, you will be playing connect 3, aka Tic-Tac-Toe.
   There are two levels of difficulties against the AI, "Easy" and "Genius." The easy mode is against
   an AI whose moves are random. The genius mode implements a minimax algorithm that calculates the
   best move for the AI. Select your mode of choice.

-  Under the two player mode, you have the option of playing connect 3 or connect 4 (Tic-Tac-Toe on
   a 5x5 board and you must get 4 in a row.) Select the connect game of your choice.

3. In each game, you (and your partner in the two player mode) can undo as many moves as you would
   like.

4. To win the game, you must win best 3 out of 5 rounds.

   After each round is over, you will not be allowed to click any of the connect board buttons
   anymore. Should you attempt to, toast messages will prompt you to click the "new round" button.
   Please click the button to start a new round. The TextView will display how many rounds player 1
   and player 2 each have won, as well as the number of rounds that resulted in draws.

   After a player has won the game, or there is a tie (5/5 rounds played, no one won), again,
   you will not be able to click the "new round" button nor any of the connect board buttons.
   Should you click, toast messages will appear instructing you to reset the game.


# Functionalities Implemented

### Login/Register
-   Once the user clicks on the GameCenter App, he/she will be prompted to either register for a new
    account or login in with their pre-existing account. We have connected Firebase Database to our
    app to store the user’s email and password.

### Sliding Tiles Puzzle Game Updates
-  #### Game Complexity
    -   The user has the freedom to choose the size of the numberTiles slidingTilesBoard he/she would like to
    play: 3x3, 4x4, or 5x5.

-  #### Saving Game States

	-   _Save Game, Load Saved Game_ - The user can save an uncompleted game and choose to load the
	saved game the next time they open the game. The uncompleted game is stored to a temporary
	save file.

	-   _AutoSave_ - The game autosaves after every three valid moves.

	-   _Undo Button_ - The game has an undo button that allows the user to undo up to the last 3
	moves taken.

-   #### Scoring System

	-   At the end of each game, a score will be generated based on the number of moves taken by the
	 user to complete the game. Much like the game of golf, the fewer the amount of moves taken, the
	  higher the score will be.

	-   We have accounted for the three different slidingTilesBoard complexities when calculating the score by
	setting a “max” number of moves for each slidingTilesBoard size (50 for 3x3, 150 for 4x4, 250 for 5x5) and
	subtracting the number of moves take by the user from the “max” to generate the user’s score.


### Rankings Page

- We display the user scoreboard and game scoreboard. The user scoreboard shows the top five scores
  of the user for a specific game (in this case, Sliding Tiles) while the game scoreboard shows the
  top 5 scores of a specific game and the corresponding users that attained the scores.

- Both the user scoreboard and game scoreboard are updated after each game.