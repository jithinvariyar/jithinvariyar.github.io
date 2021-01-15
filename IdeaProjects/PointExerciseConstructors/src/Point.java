public class Point {
    private int x , y;
    public Point(){

    }
    public Point(int x , int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public double distance(){
        return distance(0,0);
    }
    public double distance(int p , int q){
         double dist1 = ((double)p - (double)x) * ((double)p - (double)x);
         double dist2 = ((double)q - (double)y) * ((double)q - (double)y);
         return Math.sqrt(dist1 + dist2);
    }
    public double distance(Point another){
        return distance(another.x , another.y);
    }
}
