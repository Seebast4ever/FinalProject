class Coordinate {
  private int x, y;
  private boolean hasSettlement;
  private boolean hasCity;

  Coordinate() {
    x = 0;
    y = 0;
    hasSettlement = false;
    hasCity = false;
  }

  Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int getX() {
    return x;
  }
  int getY() {
    return y;
  }
  boolean hasCity() {
    return hasCity;
  }
  boolean hasSettlement() {
    return hasSettlement;
  }

  void setX(int x) {
    this.x = x;
  }
  void setY(int y) {
    this.y = y;
  }
  void setXY(int x, int y) {
    this.x = x; 
    this.y = y;
  }
  void setSettlement(boolean b) {
    hasSettlement = b;
  }
  void setCity(boolean b) {
    hasCity = b;
  }

  void printCor() {
    System.out.println("["+x+", "+y+"]");
  }

  boolean isClose(int mousex, int mousey, int offset) {
    //looks to see if mouse is within a circle of radius offset (using pythagorean theorem)
    return (x - mousex) * (x - mousex) + (y - mousey) * (y - mousey) < offset * offset;
  }
}