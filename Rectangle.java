// A Rectangle class
public class Rectangle {
  
  // 4 instance attributes
  public double width;
  public double height;
  public double originX = 0.0;
  public double originY = 0.0;

  // 1 static attributes
  public static final int NUMBER_OF_SIDES = 4;

  // main constructor
  public Rectangle(double w, double h, double oX, double oY) {
    this.width = w;
    this.height = h;
    this.originX = oX;
    this.originY = oY;
  }

  // second constructor: 
  public Rectangle(double width, double height) { //allows us to instatiate a rectangle without providing origin coords
    this(width, height, 0, 0);
  }

  // third constructor: 
  public Rectangle() {
    this(1,1,0,0);
  }

  // method: move the rectangle
  public void move(double dx, double dy) {
	  this.originX += dx;
	  this.originY += dy;
  }

  // method: scaling method with 2 seperate factors
  public void scale(double scaleX, double scaleY){
    this.width = this.width*scaleX;
    this.height = this.height*scaleY;
  }

  // method: scaling method with 1 factor for both directions
  public void scale(double scale){
    this.width = this.width*scale;
    this.height = this.height*scale;
  }

  // method: compute the area of the rectangle
  public double getArea() {
    return this.width * this.height;
  }
  
  // method: compute the area of the rectangle
  public double getPerimeter() {
    return 2 * (this.width + this.height);
  }

  public boolean isOverlappedWith(Rectangle r){
    // assuming that the origin is the top left of the rectangle
    double this_max_width = this.originX + this.width;
    double this_min_width = this.originX;
    double this_max_height = this.originY + this.height;
    double this_min_height = this.originY;
    double r_max_width = r.originX + r.width;
    double r_min_width = r.originX;
    double r_max_height = r.originY + r.height;
    double r_min_height = r.originY;

    if (((this_max_width > r_max_width) && (this_min_width < r_min_width)) || ((this_min_width < r_min_width) && (this_max_width > r_min_width))){
      return true; 
    } else if  (((this_max_height > r_max_height) && (this_min_height < r_min_height)) || ((this_min_height < r_min_height) && (this_max_height > r_min_height))){
      return true;
    } else {
      return false;
    }
  }
}
