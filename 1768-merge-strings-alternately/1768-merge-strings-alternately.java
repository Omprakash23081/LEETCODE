class Solution {
    public String mergeAlternately(String word1, String word2) {
    String newstr ="" ;
    int pos;
    if(word1.length()>word2.length()){
     pos = word1.length();
    }else{
       pos =  word2.length();
    }
    for(int i=0 ; i<pos ; i++){
        if(word1.length()>i){
           newstr = newstr + (word1.charAt(i)+"");
        }
       if(word2.length()>i){
            newstr = newstr + (word2.charAt(i)+"");  
        }
    }
    return newstr;
   }
}