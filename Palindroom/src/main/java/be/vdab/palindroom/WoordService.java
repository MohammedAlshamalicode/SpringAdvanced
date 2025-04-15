package be.vdab.palindroom;

public class WoordService {
    boolean isPalindrome(String word) {
        return new StringBuilder(word).reverse().toString().equals(word);
    }
}
