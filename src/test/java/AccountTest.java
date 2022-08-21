import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные {0}")
    public static Object[][] getName() {
        return new Object[][]{
                {"Имя Фамилия", true},
                {"имя фамилия", true},
                {"и ф", true},
                {"Девятнадцать символ", true},
                {" Имя Фамилия", false},
                {"Имя Фамилия ", false},
                {" Имя Фамилия ", false},
                {"ИмяФамилия", false},
                {"Имя Фамилия Отчество", false},
                {"Больше девятнадцатисимоволов", false},
                {"Им", false},
                {"", false},
                {null, false}};
    }

    @Description("Проверка валидации имени")
    @Test
    public void checkName() {
        boolean actual = new Account(name).checkNameToEmboss();
        assertEquals(expected, actual);
    }
}
