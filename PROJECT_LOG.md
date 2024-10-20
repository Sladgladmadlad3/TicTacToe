# Project Development Log for Tic-Tac-Toe

## Overview
Tic-Tac-Toe project that I built to get better with problem-solving,Inheritance and Polymorphism. 
As of now the project can take in user input, and run an algorithm that mimics AI.

### Current Version: v0.1

**Date**: 2024-10-18

## 1. Classes Overview
**GameBoard**: Manages the 2D array and board display.

**tictactoeAI**: Implements AI logic at different difficulity levels. *More levels to come.

**GameStatus**: Tracks wins, losses and draws.

**Main**: Runs the game loop and handles user input.

## 2. Issue Tracker & Solutions
**Issue**: AI overwrote exisitng pieces on the board.

**Date Identified**: 2024-10-18

**Solution**: Implemented an array to track available positions and added a check to ensure AI seslects only open spots.

**Related Commit**: `Logic is now implemented in the easyDifficulity method`

## 3. Next Steps / TODO List
- Implement Medium AI logic using some heuristics
- Implement Hard AI logic using minimax and Alpha-Beta Pruning
- Improve code readability and simplicity

## 5. Personal Reflections
- I'm feeling more comfortable with encapsulation
- I am able to look back on some methods and see ways that I can improve it.
Still struggling with overthinking but I am learning to take it slow and steady

**Date**: October 19,2024
- 