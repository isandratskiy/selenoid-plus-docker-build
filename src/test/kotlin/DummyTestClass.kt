import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Configuration.remote
import com.codeborne.selenide.Configuration.timeout
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By.linkText

class DummyTestClass {

    @BeforeEach
    fun setup() {
        remote = "http://selenoid:4444/wd/hub"
        timeout = 60000
    }

    @Test
    fun `should open checkbox page`() {
        open("https://the-internet.herokuapp.com/")
        element(linkText("Checkboxes")).click()
        element("#checkboxes").shouldBe(visible)
    }
}