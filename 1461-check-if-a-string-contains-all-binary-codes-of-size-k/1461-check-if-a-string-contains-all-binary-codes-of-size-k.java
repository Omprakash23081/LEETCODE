class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        for(int i=0; i<=s.length()-k ; i++){
            String st = new String();
            for(int j = i ; j<i+k && j<s.length(); j++){
                st += s.charAt(j);
            }
            set.add(st);
        }
        System.out.println(set);
        return set.size() >= Math.pow(2 , k);
    }
}