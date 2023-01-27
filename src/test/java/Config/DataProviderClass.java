    package Config;

    import org.testng.annotations.DataProvider;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Random;
    public class DataProviderClass {

        @DataProvider(name = "userData")
        public Object[][] userData() {
            return new Object[][]{
                    {},
                    {}

            };
        }
    }

