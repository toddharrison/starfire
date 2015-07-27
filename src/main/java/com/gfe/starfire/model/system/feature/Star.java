package com.gfe.starfire.model.system.feature;

import java.util.ArrayList;
import java.util.List;

import com.gfe.starfire.model.system.ASystem;

public class Star extends AFeature {
    public ASystem system;

    private final List<Planet> planets;
    private final SpectralClass spectralClass;
    private final int temperature;
    private final Luminosity luminosity;

    public Star(final SpectralClass spectralClass, final int temperature,
            final Luminosity luminosity) {
        this(spectralClass, temperature, luminosity, new ArrayList<>());
    }

    public Star(final SpectralClass spectralClass, final int temperature,
            final Luminosity luminosity, final List<Planet> planets) {
        this.spectralClass = spectralClass;
        this.temperature = temperature;
        this.luminosity = luminosity;

        this.planets = planets;
        for (final Planet planet : this.planets) {
            planet.setStar(this);
        }
    }

    public SpectralClass getSpectralClass() {
        return spectralClass;
    }

    public int getTemperature() {
        return temperature;
    }

    public Luminosity getLuminosity() {
        return luminosity;
    }

    @Override
    public String toString() {
        // return spectralClass.getColor() + " " + luminosity.getName() + " (" + spectralClass
        // + temperature + luminosity + ")";
        final StringBuffer sb = new StringBuffer();
        sb.append(spectralClass);
        sb.append(temperature);
        sb.append(luminosity);
        sb.append(" ");
        sb.append(planets);

        return sb.toString();
    }

    public enum SpectralClass {
        O("Blue"), B("Blue White"), A("White"), F("Yellow White"), G("Yellow"), K("Orange"), M(
                "Red");

        private final String color;

        private SpectralClass(final String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    public enum Luminosity {
        O("Hypergiant"), Ia("Supergiant"), Ib("Supergiant"), II("Bright Giant"), III("Giant"), IV(
                "Subgiant"), V("Main Sequence"), VI("Subdwarf"), VII("Dwarf");

        private final String name;

        private Luminosity(final String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
