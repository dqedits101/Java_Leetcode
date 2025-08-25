class Solution {
    int operation(int num1, int num2, String operand) {
        return switch(operand) {
            case "+" -> num1+num2;
            case "-" -> num1-num2;
            case "*" -> num1*num2;
            default -> 0;
        };
    }
    Set<String> operands = new HashSet<>(Set.of("+","-","*"));
    // [2, *, 3, -, 4, *, 5]
    List<Integer> recur(String[] arr, int start, int end) {
        if(start == end)
            return new ArrayList<>(List.of(Integer.valueOf(arr[start])));
        
        List<Integer> results = new ArrayList<>();
        for(int i=start;i<=end;i++) {
            // split expression arr[start,end] at operator arr[i] into arr[start,i-1] and arr[i+1,end]
            // and perform operation arr[i] on all values obtained from leftSplit with all values obtained from rightSplit
            if(operands.contains(arr[i])) {
                List<Integer> leftSplit = recur(arr, start, i-1);
                List<Integer> rightSplit = recur(arr, i+1, end);
                for(Integer leftNum : leftSplit) {
                    for(Integer rightNum : rightSplit)
                        results.add(operation(leftNum, rightNum, arr[i]));
                }
            }
        }
        return results;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        String[] arr = new String[20];
        int len = expression.length(), idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++) {
            char ch = expression.charAt(i);
            if(Character.isDigit(ch))
                sb.append(ch);
            
            else {
                arr[idx++] = sb.toString();
                arr[idx++] = ""+ch;
                sb = new StringBuilder();
            }
        }
        arr[idx++] = sb.toString();
        // System.out.println(Arrays.toString(arr));
        return recur(arr,0,idx-1);
    }
}
