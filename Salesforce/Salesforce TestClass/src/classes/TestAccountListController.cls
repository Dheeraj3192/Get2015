@isTest
private class TestAccountListController {
    @testSetUp
    static void testSetUp() {
      AccountSearchUtility.setUpData();
    }
    @isTest
    static void testGetQuery() {
        AccountListController acontroller = new AccountListController();
        acontroller.BillingCntry ='Country 5';
        acontroller.BillingCty='City 4';
        acontroller.BillingStat='State 3';
        Test.startTest();
        acontroller.getAccounts();
        List<Account> aclist =acontroller.results;
        System.debug('acclistis '+aclist);
         Test.stopTest();
        system.assertEquals(aclist.size(),0);
    }
    @isTest
    static void testGetQueryNullObject() {
        AccountListController acontroller = new AccountListController();
         Test.startTest();
        acontroller.getAccounts();
        List<Account> aclist =acontroller.results;
        System.debug('acclistis '+aclist);
        Test.stopTest();
        system.assertEquals(aclist.size(),10);
    }
    
    
    @isTest
    static void testGetQueryBillingCountryNotNull() {
        AccountListController acontroller = new AccountListController();
        acontroller.BillingCntry ='Country';
        Test.startTest();
        acontroller.getAccounts();
        List<Account> aclist =acontroller.results;
        System.debug('acclistis '+aclist);
        Test.stopTest() ;
        system.assertEquals(aclist.size(),10);
    }
    
    @isTest
    static void testGetQueryBillingCityNotNull() {
        AccountListController acontroller = new AccountListController();
        acontroller.BillingCty='City 4';
        Test.startTest() ;
        acontroller.getAccounts();
        List<Account> aclist =acontroller.results;
        System.debug('acclistis '+aclist);
        Test.stopTest();
        system.assertEquals(aclist.size(),1);
    }
    @isTest
    static void testGetQueryBillingStateNotNull() {
        AccountListController acontroller = new AccountListController();
        acontroller.BillingStat='State 3';
        Test.startTest();
        acontroller.getAccounts();
        List<Account> aclist =acontroller.results;
        System.debug('acclistis '+aclist);
        Test.stopTest();
        system.assertEquals(aclist.size(),1);
    }
    @isTest
    static void testGetQueryBillingAllNotNull() {
        AccountListController acontroller = new AccountListController();
        acontroller.BillingCntry ='Country 5';
        acontroller.BillingCty='City 5';
        acontroller.BillingStat='State 5';
        Test.startTest();
        acontroller.getAccounts();
        List<Account> aclist =acontroller.results;
        System.debug('acclistis '+aclist);
        Test.stopTest();
        system.assertEquals(aclist.size(),1);
    }
    
    
    
    
}