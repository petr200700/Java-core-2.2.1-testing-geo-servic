package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceImplTest {

    @ParameterizedTest
    @ValueSource(strings = "172.0.32.11")
    public void checkingLocationDefinitionByIp(String ip) {
        GeoService geoService = new GeoServiceImpl();
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location actual = geoService.byIp(ip);
        Assertions.assertEquals(expected.getCity(), actual.getCity());
        Assertions.assertEquals(expected.getCountry(), actual.getCountry());
        Assertions.assertEquals(expected.getStreet(), actual.getStreet());
        Assertions.assertEquals(expected.getBuiling(), actual.getBuiling());
    }

    @Test
    public void LocationByCoordinatesThrowingExceptionDesiredType() {
        GeoService geoService = new GeoServiceImpl();
        double latitude = 15.1, longitude = 50.5;
        var expected = RuntimeException.class;
        Executable action = () -> geoService.byCoordinates(latitude, longitude);
        Assertions.assertThrows(expected, action);
    }

}

