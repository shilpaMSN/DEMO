package Practice.MYpractice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import CI_Pageobjects.CI_FB_pageobject;
import My_TestComponents.CI_BaseTest;

public class faceBook extends CI_BaseTest {
	@Test
	public void PlaceOrder() throws IOException {
	
		CI_FB_pageobject launch = launchApp();
		String text=launch.getText();
		Assert.assertTrue(text.equalsIgnoreCase("Forgotten password?"));
		System.out.println("postjeera1");
		System.out.println("postjeera2");
		System.out.println("postjeera3");
		System.out.println("postjeera4");
		//isgfgdyfgu
		//dvvdhfryhgf
		//dfyugfyrgf
		//dfduvfgvdfh
		//fgfygugfhur
		System.out.println("postjeera1");
		System.out.println("postjeera2");
		System.out.println("postjeera3");
		System.out.println("postjeera4");

	}

}
