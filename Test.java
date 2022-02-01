public class Test {
public static void main(String[] args){
    // System.out.println(hasAz("Zero"));

    
    // double[] catLimits = {80000,64000,32000,16000,8000};
    // String[] categories = {"HC", "CAT 1", "CAT 2", "CAT 3", "CAT 4"};

    // System.out.println(getCategory(99999, catLimits, categories));
    // System.out.println(getCategory(65000, catLimits, categories));
    // System.out.println(getCategory(33000, catLimits, categories));
    // System.out.println(getCategory(17000, catLimits, categories));
    // System.out.println(getCategory(9000, catLimits, categories));
    // System.out.println(getCategory(1, catLimits, categories));


    String[] exams = {"1;2;3;4;", "5;6;7;8;", "9;10;11;12;"};
    double[][] examArray = new double[exams.length][4];
    examArray = convert(exams, exams.length, 0, examArray);

}

// public static String getCategory(double points, double[] limits, String[] cats){
//     for(int i = 0; i < limits.length; i++){
//         if(i == 0 && points > limits[i]){
//             return cats[i];
//         }

//         else if(i == limits.length - 1){
//             return "Not Categorized";

//         }

//         else{
//             if(limits[i] > points && limits[i + 1] < points){
//                 return cats[i + 1];
//             }
//         }
//     }

//     return "";
// }

public static double[][] convert(String[] exams, int n, int i, double[][] ret){
    if(i == n){
        return ret;
    }

    else{
        String scoresExtra = exams[i].substring(0, exams[0].length() - 1);
        String[] scores = scoresExtra.split(";");

        for(int j = 0; j < 4; j++){
            ret[i][j] = Double.parseDouble(scores[j]);
        }
    }

    return convert(exams, n, i++, ret);
}



// public String hasAz(String s){
//     if(s.contains("z")){
//         String reverse = "";
//         for(int i = s.length() - 1; i > -1; i--){
//             reverse += s.charAt(i);
//         }

//         return reverse;
//     }

//     return s;
// }
// }

}
