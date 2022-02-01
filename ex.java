public class ex {
    public static void main(String[] args){
        String[] exams = {"1;2;3;4;", "5;6;7;8;", "9;10;11;12;"};
        double[][] examArray = new double[exams.length][4];
        examArray = convert(exams, exams.length, 0, examArray);
    }

    public static double[][] convert(String[] exams, int n, int i, double[][] ret){
        if(i == n - 1){
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
    
}
