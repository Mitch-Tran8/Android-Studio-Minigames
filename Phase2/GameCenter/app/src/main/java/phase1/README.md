# How to Set Up and Run

1.  From MarkUs, copy the repository <URL>.

2.  In Android Studio, click “check out project from version control.” Select GIT, and git clone
    <URL>.

3.  In android studio open a project. Make your way to Phase1 and open GameCenter.

4.  Before running the app make sure you have the proper SDK, at least android 8.0.

5.  For the device, choose the Pixel 2 API 27.

6.  Download any files if android studio prompts it.

7.  Run the app.

8.  Login or register (if new user) with email and password.

9.  After you have registered you will be taken back to the login page.

10.  Select the sliding tiles game.

11.  Choose complexity of the board to start a new game or load from a saved game.

12.  If the user would like to save the game, tap save.

13.  To exit the game, tap the back button.

# Functionalities Implemented

### Login/Register
-   Once the user clicks on the GameCenter App, he/she will be prompted to either register for a new
    account or login in with their pre-existing account. We have connected Firebase Database to our
    app to store the user’s email and password.

### Sliding Tiles Puzzle Game Updates
-  #### Game Complexity
    -   The user has the freedom to choose the size of the tiles board he/she would like to
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

	-   We have accounted for the three different board complexities when calculating the score by
	setting a “max” number of moves for each board size (50 for 3x3, 150 for 4x4, 250 for 5x5) and
	subtracting the number of moves take by the user from the “max” to generate the user’s score.


### Rankings Page

- We display the user scoreboard and game scoreboard. The user scoreboard shows the top five scores
  of the user for a specific game (in this case, Sliding Tiles) while the game scoreboard shows the
  top 5 scores of a specific game and the corresponding users that attained the scores.

- Both the user scoreboard and game scoreboard are updated after each game.