package com.keylane;

import com.keylane.exceptions.InvalidTriangleException;
import com.keylane.shapes.Triangle;

public class App {
    
    // Main entry point - runs the triangle demo
    public static void main(String[] args) {
        System.out.println("Triangle Type Determination Demo\n");
        
        double a = 2.0, b = 5.0, c = 6.0;
        try {
            Triangle triangle = new Triangle(a, b, c);
            System.out.printf("Triangle with sides (%.2f, %.2f, %.2f) is valid%n", a, b, c);
            System.out.println("Triangle type: " + triangle.getType());
            System.out.println("Triangle area: " + triangle.getArea());
            System.out.println("Triangle perimeter: " + triangle.getPerimeter());
        } catch (InvalidTriangleException e) {
            System.out.printf("Expected error for triangle (%.2f, %.2f, %.2f): %s%n", 
                            a, b, c, e.getMessage());
        }   
    }

}

