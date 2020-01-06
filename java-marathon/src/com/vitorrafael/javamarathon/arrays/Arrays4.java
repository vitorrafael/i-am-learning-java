public class Arrays4 {
    public static void main(String[] args) {
        int[][] days = new int[3][];

        // The inner arrays can have different sizes
        days[0] = new int[2];
        days[1] = new int[]{1, 2, 3};
        days[2] = new int[4];

        for(int[] arr : days) {
            for(int num : arr) {
                System.out.println(num);
            }
        }

        // It's possible to declare an multi-dimensional array like this
        int[][] matrix = {{0, 0}, {1, 2, 3}, {0, 0, 0, 0}};
        for(int[] arr: matrix) {
            for(int num : arr) {
                System.out.println(num);
            }
        }
    }
}
