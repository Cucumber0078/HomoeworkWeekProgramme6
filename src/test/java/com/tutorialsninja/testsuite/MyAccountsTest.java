package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.MyAcccounts;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;



public class MyAccountsTest extends BaseTest {
    MyAcccounts myAccounts = new MyAcccounts();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccounts.getRegisterText(),"Register Account","Not Matching");

    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccounts.getReturningCustomerText(),"Returning Customer","Not Matching");

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Register");
        myAccounts.fieldRegisterAccountDetails();
        myAccounts.clickOnRadioButton();
        myAccounts.clickOnAgree();
        myAccounts.clickOnContinue();
        Assert.assertEquals(myAccounts.getAccountText(),"Your Account Has Been Created!","Not Matching");
        myAccounts.clickOnCont();
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccounts.getLogOutText(),"Account Logout","Not matching");
        myAccounts.clickOnCont();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Login");
        myAccounts.sendEmailPasswordDetails();
        myAccounts.clickOnSubmit();
        myAccounts.clickOnMyAccounts();
        myAccounts.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccounts.getAccountLogOutText(),"Account Logout","Not matching");
    }
}
