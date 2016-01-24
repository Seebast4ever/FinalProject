class RectButton {
  //location and width, length of rectangle
  int initx, inity, w, l;
  boolean isMouseOver = false;
  boolean isMouseClicked = false;

  RectButton(int initx, int inity, int w, int l, String message, int textSize) {
    this.initx = initx;
    this.inity = inity;
    this.w = w;
    this.l = l;
    isMouseOver = false;
    isMouseClicked = false;
    drawButton();
    addMessage(message, textSize);
  }

  RectButton(int initx, int inity, int w, int l) {
    this(initx, inity, w, l, "", 10);
  }

  void drawButton() { 
    fill(254);
    stroke(0);
    rect(initx, inity, w, l);
  }

  void addMessage(String message, int textSize) {
    textSize(textSize);
    fill(0);
    text(message, initx + 5, (inity+l + inity) / 2);
  }

  boolean updateMouseOver() {
    if (mouseX > initx && mouseX < (initx + w) &&
      mouseY > inity && mouseY < (inity + l)) {
      isMouseOver = true;
    } else {
      isMouseOver = false;
    }
    return isMouseOver;
  }

  boolean mousePressed() {
    updateMouseOver();
    if (isMouseOver) {
      isMouseClicked = true;
    } else {
      isMouseClicked = false;
    }
    System.out.println(isMouseOver);
    return isMouseClicked;
  }
}