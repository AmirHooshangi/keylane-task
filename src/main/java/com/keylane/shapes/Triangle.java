package com.keylane.shapes;

import com.keylane.exceptions.InvalidTriangleException;

/**
 * Represents a triangle with three sides.
 * 
 * @param sideA length of the first side
 * @param sideB length of the second side
 * @param sideC length of the third side
 */
public record Triangle(double sideA, double sideB, double sideC) implements Shape, AreaCalculable, PerimeterCalculable {
    
    public Triangle {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new InvalidTriangleException(
                String.format("All triangle sides must be positive. Provided: a=%.2f, b=%.2f, c=%.2f", sideA, sideB, sideC)
            );
        }
        
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new InvalidTriangleException(
                String.format("Triangle Inequality violated. Provided: a=%.2f, b=%.2f, c=%.2f", sideA, sideB, sideC)
            );
        }
    }
    
    // Tells you what kind of triangle this is based on the side lengths
    public TriangleType getType() {
        if (sideA == sideB && sideA == sideC) {
            return TriangleType.EQUILATERAL;
        }
        if (sideA == sideB || sideA == sideC || sideB == sideC) {
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }
    
    // Returns the name of this shape
    @Override
    public String getName() {
        return "Triangle";
    }
    
    // Calculates the area of the triangle
    @Override
    public double getArea() {
        double s = (sideA + sideB + sideC) / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
    // Calculates the perimeter by adding up all three sides
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
}

