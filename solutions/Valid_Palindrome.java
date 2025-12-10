class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String s1="";
        String rev="";
        for(int i=0;i<s.length();i++){
            if((s.charAt(i) >= 'a' && s.charAt(i) <='z') || (s.charAt(i) >= '0' && s.charAt(i) <='9')){
                s1+=s.charAt(i);
            }
        }
        for(int j=s1.length()-1;j>=0;j--){
            rev+=s1.charAt(j);
        }
        if(s1.equals(rev)){
            return true;
        }
        else{
            return false;
        }
    }
}