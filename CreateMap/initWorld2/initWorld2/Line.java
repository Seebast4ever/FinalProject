class Line {
  private Coordinate c1;
  private Coordinate c2;
  private boolean hasRoad;

  Line(Coordinate c1, Coordinate c2) {
    this.c1 = c1;
    this.c2 = c2;
    hasRoad = false;
  }

  Line(int x1, int y1, int x2, int y2) {
    c1.setXY(x1, y1);
    c2.setXY(x2, y2);
    hasRoad = false;
  }

  Coordinate getC1() {
    return c1;
  }

  Coordinate getC2() {
    return c2;
  }

  int getX1() {
    return c1.getX();
  }
  int getX2() {
    return c2.getX();
  }
  int getY1() {
    return c1.getY();
  }
  int getY2() {
    return c2.getY();
  }

  int getSlope() {
    if (getX2() - getX1() == 0) {
      return 0;
    } else {
      return (getY2() - getY1()) / (getX2() - getX1());
    }
  }

  public String seeLine() {
    return "("+getX1()+", "+getY1()+") - ("+getX2()+", "+getY2()+")";
  }

  boolean hasRoad() {
    return hasRoad;
  }

  void setHasRoad(boolean b) {
    hasRoad = b;
  }

//sees if the middle coordinate of the line is close to the mouse click
  boolean isClose(int mousex, int mousey, int offset) {
    //finds the middle coordinate of the road
    int x = c1.getX() + c2.getX();
    int y = c1.getY() + c2.getY();
    Coordinate c = new Coordinate(x / 2, y / 2); 
    return c.isClose(mousex, mousey, offset + 3);
  }
}