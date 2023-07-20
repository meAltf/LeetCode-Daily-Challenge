/******************************************************************************************************************************************************
--------------------
Level- MEdiuum
Question No-735
-------------------
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). 
Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. 
Two asteroids moving in the same direction will never meet.

___________________________________________________________________________________________________
 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int[] asteroidCollision(int[] in) {
        
        
        int head = 0;
        stack = in;
        while(head< in.length){
            if(isEmpty()){                
                push( in[head++]);
            }else{                
                if(peek()/Math.abs(peek()) != in[head]/Math.abs(in[head]) && peek() > in[head]){
                    if(Math.abs(peek()) > Math.abs(in[head])){
                        head++;
                    }else if(Math.abs(peek()) < Math.abs(in[head])){                        
                        pop();
                    }else{                        
                        head++;
                        pop();
                    }
                }else{                    
                    push( in[head++]);
                }
            }            
        }
        if(offset < 0)return new int[]{};
        return Arrays.copyOfRange(stack, 0, offset+1);
    }

    int[] stack;
    int offset = -1;
    void push(int val){
        stack[++offset] = val;
    }
    void pop(){
        if(isEmpty()){
            return;
        }
        offset--;
    }
    int peek(){
        return stack[offset];
    }
    boolean isEmpty(){
        return offset<0;
    }
}
