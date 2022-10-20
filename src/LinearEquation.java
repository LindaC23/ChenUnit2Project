public class LinearEquation {
    // instance variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    // creates a LinearEquation object
    public LinearEquation (int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // calculates and returns the distance between (x1, y1) and (x2, y2), rounded to the nearest hundredth
    public double distance(){
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    // calculates and returns the y-intercept of the line between (x1, y1) and (x2, y2), rounded to the nearest hundredth
    public double yIntercept(){
        return roundedToHundredth(y1 - (slope() * x1));
    }

    // calculates and returns the slope of the line between (x1, y1) and (x2, y2), rounded to the nearest hundredth
    public double slope(){
        return roundedToHundredth((double)(y2 - y1)/(x2 - x1));
    }

    // returns a String that represents the linear equation of the line through points (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5"
    public String equation(){
        String finalEquation = "y = ";

        if (slope() == 0){
            finalEquation += yIntercept();
            return finalEquation;
        }

        if ((int)slope() == slope()){
            finalEquation += slope() + "x";
        } else {
            if (((y2 - y1) < 0) && (x2 - x1) < 0){
                finalEquation += Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1) +"x";
            }
            if ((x2 - x1) < 0){
                finalEquation += "-" + (y2 - y1) + "/" + Math.abs(x2 - x1) + "x";
            }
        }

        if (yIntercept() == 0){
            return finalEquation;
        } else {
            if (yIntercept() < 0){
                finalEquation += " " + yIntercept();
            } else {
                finalEquation += "+ " + yIntercept();
            }
        }
        return finalEquation;
    }

    // returns a String of the coordinate point on the line that has the given x value, with both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75)
    public String coordinateForX(double xValue){
        double yValue = roundedToHundredth(slope() * xValue) + yIntercept();
        return "(" + roundedToHundredth(xValue) + ", " + yValue + ")";
    }

    // returns the value toRound rounded to the nearest hundredth
    public double roundedToHundredth(double toRound){
        return Math.round(toRound * 100) / 100.0;
    }

    // returns a string that includes all information about the linear equation, each on separate lines
    public String lineInfo(){
        String info = "The two points are: " + "(" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " +  y2 + ")";
        info += "\nThe equation of the line between these points is: " + equation();
        info += "\nThe slope of this line is: " + slope();
        info += "\nThe y-intercept of the line is: " + yIntercept();
        info += "\nThe distance between the two points is: " + distance();
        return info;
    }
}