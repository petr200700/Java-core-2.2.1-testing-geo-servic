package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.netology.entity.Country;

import java.util.stream.Stream;

class LocalizationServiceImplTest {

    @ParameterizedTest
    @MethodSource("source")

    public void checkingReturnedText(Country country, String message) {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String countryName = localizationService.locale(country);
        Assertions.assertEquals(countryName, message);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(Country.RUSSIA, "Добро пожаловать"),
                Arguments.of(Country.GERMANY, "Welcome"),
                Arguments.of(Country.USA, "Welcome"),
                Arguments.of(Country.BRAZIL, "Welcome")

        );
    }
}