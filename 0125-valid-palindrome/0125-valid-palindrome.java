class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (!isAlphaNumeric(c1)) {
                left++;
                continue;
            }
            if (!isAlphaNumeric(c2)) {
                right--;
                continue;
            }
            if (c1 >= 'A' && c1 <= 'Z')
                c1 += 32;
            if (c2 >= 'A' && c2 <= 'Z')
                c2 += 32;

            if (c1 != c2)
                return false;

            left++;
            right--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        int i = c;
        return (i >= 65 && i <= 90) || (i >= 97 && i <= 122) || (i >= 48 && i <= 57);
    }
}

//  StringBuilder st = new StringBuilder();
//         for (int j = 0; j < s.length(); j++) {
//             int i = s.charAt(j);
//             if ((i > 64 && i < 91) || (i > 96 && i < 123) || (i > 47 && i < 56)) {
//                 st.append(s.charAt(j));
//             }
//         }
//         int left = 0;
//         int right = st.length()-1;
//         while (left < right) {
//             int v1 = st.charAt(left++);
//             int v2 = st.charAt(right--);
//             if (v1 > 64 && v1 < 91) {
//                 v1 = v1 + 32;
//             }
//             if (v2 > 64 && v2 < 91) {
//                 v2 = v2 + 32;
//             }
//             if (v1 != v2)
//                 return false;
//         }
//         return true;