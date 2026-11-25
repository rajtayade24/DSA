public class CharFrequency {
    public static void main(String[] args) {
        String str = "rajnarayantayade";
        int n = 26; // for lowercase a–z

        int[] hash = new int[n];

        // count frequencies
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                hash[c - 'a']++;
            }
        }

        // print frequencies
        for (int i = 0; i < n; i++) {
            System.out.print(hash[i] + " ");
        }
    }
}
