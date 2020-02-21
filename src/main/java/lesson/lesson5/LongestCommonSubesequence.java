package lesson.lesson5;
/*
*
* GGCACCACG
* ACGGCGGATACG
*
* ---GGC--ACCACG
* AC-GGCGGAT-ACG
*
* GGCAACG
*
* ABCD
* ACDE
*
* lcs(ABCD, ACDE) = A + lcs(BCD, CDE);
* lcs(BCD, CDE) = max( lcs(CD, CDE) lcs(BCD, DE) );
* */
public class LongestCommonSubesequence {

    public static StringBuilder recursive(String str1, String str2){
        StringBuilder sb = new StringBuilder();
        if (str1.isEmpty() || str2.isEmpty()){
            return sb;
        }
        if (str1.charAt(0)  == str2.charAt(0)){
            sb.append(str1.charAt(0));
           return sb.append(recursive(str1.substring(1), str2.substring(1)));
        }
        StringBuilder first = recursive(str1.substring(1),str2);
        StringBuilder second = recursive(str1,str2.substring(1));

        return sb.append(first.length() > second.length() ? first : second);
    }

    public static void main(String[] args) {
        System.out.println(recursive("GGCACCACG","ACGGCGGATACG"));
    }

}
