package com.keylane.shapes;

public sealed interface PerimeterCalculable permits Triangle {
    // Calculates and returns the perimeter
    double getPerimeter();
}

