@isTest
private class TestGovernerLimitController {
    
    @isTest
    static void test() {
        AccountUtility.createAccounts();
        Test.startTest();
        GovernerLimitsController glimit = new GovernerLimitsController();
        glimit.updateFunction();
        Test.stopTest();
        System.assertEquals(glimit.accountList.size(), 10);
    }
    
}