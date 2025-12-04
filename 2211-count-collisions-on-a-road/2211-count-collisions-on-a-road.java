class Solution {
    public int countCollisions(String directions) {
        int count = 0;
        int n = directions.length();
        int i =0 , j=0;
        for(i =0 ; i<n ; i++){
            if(directions.charAt(i)=='L')count++;
            else break;
        }
        for(j =n-1 ; j>=0 ; j--){
            if(directions.charAt(j)=='R')count++;
            else break;
        }
        for(int k = 0; k<n ; k++){
            if(directions.charAt(k)=='S')count++;
        }
        return n-count;
    }
}