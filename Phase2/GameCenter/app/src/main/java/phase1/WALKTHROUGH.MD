Presentation Walkthrough 1. Unit test coverage: \* The unit tests that
have 0% coverage are either model or view classes. Since these do not
have any meaningful logic, they were omitted from testing. Generally the
classes that have 0% coverage will have corresponding classes that have
100% coverage, which are classes that act as controllers.

1.  What are the most important classes in your program?
2.  General classes:
    1.  FileManager - manages all file input and outputs.
    2.  LeaderBoardActivity and UserScoreBoardActivity: Views the scores
        saved in firebase.
    3.  Login, and Register activity classes.

3.  Game specific classes:
    1.  MatchedGameActivity, SlidingTilesGameActivity and the various
        Connect Numbers Game activities - Shows the current state of the
        game. Passes on information to their own boardmanger classes
        which updates the game state.
    2.  SlidingTileBoardManager and MatchedBoardManager - Keeps track of
        game state.

4.  What design patterns did you use? What problems do each of them
    solve?
5.  Factory pattern with generics
    1.  Helped sort our classes by their functions
    2.  Cleaned our codes by extending interfaces in the parent
        interfaces, which made the children classes code cleaner and
        easier to keep track of.
    3.  Reduced our use of repeated codes by creating generic functions

6.  Iterator Pattern
    1.  Helped us access elements to create boards

7.  Observer Pattern
    1.  Helped us keep track of game activities during the game

8.  Adapter Pattern?
    1.  Helped us adapt tile sizes according to the game complexity,
        which saved time and reduced inelegant code use.

9.  How did you design your scoreboard? Where are high scores stored?
    How do they get displayed?

-   There are two different scoreboards which are both on the main game
    centre page: the individual user’s scoreboard and the leaderboards.
    Each scoreboard displays the top 5 scores.
-   The scoreboards are all updated to firebase and saved automatically
    when a game is complete.
-   They are displayed in an activity, when the user goes to the
    scoreboard or leaderboard page a tabbed view of a scoreboard is
    populated with scores fetched from firebase. Login/sign out:
-   We implemented user authentication using firebase. When a user
    enters our app, the first thing they will see is the sign in page.
    If they don’t have an account, they can click the button at the
    button to create a new account, which will be saved onto firebase.
    The user’s information is stored externally so they are able to
    login from any phone.\
-   Even after a user exits the app, the firebase auth will recognize
    them and they will remain logged in.
-   After a user logins in, they will be directed to the game centre
    main page. To log out, they will need to click the options button in
    the top left corner, then click the logout button.

