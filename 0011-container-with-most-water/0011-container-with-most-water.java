class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j = height.length-1;
        int result = 0;


/*first Aprotch*/

        // for (int i = 1; i < height.length; i++) {
            
        //     if(height[i]>height[j]){
        //        result = height[j] * (i - j); 
        //        j=i; 
        //     }

        //     else if (height[i] * (i - j) > result) {
        //         result = height[i] * (i - j);
        //     }
        // }


/*Second Aprotch */        
    //    while(i!=j){
    //        if((height[i]>=height[j])){
    //           if((height[j] * (j - i) > result)){
    //                result = height[j] * (j - i); 
    //            }
    //            j--;
    //         }

    //         else if (height[i] * (j - i) > result) {
    //             result = height[i] * (j - i);
    //             i++;
    //         }
    //     }

/*third Aprotch */    

       for (int k=0 ; k<height.length ; k++){
          if(i==j){
            break;
          }
         if((height[i]>=height[j])){
            if((height[j] * (j - i) > result)){
                   result = height[j] * (j - i); 
             }
               j--;
            }

         else if (height[i] * (j - i) >= result) {
                result = height[i] * (j - i);
                i++;
           }else{
            i++;
           }
       }


        return result ;  
    }
}