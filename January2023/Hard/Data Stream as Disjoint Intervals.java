/***************************************************************************************************************************************

-------------------
QUESTION NO-352
-------------------


Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.

Implement the SummaryRanges class:

SummaryRanges() Initializes the object with an empty stream.
void addNum(int value) Adds the integer value to the stream.
int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.



--------------------------------------------------------------------------------------------------

Example 1:

Input:-

["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]

Output:-

[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

Explanation

SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // return [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]

---------------------------------------------------------------------------------------------------



********************************************************************************************************************************************/

class SummaryRanges {
    // We will use a treeset data structure 
    // it will keep our numbers in sorted order
    private TreeSet<Integer> set;
    
    public SummaryRanges() {
        set = new TreeSet<>();  // initialise the treeset
    }
    
    public void addNum(int value) {
        set.add(value); // add the value to treeset
    }
    
    public int[][] getIntervals() {
        if (set.isEmpty()) {        // if set is empty
            return new int[0][];    // return empty array
        }

        // initialise an arraylist to store the intervals
        List<int[]> intervals = new ArrayList<>();
        // initialise the start and end values with the 
        // first element that is present in the set
        int start = set.first();
        int end = set.first();

        // we will iterate on the set, if its at number adjacent to 'end'
        // we will update 'end' until we encounter a disjoint number
        for (int v : set) {
            // simply skip the first element because
            // we ned to check from second element
            if (v == start) {   
                continue;       
            } 
            // if the number is +1 the 'end' (adjacent), we will update 'end'
            // say 'end' is 6, we encounter 7, so 6 & 7 are consecutive/adjacent
            // so 'end' is updated to 7
            else if (v == end + 1) {
                end = v;
            } 
            // when we find a disjoint case, say 'end' is 7 and we encounter 9
            // they are disjoint, so we push the interval obtained so far
            else {
                intervals.add(new int[] {start, end});  // pushing the interval
                start = end = v;    // we will start afresh from 9
            }
        }

        // at the end we will be left with an interval,
        // because we finished iterating on the treeset
        // so we will push that interval to the list
        intervals.add(new int[] {start, end});
        // return the list as a 2D array of intervals
        return intervals.toArray(new int[0][]);
    }
}
