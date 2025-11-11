package com.keylane;

import com.keylane.exceptions.InvalidTriangleException;
import com.keylane.shapes.Triangle;
import com.keylane.shapes.TriangleType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TriangleTest {
    
    @Test
    void testEquilateral() {
        Triangle t = new Triangle(5.0, 5.0, 5.0);
        assertThat(t.getType()).isEqualTo(TriangleType.EQUILATERAL);
    }
    
    @Test
    void testIsosceles() {
        Triangle t = new Triangle(5.0, 5.0, 8.0);
        assertThat(t.getType()).isEqualTo(TriangleType.ISOSCELES);
        
        t = new Triangle(5.0, 8.0, 5.0);
        assertThat(t.getType()).isEqualTo(TriangleType.ISOSCELES);
    }
    
    @Test
    void testScalene() {
        Triangle t = new Triangle(3.0, 4.0, 5.0);
        assertThat(t.getType()).isEqualTo(TriangleType.SCALENE);
    }
    
    @Test
    void testNegativeSide() {
        assertThatThrownBy(() -> new Triangle(-1.0, 2.0, 3.0))
            .isInstanceOf(InvalidTriangleException.class)
            .hasMessageContaining("must be positive");
    }
    
    @Test
    void testInvalidTriangle() {
        assertThatThrownBy(() -> new Triangle(1.0, 2.0, 3.0))
            .isInstanceOf(InvalidTriangleException.class)
            .hasMessageContaining("Triangle Inequality");
        
        assertThatThrownBy(() -> new Triangle(1.0, 2.0, 10.0))
            .isInstanceOf(InvalidTriangleException.class)
            .hasMessageContaining("Triangle Inequality");
    }
    
    @Test
    void testEquals() {
        Triangle t1 = new Triangle(3.0, 4.0, 5.0);
        Triangle t2 = new Triangle(3.0, 4.0, 5.0);
        Triangle t3 = new Triangle(3.0, 4.0, 6.0);
        
        assertThat(t1).isEqualTo(t2);
        assertThat(t1).isNotEqualTo(t3);
    }
    
    @Test
    void testPerimeter() {
        Triangle t = new Triangle(3.0, 4.0, 5.0);
        assertThat(t.getPerimeter()).isEqualTo(12.0);
    }
}

