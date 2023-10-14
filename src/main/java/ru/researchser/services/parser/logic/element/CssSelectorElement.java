package ru.researchser.services.parser.logic.element;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import ru.researchser.services.parser.logic.parameter.ParseAlgorithm;
import ru.researchser.services.parser.logic.parameter.ParseParameter;
import ru.researchser.services.parser.logic.parameter.OneParseParameter;
import ru.researchser.models.parser.ElementLocator;

import java.time.Duration;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CssSelectorElement extends ElementLocator implements ParseAlgorithm {
    @Autowired
    private WebDriver driver;

    @Override
    public String parseByParameters(ParseParameter abstractParseParameter, String url) {
        String cssSelector = ((OneParseParameter)abstractParseParameter).getParameter();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        String elementValue = element.getText();
        return elementValue;
    }
}