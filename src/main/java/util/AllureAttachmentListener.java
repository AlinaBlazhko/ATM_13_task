package util;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

public class AllureAttachmentListener extends TestListenerAdapter{
    @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] makeScreenshot() {
        byte[] array = {1};
        try {
            return ((TakesScreenshot)WebDriverSingleton.getWebDriverInstance()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e){
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr){
        makeScreenshot();
    }


    @Override
    public void onTestSuccess(ITestResult tr){
        makeScreenshot();
    }
}