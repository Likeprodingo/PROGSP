package by.shibaev.task4.javafx;

public class Point {
    private int x;
    private int y;

    public Point(String x, String y) throws NumberFormatException{
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Point{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
