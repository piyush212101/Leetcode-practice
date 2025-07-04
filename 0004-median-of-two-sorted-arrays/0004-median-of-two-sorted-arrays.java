class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
        return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int l=0, h=n1;

        while(l <= h) {
            int m1 = (l+h)/2;
            int m2 = (n1+n2+1)/2 - m1;

            int l1 = (m1 == 0 ? Integer.MIN_VALUE : nums1[m1-1]);
            int l2 = (m2 == 0 ? Integer.MIN_VALUE : nums2[m2-1]);
            int r1 = (m1 == n1 ? Integer.MAX_VALUE : nums1[m1]);
            int r2 = (m2 == n2 ? Integer.MAX_VALUE : nums2[m2]);

            if(l1 <= r2 && l2 <= r1) {
                if((n1+n2)%2 == 1)
                return Math.max(l1, l2);
                else
                return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
            } else if(l1 > r2) {
                h = m1-1;
            } else if(l2 > r1) {
                l = m1+1;
            }
        }
        return -1.0;
    }
}