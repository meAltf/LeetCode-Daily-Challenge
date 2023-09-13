/******************************************************************************************************************************************************
----------------------
Level- Hard
Question No- 135
--------------------
___________________________________________________________________________________________________ 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int candy(int[] ratings) {
        int sum=0;
        int[] a=new int[ratings.length];
        for(int i=0;i<a.length;i++)
        {
            a[i]=1;
        }
        for(int i=0;i<ratings.length-1;i++)
        {
            if(ratings[i+1]>ratings[i])
            {
                a[i+1]=a[i]+1;
            }
        }
        for(int i=ratings.length-1;i>0;i--)
        {
            if(ratings[i-1]>ratings[i])
            {
                if(a[i-1]<(a[i]+1))
                {
                    a[i-1]=a[i]+1;
                }
            }
        }
        for(int i=0;i<a.length;i++)
        {
            sum+=a[i];
        }
        return sum;
    }
}
