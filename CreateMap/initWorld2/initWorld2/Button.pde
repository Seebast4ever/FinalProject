class RectButton {
  //location and width, length of rectangle
  int initx, inity, w, l;
  boolean isMouseOver;
  boolean isMouseClicked;

  RectButton(int initx, int inity, int w, int l, String message, int textSize) {
    this.initx = initx;
    this.inity = inity;
    this.w = w;
    this.l = l;
    drawButton();
    addMessage(message, textSize);
  }

  RectButton(int initx, int inity, int w, int l) {
    this(initx, inity, w, l, "", 15);
  }

  void drawButton() {
    fill(255);
    stroke(0);
    rect(initx, inity, w, l);
  }

  void addMessage(String message, int textSize) {
    textSize(textSize);
    fill(0);
    text(message, initx + 5, (inity+l + inity) / 2);
  }

  void updateStatus() {
    if (mouseX > initx && mouseX < (initx + w) &&
      mouseY > inity && mouseY < (inity + l)) {
      isMouseOver = true;
    }
  }

  void mousePressed() {
    isMouseClicked = true;
  }
}