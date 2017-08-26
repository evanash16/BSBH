package entities;

public class Interactions {

    public static boolean checkCoreCollision(Core c1, Core c2) {
        return calculateDistance(c1.getX(), c1.getY(), c2.getX(), c2.getY()) < c1.getRadius() + c2.getRadius();
    }

    public static boolean checkSafezoneCollision(Safezone s1, Safezone s2){ //it does the same thing as checkCoreCollision..
                                                                            //they extend entities which is slightly inconvenient when we need radius...
                                                                            //we could add radius as an attribute to entity maybe?
        return calculateDistance(s1.getX(), s1.getY(), s2.getX(), s2.getY()) < s1.getRadius() + s2.getRadius();
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // This doesn't make them bounce!! They just won't intersect
    public static void resolveCollision(Core c1, Core c2) {
        double dist = calculateDistance(c1.getX(), c1.getY(), c2.getX(), c2.getY());
        double midX = (c1.getX() + c2.getX())/2, midY = (c1.getY() + c2.getY())/2;
        c1.setX(midX + (c1.getRadius() * (c1.getX() - c2.getX())/ dist));
        c1.setY(midY + (c1.getRadius() * (c1.getY() - c2.getY())/ dist));
        c2.setX(midX + (c2.getRadius() * (c2.getX() - c1.getX())/ dist));
        c2.setY(midY + (c2.getRadius() * (c2.getY() - c1.getY())/ dist));
    }
}
