package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Login")
	public Object[][] dpsingledim() {

		Object data[][] = { { "admin", "admin123" }, { "admin", "admin12345" } };
		return data;

	}
}
