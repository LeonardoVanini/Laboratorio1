public class Utility {
    static boolean verify (int[] a, int[] b){
        if (a.length == b.length){
            boolean uguale = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]){
                    uguale = false;
                }
            }
            return uguale;
        }else {
            return false;
        }
    }
}
