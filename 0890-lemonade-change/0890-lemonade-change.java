class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0 ; 
        int ten = 0;
        for(int i =0 ; i<bills.length ; i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]== 10 ){
                five--;
                ten++;
            }
            else if(bills[i]==20){
                five--;
                ten--;
                if(ten<0 && five>=2) {
                    ten++;
                    five -= 2;
                }
            }
            if(five<0 || ten<0) return false;
        }
        return true;
    }
}