package gameoflife;

public class TestProgram {

    public static void main(String[] args) {

        Matrix matrix = new Matrix(8, 8);
        System.out.println("Printing empty matrix...");
        matrix.print();

        System.out.println("setting 5 live cells and printing...");
        matrix.setLivingCell(1, 2);
        matrix.setLivingCell(1, 3);
        matrix.setLivingCell(1, 4);
        matrix.setLivingCell(2, 2);
        matrix.setLivingCell(2, 4);
        matrix.print();

        System.out.println("Rebuilding matrix. One cell should die and another should come to life...");
        matrix.buildNextGenMatrix();
        matrix.print();
    }
}
