@isTest
private class TestJSONString {
    
    @testSetup
    static void testSetUp() {
        AccountUtility.createAccounts();
    }
    
    @isTest
    static void testJson() {
        JSONString jsonstr = new JSONString() ;
        Test.startTest();
        String expected =jsonstr.jsonData;
        List<Account> accnts = [Select Id , Name from Account];
        System.debug('accnts'+accnts);
        String actual = json.serialize(accnts);
        System.debug('expected '+expected+'\n actual '+actual);
        Test.stopTest();
        System.assertEquals(expected, actual);
    }
    
}