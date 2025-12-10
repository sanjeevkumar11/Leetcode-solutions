class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;

        while (i < j) {
            // move i forward until vowel
            while (i < j && !isVowel(str[i])) {
                i++;
            }
            // move j backward until vowel
            while (i < j && !isVowel(str[j])) {
                j--;
            }

            // swap vowels
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;

            i++;
            j--;
        }

        return new String(str); 
    }
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
    

    
