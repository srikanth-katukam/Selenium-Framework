package utils;

import factory.BrowserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Skatukam on 02/27/2018.
 */
public class Element implements IConstants {
    public WebDriver driver= BrowserFactory.getDriver();
    public  WebElement element;
    public void testElement()
    {
        getDriver().manage().timeouts().implicitlyWait(MAX_ELEMENT_WAIT, TimeUnit.SECONDS);
    }

    public WebDriver getDriver()
    {
        return driver;
    }
    //----------Start of Click Operations--------------------------------------------------------------------------------
    /**
     * A method to click a element
     *
     * @param identifier selector in the form of
     *            the xpath, css or id of the UI element
     */
    public void click(String identifier) {
        //Log.info("Click on " + identifier);
        getElement(identifier).click();
    }

    /**
     * A method to click a element based on link text
     *
     * @param linkText
     *            text displayed in the link
     */
    public void clickLink(String linkText) {
        //Log.info("Click on " + linkText + " link");
        getDriver().findElement(By.linkText(linkText)).click();
    }

    /**
     * If there is any chance of duplicate links-clicks based on the index
     *
     * @param linkText
     *            text displayed in the link
     * @param index
     *            number of occurrence of the link
     */
    public void clickLink(String linkText, int index) {
       // Log.info("Click on " + linkText + " link (Occurance :" + index + ")");
        getDriver().findElements(By.linkText(linkText)).get(index).click();
    }

    /**
     * Double clicks the passed element
     * @param element
     *            element to be double clicked
     */
    protected void doubleClick(WebElement element) {
        Actions action = new Actions(getDriver());
        action.doubleClick(element);
        action.perform();
    }
    //----------End of Click Operations--------------------------------------------------------------------------------
    //----------Start of Text Field Operations.----------------------------------------------------------------------
    /**
     * A method to get text in text from a field
     *
     * @param identifier selector in the form of
     *            the xpath, css or id of the UI element
     * @return the text of the UI element
     */
    public String getText(String identifier) {
        //Log.info("Get " + identifier + " element text");

        WebElement element = getElement(identifier);
        return element.getText();
    }

    /**
     * A method to enter text in text field
     *
     * @param identifier selector in the form of
     *            the xpath, css or id of the UI element
     * @param value
     *            text to type in the text field
     */
    public void setText(String identifier, String value) {
        //Log.info("Enter " + value + " in " + identifier);
        getElement(identifier).sendKeys(value);
    }


    /**
     * Method to set text for a locator which is present inside another locator
     *
     * @param parentIdentifier - Locator of the parent element as webElement
     * @param identifier       - Locator of the webElement where actually text to be entered
     * @param value            - Value to enter
     */
    public void setText(WebElement parentIdentifier, String identifier, String value) {
        getElement(parentIdentifier, identifier).sendKeys(value);
        //Log.info("Finished Entering " + value + " in " + identifier + " present under " + parentIdentifier);
    }

    public void setTextByKeys(String identifier, String value) {
        //Log.info("Enter " + value + " in " + identifier);
        WebElement element=getElement(identifier);
        element.clear();
        for (int i=0;i < value.length();i++)
            element.sendKeys(value.charAt(i)+"");
    }

    /**
     * A method to clear text field and then type text
     *
     * @param identifier selector in the form of
     *            the xpath, css or id of the UI element
     * @param text
     *            text to type in the filed
     */
    public void clearAndSetText(String identifier, String text) {
        //Log.info("Clear field " + identifier + " enter " + text);
        WebElement element = getElement(identifier);
        element.clear();
        element.sendKeys(text);
    }


    /**
     * Method to clear and set text for a locator which is present inside another locator
     *
     * @param parentIdentifier - Locator of the parent element as webElement
     * @param identifier       - Locator of the webElement where actually text to be entered
     * @param value            - Value to enter
     */
    public void clearAndSetText(WebElement parentIdentifier, String identifier, String value) {
        WebElement element = getElement(parentIdentifier, identifier);
        element.clear();
        element.sendKeys(value);
        //Log.info("Finished Entering " + value + " in " + identifier + " present under " + parentIdentifier);
    }

    /**
     * A method to clear text in text field
     *
     * @param identifier selector in the form of
     *            the xpath, css or id of the UI element
     */
    public void clearText(String identifier) {
        //Log.info("Clear field " + identifier);
        getElement(identifier).clear();
    }
    //----------End of Text Field Operations.----------------------------------------------------------------------
    //----------Start of Radio or CheckBox Operations-------------------------------------------------------------------------
    /**
     * A method to select the option from selection box
     *
     * @param identifier selector in the form of
     *            the xpath, css or id of the UI element
     * @param option
     *            option value to select
     */
    public void selectFromDropDown(String identifier, String option) {
        //Log.info("Select option " + option + " from selection box ");

        Select select = new Select(getElement(identifier));
        select.selectByVisibleText(option);
    }

