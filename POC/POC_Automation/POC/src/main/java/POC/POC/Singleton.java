package POC.POC;

import java.sql.Timestamp;
import java.util.Date;

import org.joda.time.DateTime;

//import cucumber.api.Scenario;

public class Singleton
{
	   public static Singleton instance = null;

	   /* A private Constructor prevents any other
	    * class from instantiating.
	    */
	   private Singleton() { 
		   
	   }

	   /* Static 'instance' method */
	   public static Singleton getInstance() {
		   if(instance == null)
			   instance = new Singleton();
	      return instance;
	   }

		static String testStartTime				;
		static String testFinishTime			;
		public static String menu				;
		public static String project 			;
		public static String feature 			;
		public static int rowCount				;
		public static String testMenu			; 
		public static String browser    		;
		public static String createdRequest		;
		public int id; 
		
		public static String getCreatedRequest() {
			return createdRequest;
		}

		public static void setCreatedRequest(String createdRequest) {
			Singleton.createdRequest = createdRequest;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public static String getBrowser() {
			return browser;
		}

		public static void setBrowser(String browser) {
			Singleton.browser = browser;
		}

		public static String getTestMenu() {
			return testMenu;
		}

		public static void setTestMenu(String testMenu) {
			Singleton.testMenu = testMenu;
		}


		public int getRowCount() {
			return rowCount;
		}

		public void setRowCount(int rowCount) {
			this.rowCount = rowCount;
		}

		public static String getMenu() {
			return menu;
		}

		public void setMenu(String menu) {
			Singleton.menu = menu;
		}

		public static String getScenario() {
			return scenario;
		}

		public static void setScenario(String scenario) {
			Singleton.scenario = scenario;
		}

		public static String getStep() {
			return step;
		}

		public static void setStep(String step) {
			Singleton.step = step;
		}

		public static String getScreenShot() {
			return screenShot;
		}

		public static void setScreenShot(String screenShot) {
			Singleton.screenShot = screenShot;
		}

		public static String testStatus	; 
		public static String scenario	; 
		public static String step		;
		public static String screenShot ; 

		public static String getTestStartTime() {
			return testStartTime;
		}

		public static void setTestStartTime(String dt) {
			Singleton.testStartTime = dt;
		}

		public static String getTestFinishTime() {
			return testFinishTime;
		}

		public static void setTestFinishTime(String testFinishTime) {
			Singleton.testFinishTime = testFinishTime;
		}

		public static String getProject() {
			return project;
		}

		public static void setProject(String project) {
			Singleton.project = project;
		}

		public String getFeature() {
			return feature;
		}

		public void setFeature(String feature) {
			Singleton.feature = feature;
		}

		public static String getTestStatus() {
			return testStatus;
		}

		public static void setTestStatus(String testStatus) {
			Singleton.testStatus = testStatus;
		}

}