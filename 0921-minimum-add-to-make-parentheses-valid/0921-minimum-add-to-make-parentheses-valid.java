class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int add = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;       // match with an existing '('
                } else {
                    add++;        // need to add '('
                }
            }
        }
        return add + open;
    }
}