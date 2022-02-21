import org.testng.Assert;
import org.testng.annotations.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestNGTaskTest {

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/mm/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Время начала теста");
        currentTime();
    }

    @DataProvider(name = "AgeTeenager")
    public Object[][] AgeTeenager() {
        return new Object[][]{
                {-1, false},
                {0, false},
                {1, false},
                {10, false},
                {12, false},
                {13, true},
                {14, true},
                {17, true},
                {18, true},
                {19, true},
                {20, false},
                {25, false}
        };
    }

    @Test(dataProvider = "AgeTeenager")
    public void isTeenagerTest (int age, boolean expected){
        boolean result = TestNGTask.isTeenager(age);
        Assert.assertEquals(result, expected);
    }

    @AfterTest()
    public void afterTest() {
        System.out.println("Конец теста");
        currentTime();
    }

}