package com.mushuichuan;

public class Algorithm227 {
	public void test(){
		System.out.println(calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
	}
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int sumValue = 0;
		int pre = 0, cur = 0;
		char sign = '+';
		int i = 0;
		while (i < s.length()) {
			cur = 0;
			while (i < s.length() && ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == ' ')) {
				if (s.charAt(i) == ' ') {
					i++;
					continue;
				}
				// is number
				cur = cur * 10 + (s.charAt(i) - '0');
				i++;
			}
//			System.out.println(cur);
			if (sign == '+') {
				sumValue += pre;
				pre = cur;
			} else if (sign == '-') {
				sumValue += pre;
				pre = -cur;
			} else if (sign == '*') {
				pre = pre * cur;
			} else if (sign == '/') {
				pre = pre / cur;
			}
			if (i < s.length()) {
				sign = s.charAt(i);
				i++;
			}

		}
		return sumValue + pre;
	}
}
