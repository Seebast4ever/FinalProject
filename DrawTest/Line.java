public class Line {
    private Coordinate c1;
    private Coordinate c2;

    public Line(Coordinate c1, Coordinate c2) {
	this.c1 = c1;
	this.c2 = c2;
    }

    public Line(int x1, int y1, int x2, int y2) {
	c1.setXY(x1, y1);
	c2.setXY(x2, y2);		
    }
}
