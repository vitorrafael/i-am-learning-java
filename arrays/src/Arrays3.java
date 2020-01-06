public class Arrays3 {
    public static void main(String[] args) {

        // Multi-dimensions arrays are like matrix
        // They can be declared using [][]
        // Each position 'n' references another array of 'm' positions
        int[][] days = new int[2][2];

        days[0][0] = 30;
        days[0][1] = 31;
        days[1][0] = 29;
        days[1][1] = 28;
        // Iterating through multi-dimension arrays takes two loops
        for(int i = 0; i < days.length; i++) {
            for(int j = 0; j < days[i].length; j++) {
                System.out.println(days[i][j]);
            }
        }

        // Foreach version
        for(int[] ref: days) {
            for(int dia : ref) {
                System.out.println(dia);
            }
        }
    }
}
