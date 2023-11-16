/**
 * 올바른 괄호
 */
class Q12909 {
    public static void main(String[]args) {
        // 문제
        String s = "()()";
        // 결과
        int stack = 0;
        boolean answer = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack += 1;
            } else if (c == ')') {
                stack -= 1;
                if (stack < 0) {
                    answer = false;
                    break;
                }
            }
        }
        if (stack != 0) {
            answer = false;
        }
        System.out.println("answer = " +answer);
    }
}