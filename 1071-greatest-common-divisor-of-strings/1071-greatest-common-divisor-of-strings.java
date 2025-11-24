class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String strvalue="";
        int small =0;
        if(!(str1+str2).equals(str2+str1)){
            return strvalue ;
        }
        int a=str1.length();
        int b = str2.length();
    
        int temp =0 ;
        while(b!=0){
           temp = b ; 
           b = a%b;
           a=temp;
         }
        strvalue = str1.substring(0,temp);
        return strvalue;
    }
}