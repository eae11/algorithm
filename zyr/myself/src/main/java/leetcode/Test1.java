package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*1. 【作图题】给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：
1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。

注意空字符串可被认为是有效字符串。
() true
()[]{} true
(] false
([)] false
{[]} true

*/
public class Test1 {
    public boolean isValid(String s) {
        if (s == null) return true;
        // 代码优化：如果字符串的长度为奇数的话，那么肯定不是合法的
        if (s.length() % 2 == 1) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                char matched = '#';
                if (c == ')') {
                    matched = '(';
                } else if (c == ']') {
                    matched = '[';
                } else {
                    matched = '{';
                }
                if (matched != pop) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
