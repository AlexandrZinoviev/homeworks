package APITests;

import apiSteps.DzenApiSteps;
import org.testng.annotations.Test;


public class ClassOneApiTest {
    DzenApiSteps dzenApiSteps = new DzenApiSteps();

    @Test(description = "проверяем город")
    void checkCity() {
        dzenApiSteps.getCity();
    }

}
