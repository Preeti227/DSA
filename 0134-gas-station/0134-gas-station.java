class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int currentGas=0;
        int total=0;
        for(int i=0;i<gas.length;i++){
            int diff=gas[i]-cost[i];
            total+=diff;
            currentGas+=diff;
            if(currentGas<0){
                start=i+1;
                currentGas=0;
            }
        }
        if(total<0){
            return -1;
        }
        return start;
    }
}