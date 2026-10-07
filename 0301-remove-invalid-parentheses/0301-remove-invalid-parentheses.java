class Solution {

    public List<String> removeInvalidParentheses(String s) {

        Set<String> result = new HashSet<>();

        int leftRemove = 0;
        int rightRemove = 0;

        // Find minimum number of removals
        for (char c : s.toCharArray()) {

            if (c == '(') {
                leftRemove++;
            }

            else if (c == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }

        dfs(s, 0, leftRemove, rightRemove,
            0, new StringBuilder(), result);

        return new ArrayList<>(result);
    }


    private void dfs(String s,
                     int index,
                     int leftRemove,
                     int rightRemove,
                     int balance,
                     StringBuilder path,
                     Set<String> result) {

        // Invalid
        if (balance < 0) {
            return;
        }

        // End
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                result.add(path.toString());
            }

            return;
        }

        char c = s.charAt(index);

        // '('
        if (c == '(') {

            // Remove '('
            if (leftRemove > 0) {

                dfs(s,
                    index + 1,
                    leftRemove - 1,
                    rightRemove,
                    balance,
                    path,
                    result);
            }

            // Keep '('
            path.append(c);

            dfs(s,
                index + 1,
                leftRemove,
                rightRemove,
                balance + 1,
                path,
                result);

            path.deleteCharAt(path.length() - 1);
        }

        // ')'
        else if (c == ')') {

            // Remove ')'
            if (rightRemove > 0) {

                dfs(s,
                    index + 1,
                    leftRemove,
                    rightRemove - 1,
                    balance,
                    path,
                    result);
            }

            // Keep ')'
            if (balance > 0) {

                path.append(c);

                dfs(s,
                    index + 1,
                    leftRemove,
                    rightRemove,
                    balance - 1,
                    path,
                    result);

                path.deleteCharAt(path.length() - 1);
            }
        }

        // Normal character
        else {

            path.append(c);

            dfs(s,
                index + 1,
                leftRemove,
                rightRemove,
                balance,
                path,
                result);

            path.deleteCharAt(path.length() - 1);
        }
    }
}