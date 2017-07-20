/* 2 Sum */
/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up 
 * to the target, where index1 < index2. Please note that your returned answers 
 * (both index1 and index2 ) are not zero-based. 
 * Put both these numbers in order in an array and return the array from your function 
 * ( Looking at the function signature will make things clearer ). 
 * Note that, if no pair exists, return empty list.
 *
 * If multiple solutions exist, output the one where index2 is minimum. If there are multiple 
 * solutions with the minimum index2, choose the one with minimum index1 out of them.
 */

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] twoSum(final int[] A, int B) {
        int[] indices = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<A.length; i++) {
            int compliment = B - A[i];

            if (map.containsKey(compliment)) {
                int one = map.get(compliment);
                int two = i + 1;

                if (one < two) {
                    indices[0] = one;
                    indices[1] = two;
                }
                else {
                    indices[0] = two;
                    indices[1] = one;
                }

                break;
            }
            else if (!map.containsKey(A[i])){
                map.put(A[i], i+1);
            }
        }

        // return empty list
        if (indices[0] == 0 && indices[1] == 0) {
            int[] empty = {};
            return empty;
        }

        return indices;
    }
}

