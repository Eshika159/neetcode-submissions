class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()){
            return -1;
        }
        int cur = 0 , res = 0;
        //we dont need to do circular we just need the starting point and valid arr
        for(int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            if(cur < 0) {
                cur = 0;
                res = i + 1;
            }
        }
        return res;
    }
}
