/******************************************************************************************************************************************************
----------------------
Level- Medium
Question no- 1376
----------------------
A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. 
Also, it is guaranteed that the subordination relationships have a tree structure.

The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, 
and so on until all employees know about the urgent news.

The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).

Return the number of minutes needed to inform all the employees about the urgent news.

___________________________________________________________________________________________________
 

Example 1:

Input: n = 1, headID = 0, manager = [-1], informTime = [0]
Output: 0
Explanation: The head of the company is the only employee in the company.

Example 2:


Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
Output: 1
Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute to inform them all.
The tree structure of the employees in the company is shown.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Create a list of employees to represent the tree structure
        List<List<Integer>> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            employees.add(new ArrayList<>());
        }

        // Build the tree structure using the manager array
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                employees.get(manager[i]).add(i);
            }
        }

        // Call the recursive helper function to calculate the time needed for each employee
        return informSubordinates(headID, employees, informTime);
    }
    private int informSubordinates(int currentEmployee, List<List<Integer>> employees, int[] informTime) {
        int maxTime = 0;

        // Iterate over the subordinates of the current employee
        for (int subordinate : employees.get(currentEmployee)) {
            // Calculate the time needed to inform the subordinate and recursively inform its subordinates
            int time = informSubordinates(subordinate, employees, informTime);
            maxTime = Math.max(maxTime, time);
        }

        // Return the total time needed for the current employee and its subordinates
        return maxTime + informTime[currentEmployee];
    }
}
