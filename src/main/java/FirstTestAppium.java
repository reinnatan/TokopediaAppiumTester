import java.net.URL;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;


public class FirstTestAppium {
	
	public static AndroidDriver<MobileElement> driver;
	public static WebDriverWait wait;
	
	By skipBy = By.id("com.tokopedia.tkpd.df_base:id/skip_action");
	By searchBy = By.id("com.tokopedia.tkpd:id/et_search");
	By searchText = By.id("com.tokopedia.tkpd:id/searchTextView");
	By sortProduct = By.id("com.tokopedia.tkpd:id/sort_filter_prefix");
	By lowerPriceProduct = By.id("com.tokopedia.tkpd:id/sortFilterChipsUnify");
	By showAllProductFilter = By.id("com.tokopedia.tkpd:id/buttonApplySortFilter");
	String stringSkipButtonId = "com.tokopedia.tkpd.df_base:id/skipDynamicOnbaording";
	
	@BeforeClass
	public static void setup() throws Exception{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "RR8R801GPNZ");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.tokopedia.tkpd");
		caps.setCapability("appActivity", "com.tokopedia.tkpd.ConsumerSplashScreen");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		wait = new WebDriverWait(driver, 20);
	}
	
	@Test
	public void testApp() {
		System.out.println("Testing is called");
		MobileElement skipButton = driver.findElementById(stringSkipButtonId);
		if(skipButton.isDisplayed()){
			skipButton.click();
		}

		//wait.until(ExpectedConditions.visibilityOfElementLocated(skipBy)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchBy)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchText)).sendKeys("sepeda gunung");
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortProduct)).click();
		List<MobileElement> listElement =  driver.findElements(By.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]"));
		listElement.get(0).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(lowerPriceProduct)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(showAllProductFilter)).click();
		
	}
	
	
	
	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
	
	
}
