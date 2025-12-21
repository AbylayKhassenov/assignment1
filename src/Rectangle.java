public class Rectangle {
    private double width;
    private double height;
    private int id;
    private  static int idGen = 0;

    public Rectangle(){
        this.width = 1.0;
        this.height = 1.0;
        this.id = idGen++;

    }

    public double getHeight() {
        return height;
    }


    public void setHeight (double height){
        if(height <= 0){

        }
        this.height = height;
    }

    public double getWidth() {

        return width;
    }

    public void setWidth (double width){
        if(width <= 0){
            throw new IllegalArgumentException("value of height must be greater than 0!");

        }
        this.width = width;
    }

    public Rectangle(double width,double height ){
        this();
        setHeight(height);
        setWidth(width);
    }

    public double Area(double width,double height ){
        return width*height;
    }

    public double perimeter(double width,double height ) {
            return 2*(width+height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "id=" + id +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

}
