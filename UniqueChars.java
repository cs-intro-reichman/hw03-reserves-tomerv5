/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        // Replace the following statement with your code
        String newStr = "" + s.charAt(0); 
        Boolean exist = false;  //hello
        for(int i = 1; i < s.length(); i++) {
            for (int j = 0; j < newStr.length(); j++) {
                if (s.charAt(i) == newStr.charAt(j) && s.charAt(i) != ' ') {
                    exist = true;
                    break;
                }
                
            }
            if (!exist) newStr += s.charAt(i);
                exist = false;
        }
        return newStr;
    }
}