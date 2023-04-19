import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.text.SimpleDateFormat as SimpleDateFormat

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://lonenpsdevzl30.ap-storytelling.com/apstorytelling/#/login')

// SSL certificate error Handling "Your connection is not private"
if(WebUI.waitForElementPresent(findTestObject('Page_AP Storytelling Playbook/errorAdvance'), 10, FailureHandling.CONTINUE_ON_FAILURE)) {
	println(' ------------- SSL certificate - Server side issue ------------ ')
	WebUI.click(findTestObject('Page_AP Storytelling Playbook/errorAdvance'))
	WebUI.click(findTestObject('Page_AP Storytelling Playbook/errorProcced'))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_AP Storytelling Playbook/mat-label_Username'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_Username_mat-input-0'))

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_Username_mat-input-0'), 'janedoe1@enps.com')

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/mat-form-field_Passwordvisibility_off'))

WebUI.setText(findTestObject('Object Repository/Page_AP Storytelling Playbook/input_Password_mat-input-1_1'), 'APenps1100')

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_Login'))

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_Login'))

//int d = 20
//WebUI.delay(d)
if (WebUI.waitForElementPresent(findTestObject('Object Repository/Page_AP Storytelling Playbook/span_Playbook'), 1000, FailureHandling.STOP_ON_FAILURE)) {
    println('-- LOGGED IN SUCCESSFULLY --\n\n')
} else {
    println('xxxxxxxxxxxxxxxxxx LOGIN FAILED  xxxxxxxxxxxxxxxxx')

    WebUI.closeBrowser(FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.click(findTestObject('Object Repository/Page_AP Storytelling Playbook/img'))

WebUI.click(findTestObject('Page_AP Storytelling Playbook/span_Notifications'))





if (WebUI.verifyElementPresent(findTestObject('Page_AP Storytelling Playbook/span_Mobile App'), 10) &&  WebUI.verifyElementPresent(findTestObject('Page_AP Storytelling Playbook/span_Text'), 10)) {
    //Get current date time
    LocalDateTime now = LocalDateTime.now()

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern('M-dd-yyyy-_HH-mm-ss')

    String formatDateTime = now.format(formatter)

    String screenshotPath = ('Screenshots/Notifications/Notifications_' + formatDateTime) + '(CST).png'

    println(screenshotPath)

    WebUI.takeScreenshot(screenshotPath)

    println('---------- Notifications Menu SUCCESS ---------- \n\n')
}

WebUI.closeBrowser()

