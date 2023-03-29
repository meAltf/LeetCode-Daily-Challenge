/******************************************************************************************************************************************************
--------------------------
Level- Medium
Question No-983
---------------------------
You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. 
Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.

--------------------------------------------------------------------------------------- 

Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total, you spent $11 and covered all the days of your travel.
Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total, you spent $17 and covered all the days of your travel.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

/**
 * @param {number[]} days
 * @param {number[]} costs
 * @return {number}
 */
var mincostTickets = function (days, costs) {
  // Create an array to store the minimum cost for each day of the year
  const minCosts = new Array(days[days.length - 1] + 1).fill(0);
  
  // Create a set of the days you will be traveling on for faster lookup
  const travelDays = new Set(days);
  
  // Loop through each day of the year, starting from day 1
  for (let day = 1; day < minCosts.length; day++) {
    // If you're not traveling on this day, the minimum cost is the same as the previous day
    if (!travelDays.has(day)) {
      minCosts[day] = minCosts[day - 1];
    } else {
      // If you're traveling on this day, calculate the minimum cost by comparing the costs
      // of buying a 1-day pass, a 7-day pass, or a 30-day pass on this day, and adding the
      // cost of the minimum cost of traveling up to 1, 7, or 30 days ago respectively
      minCosts[day] = Math.min(
        minCosts[day - 1] + costs[0],
        minCosts[Math.max(0, day - 7)] + costs[1],
        minCosts[Math.max(0, day - 30)] + costs[2]
      );
    }
  }
  
  // Return the minimum cost for traveling on all the given days
  return minCosts[minCosts.length - 1];
};
