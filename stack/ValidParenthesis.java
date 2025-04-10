import java.util.Stack;

class Solution {
    public static boolean isValid(String s) {
        Stack<String> parens = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String currChar = String.valueOf(s.charAt(i));
            if ("([{".contains(currChar)) {
                parens.add(currChar);
                continue;
            }
            if (currChar.equals(")")) {
                if (parens.isEmpty()) {
                    return false;
                }
                if (!"(".equals(parens.pop())) {
                    return false;
                }
            } else if (currChar.equals("]")) {
                if (parens.isEmpty()) {
                    return false;
                }
                if (!"[".equals(parens.pop())) {
                    return false;
                }
            } else if (currChar.equals("}")) {
                if (parens.isEmpty()) {
                    return false;
                }
                if (!"{".equals(parens.pop())) {
                    return false;
                }
            }
        }
        if (!parens.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
