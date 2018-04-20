package implementation;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EmasSupercomputer {

    private static int twoPluses(String[] grid) {
        // Complete this function
        Set<Plus> pluses = new HashSet<>();
        for(int i = 0; i<grid.length; i++) {

            for(int j = 0; j<grid[i].length(); j++) {

                if(grid[i].charAt(j) == 'G') {

                    int maxLength = plusMaxLength(grid,j,i);
                    pluses.addAll(createPlusesUntil(j,i,maxLength));
                }
            }
        }
        return maxArea(pluses);
    }

    private static int maxArea(Set<Plus> pluses) {

        int area;
        int maxArea = 0;
        for(Plus plus: pluses) {

            for(Plus other: pluses) {

                area = plus.area()*other.area();
                if(!plus.overlaps(other) && area > maxArea) {

                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private static Set<Plus> createPlusesUntil(int x, int y, int maxLength) {

        final Set<Plus> pluses = new HashSet<>();
        if(maxLength>=0) {

            for(int l=0; l<=maxLength; l++) {

                pluses.add(new Plus(x,y,l));
            }
        }
        return pluses;
    }

    private static int plusMaxLength(String[] grid, int x, int y) {

        int length = 1;
        while(x+length < grid[y].length() &&
                y+length < grid.length &&
                x-length>=0 &&
                y-length>=0 &&
                grid[y].charAt(x+length) == 'G' &&
                grid[y].charAt(x-length) == 'G' &&
                grid[y-length].charAt(x) == 'G' &&
                grid[y+length].charAt(x) == 'G') {

                length = length+1;
        }
        return length-1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i = 0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        int result = twoPluses(grid);
        System.out.println(result);
        in.close();
    }
}

class Point {

    private int x;
    private int y;

    Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
                return x+y;
            }
}

class Plus {

    private Point center;
    private int length;
    private Set<Point> points;

    Plus(int x, int y, int length) {

        center = new Point(x,y);
        this.length = length;
        this.points = fillPoints();
    }

    private Set<Point> fillPoints() {

        Set<Point> points = new HashSet<>();
        points.add(center);
        for(int i = 1; i<=length; i++) {

            points.add(new Point(center.getX()-i,center.getY()));
            points.add(new Point(center.getX()+i,center.getY()));
            points.add(new Point(center.getX(),center.getY()-i));
            points.add(new Point(center.getX(),center.getY()+i));
        }
        return points;
    }

    int getLength() {
        return length;
    }

    int area() {

        return 4*length + 1;
    }

    private Set<Point> getPoints() {
        return points;
    }

    boolean overlaps(Plus plus) {

        return !Collections.disjoint(points,plus.getPoints());
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Plus)) {
            return false;
        }
        Plus other = (Plus) obj;
        return center == other.center && length == other.length;
    }

    @Override
    public int hashCode() {
                    return center.hashCode()+length;
                }

}
