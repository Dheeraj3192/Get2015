@isTest
private class TestOrgSobjects {
    
    @isTest(seeAllData = true)
    static void testOrgSobjects() {
        Test.startTest();
        List<Schema.SObjectType> expected = OrgSobjects.getOrganizationSobjects();
        List<Schema.SObjectType> actual = Schema.getGlobalDescribe().Values();
        System.debug('expected'+expected.size());
        System.debug('acutal'+actual.size());
        Test.stopTest();
        System.assertEquals(expected.size(), actual.size());
        
        
    }
    
}