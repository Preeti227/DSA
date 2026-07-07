class Solution {
    public String toLowerCase(String s) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c = (char)(c + 32);
            }
            ans.append(c);
        }
        return ans.toString();
    }
}