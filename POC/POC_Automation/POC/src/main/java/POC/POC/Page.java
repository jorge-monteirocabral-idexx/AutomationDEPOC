//package POC.POC;
//
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
//
//public abstract class Page {
//	protected Driver			driver;
//	protected Map<String, By>	listOfByElements;
//
//	/*
//	 * protected CRUD temporaryRun; protected DBTables mainRun; protected DBTables
//	 * tempRun;
//	 */
//	public abstract void loadDefinitions();
//
//	public Page(WebDriver driver)/* CRUD temporaryRun, DBTables mainRun, DBTables tempRun) */
//	{
//		this.driver = driver;
//		this.listOfByElements = new HashMap<String, By>();
//		loadDefinitions();
//	}
//
//	public void actionClick(String elementName) throws NoSuchElementException, InterruptedException, SQLException {
//		boolean findResult = false;
//		try {
//			WebElement ele = driver.findElement(listOfByElements.get(elementName));
//			ele.click();
//			System.out.println(elementName + " on xpath:" + listOfByElements.get(elementName) + "driver click()");
//			findResult = true;
//		} catch (NoSuchElementException e) {
//			findResult = false;
//			System.out.println(
//					"NoSuchElementException:" + elementName + " on xpath:" + listOfByElements.get(elementName));
//			// e.printStackTrace();
//			Thread.sleep(2000);
//		} catch (TimeoutException e) {
//			findResult = false;
//			System.out.println("TimeoutException:" + elementName + " on xpath:" + listOfByElements.get(elementName));
//			// e.printStackTrace();
//			Thread.sleep(2000);
//		} catch (WebDriverException e) {
//			findResult = false;
//			System.out.println("WebDriverException:" + elementName + " on xpath:" + listOfByElements.get(elementName));
//			// e.printStackTrace();
//			Thread.sleep(2000);
//		} catch (Exception e) {
//			findResult = false;
//			System.out.println(e.getClass().getSimpleName() + ": " + elementName + " on xpath:"
//					+ listOfByElements.get(elementName));
//			e.printStackTrace();
//			Thread.sleep(2000);
//		} finally {
//			if (!findResult) {
//				List<WebElement> element = driver.findElements(listOfByElements.get(elementName));
//				JavascriptExecutor executor = (JavascriptExecutor) driver;
//				executor.executeScript("arguments[0].click();", element.get(0));
//				System.out.println(elementName + " on xpath:" + listOfByElements.get(elementName) + "script click()");
//			}
//		}
//
//	}
//
//	public void actionRightClick() {
//		Actions oAction = new Actions(driver);
//		oAction.contextClick().build().perform(); /* this will perform right click */
//	}
//
//	public String actionRead(String elementName) throws ElementNotVisibleException {
//		boolean findResult = false;
//		String value = "NA";
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, 5);
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(listOfByElements.get(elementName)));
//			value = driver.findElement(listOfByElements.get(elementName)).getText().toString();
//			findResult = true;
//
//		} catch (ElementNotVisibleException e) {
//			List<WebElement> element = driver.findElements(listOfByElements.get(elementName));
//			JavascriptExecutor executor = (JavascriptExecutor) driver;
//			value = executor.executeScript("return arguments[0].value", element).toString();
//		}
//		return value;
//	}
//
//	public String actionReadHidden(String elementName, String JSElement)
//			throws ElementNotVisibleException, InterruptedException {
//		boolean findResult = false;
//
//		String value = "NA";
//		// WebDriverWait wait = new WebDriverWait(driver, 5);
//		//// wait.until(ExpectedConditions.visibilityOfElementLocated(listOfByElements.get(elementName)));
//
//		Thread.sleep(2000);
//		List<WebElement> element = driver.findElements(listOfByElements.get(elementName));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		return value = js.executeScript("return document.getElementById('" + JSElement + "').value").toString();
//	}
//
//	public void actionSelect(String selectorName, String elementName) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		WebElement element = driver.findElement(listOfByElements.get(selectorName));
//		element.click();
//		Thread.sleep(2000);
//		element = driver.findElement(listOfByElements.get(elementName));
//		element.click();
//	}
//
//	public void actionSelectCombo(String selectorName, String elementName) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		WebElement element = driver.findElement(listOfByElements.get(selectorName));
//		element.click();
//		Thread.sleep(2000);
//		element.sendKeys(Keys.DOWN, Keys.RETURN);// element = driver.findElement(listOfByElements.get(elementName));
//		// element.click();
//	}
//
//	public boolean actionIsClickable(String elementName) {
//		try {
//			WebElement element = driver.findElement(listOfByElements.get(elementName));
//			WebDriverWait wait = new WebDriverWait(driver, 6);
//			// wait.until(ExpectedConditions.elementToBeClickable(element));
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
//
//	public void actionSendKey(String elementName, String value)
//			throws NoSuchElementException, InterruptedException, SQLException, TimeoutException {
//		boolean findResult = false;
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		try {
//
//			WebElement element = driver.findElement(listOfByElements.get(elementName));
//			element.click();
//			element.sendKeys(value);
//			findResult = true;
//			System.out.println(elementName + " on xpath:" + listOfByElements.get(elementName) + "driver sendKey()");
//		} catch (WebDriverException e) {
//			findResult = false;
//			System.err.println(
//					"WebDriverException:" + elementName + " on xpath:" + listOfByElements.get(elementName) + "FAILED");
//			Thread.sleep(2000);
//		} finally {
//			if (!findResult) {
//				WebElement element = driver.findElement(listOfByElements.get(elementName));
//				JavascriptExecutor executor = (JavascriptExecutor) driver;
//				executor.executeScript("arguments[0].sendKeys(arguments[1]);", element, value);
//				System.out.println(elementName + " on xpath:" + listOfByElements.get(elementName) + "script sendKey()");
//			}
//		}
//	}
//
//	public void actionClear(String elementName) {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, 5);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(listOfByElements.get(elementName)));
//			driver.findElement(listOfByElements.get(elementName)).clear();
//		} catch (Exception e) {
//			System.out.println("FIND ELEMENT ERROR: " + elementName + " , " + listOfByElements.get(elementName)
//					+ "\nUSING JAVASCRIPT TO FIND");
//			WebElement element = driver.findElement(listOfByElements.get(elementName));
//			JavascriptExecutor executor = (JavascriptExecutor) driver;
//			executor.executeScript("arguments[0].clear();", element);
//
//		}
//	}
//
//	public WebElement getRandomElementFromContainer(String containerName) {
//		List<WebElement> elements = driver.findElements(listOfByElements.get(containerName));
//
//		Random rand = new Random();
//		int indexOfRandomElement = rand.nextInt(elements.size());
//
//		return elements.get(indexOfRandomElement);
//	}
//
//	public void actionClickAll(String containerOfElements) throws NoSuchElementException, InterruptedException {
//		List<WebElement> elements = driver.findElements(listOfByElements.get(containerOfElements));
//
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		for (WebElement ele : elements) {
//			try {
//				wait.until(ExpectedConditions.elementToBeClickable(ele));
//				ele.click();
//				Thread.sleep(1000);
//				System.out.println("Click on " + ele.getText());
//			} catch (TimeoutException e) {
//				System.out.println("FIND ELEMENT ERROR: " + ele + " , " + (By) ele + "\nUSING JAVASCRIPT TO FIND");
//				WebElement element = driver.findElement((By) ele);
//				JavascriptExecutor executor = (JavascriptExecutor) driver;
//				executor.executeScript("arguments[0].click();", element);
//			}
//		}
//	}
//
//	public void setDriver(WebDriver driver) {
//		this.driver = driver;
//	}
//
//	public void waitForLoad(WebDriver driver) {
//		new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
//				.executeScript("return document.readyState").equals("complete"));
//	}
//
//	public void moveToElementAndClick(String origin, String destani) {
//		Actions action = new Actions(driver);
//		WebElement we = driver.findElement(listOfByElements.get(origin));
//		action.moveToElement(we).moveToElement(driver.findElement(listOfByElements.get(destani))).click().build().perform();
//	}
//
//	public void moveToElementAndClick(String destani) {
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(listOfByElements.get(destani))).click().build().perform();;
//	}
//	/*
//	 * public boolean waitForJStoLoad(WebDriver driver) {
//	 * 
//	 * WebDriverWait wait = new WebDriverWait(driver, 30); // wait for jQuery to
//	 * load // wait for Javascript to load ExpectedCondition<Boolean> jsLoad = new
//	 * ExpectedCondition<Boolean>() { public Boolean apply(WebDriver driver) {
//	 * return executor("return document.readyState") .toString().equals("complete");
//	 * } };
//	 * 
//	 * return //wait.until(jsLoad);
//	 */
//
//	protected Long executor(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/*
//	 * public WebElement fluentWait(final By locator) throws NoSuchElementException
//	 * { Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30,
//	 * TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
//	 * 
//	 * WebElement foo = //wait.until(new Function<WebDriver, WebElement>() { public
//	 * WebElement apply(WebDriver driver) { return driver.findElement(locator); }
//	 * });
//	 * 
//	 * return foo; };
//	 */
//}
//
//// Removed Methods
///*
// * public Money actionReadEuroPrice(String elementName) throws
// * InterruptedException, SQLException{ WebDriverWait wait = new
// * WebDriverWait(driver, 5);
// * //wait.until(ExpectedConditions.visibilityOfElementLocated(listOfByElements.
// * get (elementName))); boolean findResult = false; Money price =
// * Money.euros(new BigDecimal(0));; try{ WebElement ele =
// * fluentWait(listOfByElements.get(elementName)); price = Money.euros(new
// * BigDecimal(ele.getText().toString().replaceAll("[^1-9,]","").replaceAll(",",
// * "."))); findResult = true; return price; } catch(NoSuchElementException e){
// * findResult = false; System.out.println("NoSuchElementException:" +
// * elementName + " on xpath:" + listOfByElements.get(elementName));
// * //e.printStackTrace(); Thread.sleep(2000); } catch(NumberFormatException e){
// * findResult = false; System.out.println("NumberFormatException:" + elementName
// * + " on xpath:" + listOfByElements.get(elementName)); //e.printStackTrace();
// * Thread.sleep(2000); } catch(TimeoutException e){ findResult = false;
// * System.out.println("TimeoutException:" + elementName + " on xpath:" +
// * listOfByElements.get(elementName)); //e.printStackTrace();
// * Thread.sleep(2000); } catch(WebDriverException e){ findResult = false;
// * System.out.println("WebDriverException:" + elementName + " on xpath:" +
// * listOfByElements.get(elementName)); //e.printStackTrace();
// * Thread.sleep(2000); } finally{ System.out.println("findResult value: "+
// * findResult); if(!findResult){ List<WebElement> element =
// * driver.findElements(listOfByElements.get(elementName)); JavascriptExecutor
// * executor = (JavascriptExecutor)driver;
// * executor.executeScript("arguments[0].get().toString();", element.get(0));
// * price = Money.euros(new
// * BigDecimal(element.get(0).getText().toString().replaceAll("[^1-9,]","").
// * replaceAll(",","."))); } } tempRun.setUpStepInfo(elementName + " click()");
// * temporaryRun.insertTemporaryRun(tempRun); return price; }
// */