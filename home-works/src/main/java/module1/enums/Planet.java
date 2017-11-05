package module1.enums;

/**
 * @author Egor Stepanov
 * @since 03-11-2017.
 */
public enum Planet {

    MERCURY(0.033, 2438, 58),
    VENUS(0.487, 6051, 108),
    EARTH(0.59, 6371, 150),
    MARS(0.064, 3389, 228),
    JUPITER(189.8, 69911, 778),
    SATURN(56.85, 58364, 1430),
    URANUS(8.68, 25362,3000),
    NEPTUN(10.24, 24622, 4500),
    PLUTO(0.001303, 1188, 5900);

    private static final double E25 = 1E25;
    private static final double MLN = 1e6;

    private final double mass;
    private final double radius;
    private final double distance;

    Planet(double mass, double radius, double distance) {
        this.mass = mass * E25;
        this.radius = radius;
        this.distance = distance * MLN;
    }

    /**
     * @return масса платены
     */
    public double getMass() {
        return mass;
    }

    /**
     * @return радиус планеты
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @return среднее расстояние до Солнца
     */
    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Planet: " + name() + " {" +
                "mass = " + mass + " kg, " +
                "radius = " + radius + " km, " +
                "distance from Sun = " + distance + " mln. km }";
    }
}
