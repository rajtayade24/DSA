public class L4PalindromeCheck {

    // Recursive function to check palindrome
    static boolean isPalindrome(String str, int left, int right) {
        if (left >= right) return true; // base case
        if (str.charAt(left) != str.charAt(right)) return false;
        return isPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String str = "aaabbbaa";

        if (isPalindrome(str, 0, str.length() - 1)) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }
}
