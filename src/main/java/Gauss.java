public class Gauss {
    private static final double eps = 0.00000001;
    private static Matrix matrix;

    public static void solve(Matrix m) {
        matrix = m;
        for (int i = 0; i < Math.min(matrix.rows, matrix.columns); ++i) {
            findFirstNotZero(i);
            normalizeRow(i, i);
            excludeVarFromColumn(i,i);
        }
    }

    private static void findFirstNotZero(int i) {
        if (Double.compare(matrix.get(i, i), 0) == 0) {
            for (int j = i + 1; j < matrix.rows; ++j) {
                if (Double.compare(matrix.get(j, i), 0) != 0) {
                    matrix.swapRows(j, i);
                    break;
                }
            }
        }
    }

    private static void normalizeRow(int row, int column) {
        double coef = 1 / matrix.get(row, column);
        matrix.multiplyRow(row, coef);
    }

    private static void excludeVarFromColumn(int row, int column) {
        for (int i = 0; i < matrix.rows; ++i) {
            if (i == row) continue;
            double coef = -matrix.get(i, column) / matrix.get(row, column);
            matrix.addRowtoRow(i, row, coef);
        }
    }
//    private static boolean (double number, double target){
//        return number < target+eps && number >target - eps;
//    }
}