    /**
     * Method to select the check box if not already selected
     *
     * @param identifier selector in the form of
     *            the xpath, css or id of the UI element
     */
    public void selectCheckBox(String identifier) {
       // Log.info("Select check box " + identifier);

        String attributeValue = getElement(identifier).getAttribute("CHECKED");
        if (attributeValue == null) {
            click(identifier);
        }
    }
    //--------------------End of Radio or CheckBox Operations-------------------------------------------------------------
    /**
     * A method to get the alert message
     *
     * @return the message displayed in the alert
     */
    public String getAlert() {
        //Log.info("Waiting for alert message");

        String str = null;
        (new WebDriverWait(getDriver(), MAX_ELEMENT_WAIT))
                .until(new ExpectedCondition<Alert>() {
                    public Alert apply(WebDriver d) {
                        Alert alert = getDriver().switchTo().alert();
                        return alert;

                    }
                });
        Alert alert = getDriver().switchTo().alert();
        str = alert.getText();
        alert.accept();
        return str;
    }
    /**
     * A method to get css style of a element
     *
     * @param identifier selector in the form of
     *            the xpath, css or id of the UI element
     * @param cssStyle
     *            the style of the UI element like color, font-weight, etc
     * @return the value of the css style
     */
    public String getCSS(String identifier, String cssStyle) {
        //Log.info("Getting css of the element " + identifier);

        return getElement(identifier).getCssValue(cssStyle);
    }
    //Start of Java Script Operations
    /**
     * A method to set value of element using javascript
     *
     * @param id - id of the UI element
     * @param value - value that need to be set to the element
     * @return void
     */
    public void jsSetText(String id, String value) {
       /* Log.info("Setting element value by injecting javascript - id of the element("
                + id + ")");*/

        String script = "document.getElementById(\"" + id + "\").value=\""
                + value + "\"";
        ((JavascriptExecutor) getDriver()).executeScript(script);
    }
    public void switchToFrame(String identifier) {
        if (identifier.indexOf("/") != -1) {
            getDriver().switchTo().frame(getElement(identifier));
        } else {
            try {
                int iframeNo = Integer.parseInt(identifier);
                getDriver().switchTo().frame(iframeNo);
            } catch (Exception e) {
                getDriver().switchTo().frame(identifier);
            }
        }
    }
    /**
     * Method to check frame is available or not based on frame Name or frame ID
     *
     * @param frame           -  frame Id/name
     * @param frameIdentifier -  frameIdentifier like frame Id or frame Name
     * @return - true if frame is present else false
     */
    public boolean isFramePresent(String frame, String frameIdentifier) {
        boolean isFramePresent = false;
        final List<WebElement> iframes = getAllElement(By.tagName("iframe"));
        for (WebElement iframe : iframes) {
            if (iframe.getAttribute(frameIdentifier).equals(frame)) {
                isFramePresent = true;
                break;
            }
        }
        return isFramePresent;
    }
    public void switchToMainWindow(){
        getDriver().switchTo().defaultContent();
    }
    //-------------Start of Elements Operations---------------------------------------------------------------------------------
    /**
     * A method to check whether a element is present or not
     *
     * @param identifier selector in the form of
     *            the xpath, css or id of the UI element
     * @return true if the element present or else false
     */
    public boolean isElementPresent(String identifier) {
        return isElementPresent(getElementBy(identifier));
    }
    /**
     * A method to check whether a element is present or not
     *
     * @param by any 'By.'
     * @return true if the element present or else false
     */
    public boolean isElementPresent(By by){
       // Log.info("Verify that " + by + " element present");

        int count = getAllElement(by).size();
        if (count > 0)
            return true;
        else
            return false;
    }
    /**
     * Verifies whether the element identified by the given identifier is displayed
     * @param identifier selector in the form of the xpath, css or id of the UI element
     * @return true if the element displayed or else false
     */
    public boolean isElementDisplayed(String identifier) {
        return isElementDisplayed(getElementBy(identifier));
    }
    /**
     * Verifies whether the element identified by the given identifier is displayed
     * @param by any 'By.'
     * @return true if the element displayed or else false
     */
    public boolean isElementDisplayed(By by) {
        boolean isElementPresent = isElementPresent(by);
        if (isElementPresent) {
            try {
                WebElement element = getElement(by);
                return element.isDisplayed();
            } catch (ElementNotVisibleException env) {
               // Log.info("Element not visbile");
                return false;
            }
        }
        return isElementPresent;
    }
    public boolean isElementClickable(String xpath) {
        return isElementClickable(getElementBy(xpath));
    }
    public boolean isElementClickable(By by) {
        try {
            new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * A method to get number of elements present with same xpath
     *
     * @param identifier selector in the form of
     *            the xpath, css or id of the UI element
     * @return count of the occurrence of the element
     */
    public int getElementCount(String identifier) {
        //Log.info("Finding  number of occurences of " + identifier);

        return getNumberOfElements(identifier);
    }

    /**
     * Gets number of elements with same id or xpath
     *
     * @param identifier
     *            id or xpath
     */
    private int getNumberOfElements(String identifier){
        List<WebElement> webElements=getAllElement(identifier);
        return webElements.size();
    }
    /**
     * Get all elements by Identifier like xpath, css, className, Name, linkText or Id
     * @param identifier
     * @return
     */
    public List<WebElement> getAllElement(String identifier){
        return getDriver().findElements(getElementBy(identifier));
    }
    /**
     * Get all elements by this identifier (id, css or xpath)
     * @param by Any 'By.'
     * @return
     */
    public List<WebElement> getAllElement(By by){
        return getDriver().findElements(by);
    }
    /** Basic element finder, works with any 'by' but returns null if element not found rather
     *  than throwing exception.
     *
     * @param by any 'By.'
     * @return the found element or null if it is not present.
     */
    public WebElement getElement(By by) {
        try {
            element = getDriver().findElement(by);
            return element;
        } catch (StaleElementReferenceException ser) {
            throw ser;
        } catch (NoSuchElementException nse) {
            throw nse;
        } catch (ElementNotVisibleException env) {
            throw env;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * A method to get element by identifier (id, css or xpath)
     *
     * @param identifier
     *            id, css or xpath
     * @return void
     */
    public WebElement getElement(String identifier){
        return getElement(getElementBy(identifier));
    }
    /**
     * Get a webelement inside a given parent locator element for a given identifier
     * @param parentIdentifier Locator for the parent element under which another webelement identified by the given "identifier" have to find.
     * @param identifier Locator of the webelment that needs to be searched under the given parentidentifier webelement.
     * @return WebElement represented by the said identifier locator under the parent identifier.
     */
    public WebElement getElement(String parentIdentifier, String identifier) {
        return getElement(getElement(parentIdentifier), identifier);
    }
    /**
     * Get a webelement inside a given parent locator element for a given identifier
     * @param parentElement Webelement of the parent element under which another webelement identified by the given "identifier" have to be searched.
     * @param identifier Locator of the webelment that needs to be searched under the given parentidentifier webelement.
     * @return WebElement represented by the said identifier locator under the parent webelement.
     */
    public WebElement getElement(WebElement parentElement, String identifier) {
        try {
            WebElement ele = parentElement.findElement(getElementBy(identifier));
            return ele;
        } catch (StaleElementReferenceException ser) {
            //Log.info("ERROR: Stale element. " + identifier);
            throw new RuntimeException(ser);
        } catch (NoSuchElementException nse) {
           // Log.info("ERROR: No such element. " + identifier);
            throw new RuntimeException(nse.getMessage());
        } catch (Exception e) {
           // Log.info(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    /**
     * Get Element Identifier like xpath, css, className, Name, linkText or Id
     * @param identifier
     * @return
     */
    public By getElementBy(String identifier)
    {
        if(identifier.indexOf("/")==0){
            return By.xpath(identifier);
        } else if ((identifier.indexOf("css:") == 0)) {
            String selector = identifier.substring("css:".length());
            return By.cssSelector(selector);
        } else if ((identifier.indexOf("class:") == 0)) {
            String selector = identifier.substring("class:".length());
            return By.className(selector);
        } else if ((identifier.indexOf("name:") == 0)) {
            String selector = identifier.substring("name:".length());
            return By.name(selector);
        } else if ((identifier.indexOf("linkText:") == 0)) {
            String selector = identifier.substring("linkText:".length());
            return By.linkText(selector);
        } else
            return By.id(identifier);
    }
//-------------End of Elements Operations------------------------------------------------------------------------------------------
    /**
     * Taking Screen Shot and storing in specified file
     */
    public void takeScreenShot(String fileName) {
        Screenshot.takeScreenshot(SCREENSHOTS_DIR + fileName);
    }

    public void sleep(int seconds) {
        Timer.sleep(seconds);
    }

    /**
     * @param identifier - Locator to mouseover
     */
    public void mouseOver(String identifier){
        Actions action = new Actions(getDriver());
        WebElement ele = getElement(identifier);
        action.moveToElement(ele).build().perform();
    }

    /**
     * A method to drag an element from source location and drops to destination
     * @param source webelement
     * @param destination webelement
     */
    public void dragAndDrop(String source, String destination) {
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(getElement(source))
                .moveToElement(getElement(destination))
                .release(getElement(destination)).build().perform();

    }

    /**
     * A method to perform mouseover and click on identifier
     * @param identifier
     */
    public void mouseOverAndClickOnIdentifier(String identifier){
        Actions action = new Actions(driver);
        WebElement ele = getElement(identifier);
        action.moveToElement(ele).click().build().perform();
    }
}
