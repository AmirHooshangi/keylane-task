package com.keylane.shapes;

public sealed interface Shape permits Triangle {
    // Returns the name of the shape
    String getName();
}
