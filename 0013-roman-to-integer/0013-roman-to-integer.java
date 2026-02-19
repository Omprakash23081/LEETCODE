class Solution {
    public int romanToInt(String s) {
        Map<Character , Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()) map.put(ch , map.getOrDefault(ch , 0)+1);

        int res = 0;

        for(int i =0 ; i<s.length()-1 ; i++){
            if(s.charAt(i)=='I'){
                if(s.charAt(i+1)=='V'){
                    res += 4;
                    map.put('I' , map.get('I')-1);
                    map.put('V' , map.get('V')-1);
                }
                if(s.charAt(i+1)=='X'){
                    res += 9;
                    map.put('I' , map.get('I')-1);
                    map.put('X' , map.get('X')-1);
                }
            }
            else if(s.charAt(i)=='X'){
               if(s.charAt(i+1)=='L'){
                    res += 40;
                    map.put('X' , map.get('X')-1);
                    map.put('L' , map.get('L')-1);
                }
                if(s.charAt(i+1)=='C'){
                    res += 90;
                    map.put('X' , map.get('X')-1);
                    map.put('C' , map.get('C')-1);
                }
            }
            else if(s.charAt(i)=='C'){
                if(s.charAt(i+1)=='D'){
                    res += 400;
                    map.put('C' , map.get('C')-1);
                    map.put('D' , map.get('D')-1);
                }
                if(s.charAt(i+1)=='M'){
                    res += 900;
                    map.put('C' , map.get('C')-1); 
                    map.put('M' , map.get('M')-1);
                }   
            }
        }
        
        for(char ch : map.keySet()){
            if(ch=='I') res += map.get(ch);
            if(ch=='V') res += map.get(ch)*5;
            if(ch=='X') res += map.get(ch)*10;
            if(ch=='L') res += map.get(ch)*50;
            if(ch=='C') res += map.get(ch)*100;
            if(ch=='D') res += map.get(ch)*500;
            if(ch=='M') res += map.get(ch)*1000;
        }

        return res;
    }
}