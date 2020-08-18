# Tic-Tac-Toe
Tic-tac-toe is a game played by two players on a 3x3 field.

One of the players plays as 'X', and the other player is 'O'. 'X' plays first, then the 'O' side plays, and so on.

The players write 'X' and 'O' on a 3x3 field.

The first player that writes 3 'X' or 3 'O' in a straight line (including diagonals) wins.

![code](https://github.com/Yury-Borovoy/Tic_Tac_Toe/blob/master/Screenshot_1.jpg)

This program reads 9 symbols from he standart input, analyzes them and writes an appropriate 3x3 field. Elements of the field contain only 'X', 'O' and '_' symbols.
After printing the field, the prorgam finds the state in which the game is at the moment. Possible states:
1. "Game not finished"  - when no side has a three in a row but the field has empty cells;
2. "Draw" - when no side has a three in a row and the field has no empty cells;
3. "X wins" - when the field has three X in a row;
4. "O wins" - when the field has three O in a row;
5. "Impossible" - when the field has three X in a row as well as three O in a row. Or the field has a lot more X's than O's or vice versa (if the difference is 2 or more, should be 1 or 0).

While playing this game, users alternately enter the coordinates of the place where they want to place their symbol. In turn, the program checks whether the coordinates are entered correctly and whether the space is free.

![code](https://github.com/Yury-Borovoy/Tic_Tac_Toe/blob/master/Screenshot_2.jpg)

![code](https://github.com/Yury-Borovoy/Tic_Tac_Toe/blob/master/Screenshot_3.jpg)

