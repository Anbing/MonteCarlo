# Monte Carlo Simulation
## This program aims to use forward looking Monte Carlo Simulation to predict investment return over time given initial investment, two types portfolio: aggressive and conservative as well as corresponding return rate and risk.
This is a statistical technique that uses pseudo-random uniform variables for a given statistical distribution based on past risk (SD) and return (mean) to predict outcomes over future time periods. Based on iterative evaluation of each random future value, we project the portfolio future value over 20 years. We would like to run 10,000 simulations of projecting 20 year value and come up with the following:
Assumptions
1. We would like to use a random number generator to ensure Gaussian distribution of random numbers that are generated.
2. 20th Year future value should be inflation adjusted at the rate of 3.5% each year. Ie. Year 1 value of 103.5 is equivalent to 100 at Year 0.

## How to use it?
build and run Portfolio.java

## Program description
- Portfolio.java
is responsible for creating Portfolio object and corresponding fields and actions.
- MonteCarloSimulator.java
plays key driver including initialization, inner class (i.e SimulationType) creation and running simulation for prediction.
- MonteCarloSimulatorTest.java
is unit test class.

## Unit test
The program provided three unit test cases for different initial investment, return rate and risk to give a comparison. It's easy to put more cases.
