class Solution {
    public int maxArea(int[] height) {
        int n = height.length, start = 0, end = n-1;
        int maxm = Integer.MIN_VALUE;
        int ht, len , area;
        
        while (start < end)
        {
            len = end - start;
            ht = Math.min (height[start], height[end]);
            area = len * ht;
            maxm = Math.max (area, maxm);
            
            if (height[end]<height[start])
                end--;
            else
                start++;
        }
        return maxm;
    }
}