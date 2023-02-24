import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFromTest() {
        open("/text-box");

        $("#userName").setValue("Nicol Bolas");
        $("#userEmail").setValue("godpharaoh@amonkhet.com");
        $("#currentAddress").setValue("Bolas's Citadel");
        $("#permanentAddress").setValue("Prison Realm");
        $("#submit").click();

        $("#output").shouldHave(text("Nicol Bolas"), text("godpharaoh@amonkhet.com"),
                text("Bolas's Citadel"), text("Prison Realm"));
    }
}
