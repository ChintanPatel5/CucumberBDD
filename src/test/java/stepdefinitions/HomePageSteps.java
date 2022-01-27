package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {

		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver()
				.get("https://www.saucedemo.com/");
		homePage = loginPage.doLogin(userName, password);

	}

	@Given("user is on Home page")
	public void user_is_on_accounts_page() {
		String title = homePage.getAccountsPageTitle();
		System.out.println("Home Page title is: " + title);
	}

	@When("user clicks on Menu icon")
	public void user_clicks_on_menu_icon() throws InterruptedException {
		homePage.clickMenuIcon();
		Thread.sleep(2000);
	}
	
	@Then("user gets Menu section")
	public void user_gets_accounts_section(DataTable sectionsTable) {

		List<String> expMenuSectionsList = sectionsTable.asList();
		
		System.out.println("Expected menu section list: " + expMenuSectionsList);

		List<String> actualMenuSectionsList = homePage.getMenuSectionsList();
		System.out.println("Actual menu section list: " + actualMenuSectionsList);

		Assert.assertTrue(expMenuSectionsList.containsAll(actualMenuSectionsList));

	}

	@Then("menu section count should be {int}")
	public void menu_section_count_should_be(Integer expectedSectionCount) {
		Assert.assertTrue(homePage.getMenuSectionCount() == expectedSectionCount);
	}

}
