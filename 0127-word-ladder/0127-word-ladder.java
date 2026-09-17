class Solution {
    class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<Pair>();
        Set<String> st = new HashSet<>(wordList);
        q.add(new Pair(beginWord, 1));
        st.remove(beginWord);

        while(q.size() > 0) {
            Pair top = q.remove();
            String word = top.word;
            int step = top.steps;
            if(word.equals(endWord))
                return step;

            for(int i = 0; i < word.length(); i++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    char[] replacedChar = word.toCharArray();
                    replacedChar[i] = c;
                    String replaced = new String(replacedChar);
                    if(st.contains(replaced)) {
                        st.remove(replaced);

                        q.add(new Pair(replaced, step + 1));
                    }
                }
            }
        }
        return 0;
    }
}