package com.keylane.shapes;

public sealed interface AreaCalculable permits Triangle {
    // Calculates and returns the area
    double getArea();
}

