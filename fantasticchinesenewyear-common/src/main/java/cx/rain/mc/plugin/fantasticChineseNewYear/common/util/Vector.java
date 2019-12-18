package cx.rain.mc.plugin.fantasticchinesenewyear.common.util;

public class Vector {
    private double X, Y, Z;

    public Vector() {
        X = 0;
        Y = 0;
        Z = 0;
    }

    public Vector(int x, int y, int z) {
        X = x;
        Y = y;
        Z = z;
    }

    public Vector(float x, float y, float z) {
        X = x;
        Y = y;
        Z = z;
    }

    public Vector(double x, double y, double z) {
        X = x;
        Y = y;
        Z = z;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getZ() {
        return Z;
    }

    public int getBlockX() {
        return (int) Math.round(X);
    }

    public int getBlockY() {
        return (int) Math.round(Y);
    }

    public int getBlockZ() {
        return (int) Math.round(Z);
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public void setZ(int z) {
        Z = z;
    }

    public void setX(float x) {
        X = x;
    }

    public void setY(float y) {
        Y = y;
    }

    public void setZ(float z) {
        Z = z;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setZ(double z) {
        Z = z;
    }

    public Vector add(Vector vector) {
        X += vector.X;
        Y += vector.Y;
        Z += vector.Z;
        return this;
    }
}
