class Solution {
    List<String> results;
    public List<String> generateParenthesis(int n) {

        results = new ArrayList<>();
        generate(n, 0, 0, "");
        return results;
    }
    
    void generate(int n, int currOpen, int currClose, String currS) {
        if (currOpen < n) {
            generate(n, currOpen + 1, currClose, currS + "(");
        }
        if (currClose < currOpen) {
            generate(n, currOpen, currClose + 1, currS + ")");
        }
        if (currOpen + currClose == n * 2) {
            results.add(currS);
        }
    }
}
