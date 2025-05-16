public class Test {
    public int findNumber(int[] nums){
        int ans=-1;
        int n=nums.length,s=0,e=n-1,mid;
        while(s<=e){
            mid=(s+e)/2;
            int before=mid==0?Integer.MAX_VALUE:nums[mid-1];
            int after=mid==n-1?Integer.MAX_VALUE:nums[mid+1];
            if(nums[mid]!=before&&nums[mid]!=after){
                ans=nums[mid];break;
            }
            if((mid%2==0&&nums[mid]==nums[mid+1])||(mid%2==1&&nums[mid]==nums[mid-1])){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return ans;
    }
}
// 0 1 2 3 4 5 6

// 1 1 2 3 3