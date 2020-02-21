package lesson.lesson5;

/*
* abcd
*
* a bcd
* a bdc
* a cbd
* a cdb
* a dbc
* a dcb
* */

public class Anagram {

    public static void getAllAnagram(String str){
        getAllAnagram("",str);
    }

    private static void getAllAnagram(String pref, String str){
        if (str.isEmpty()){
            System.out.println(pref);
        }else {
            for (int i = 0; i < str.length(); i++) {
                getAllAnagram(pref + str.charAt(i),str.substring(0,i) + str.substring(i+1));
            }
        }
    }

    public static void main(String[] args) {
        getAllAnagram("abcd");
    }
}
