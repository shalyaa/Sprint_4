import java.util.regex.Pattern;

public class Account {
    String regexp = "^(?=.{3,19}$)[а-яА-я]+\\s+[а-яА-я]+$";

    private final String name;
    private final Pattern pattern = Pattern.compile(regexp);

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return name != null && pattern.matcher(name).matches();
    }
}
