@isTest
private class TestAccountHandler {
    
    @isTest
    static void testInsertAccount () {
        String name = 'Test' ;
        Test.startTest() ;
        Account expected = AccountHandler.insertNewAccount(name);
        Account actual = [Select Id , Name from Account where Name ='Test' Limit 1];
        Test.stopTest();
        System.assertEquals(expected, actual);
    }
    
    @isTest
    static void testInsertAccountNegative () {
        String name = null;
        Test.startTest() ;
        Account expected = AccountHandler.insertNewAccount(name);
        Account actual = null;
        Test.stopTest();
        System.assertEquals(expected, actual);
    }
}