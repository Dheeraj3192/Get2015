@isTest
private class TestWorkingDays {
    
    
    @isTest
    static void getWorkingDays() {
        Date startDate = Date.newInstance(2016, 01, 01);
        Date endDate = Date.newInstance(2016, 01, 31);
        Integer actual = WorkingDays.getWorkingDays(startDate, endDate);
        Integer expected = 21;
        System.assertEquals(expected, actual);
    }
    
    @isTest
    static void getWorkingDaysAreSamePositive() {
        Date startDate = Date.newInstance(2016, 01, 01);
        Date endDate = Date.newInstance(2016, 01, 01);
        Integer actual = WorkingDays.getWorkingDays(startDate, endDate);
        Integer expected = 1;
        System.assertEquals(expected, actual);
        
    }
    
    @isTest
    static void getWorkingDaysAreSameNegative() {
        Date startDate = Date.newInstance(2016, 01, 03);
        Date endDate = Date.newInstance(2016, 01, 03);
        Integer actual = WorkingDays.getWorkingDays(startDate, endDate);
        System.debug('actual '+actual);
        Integer expected = 0;
        System.assertEquals(expected, actual);
    }
    
    @isTest
    static void getWorkingDaysDaysAreNullStart() {
        Date startDate =Date.newInstance(2016, 01, 03);
        Date endDate =null;
        Integer actual = WorkingDays.getWorkingDays(startDate, endDate);
        Integer expected = -1;
        System.assertEquals(expected, actual);
    }
    @isTest
    static void getWorkingDaysDaysAreNullEnd() {
        Date startDate = null;
        Date endDate =Date.newInstance(2016, 01, 03);
        Integer actual = WorkingDays.getWorkingDays(startDate, endDate);
        Integer expected = -1;
        System.assertEquals(expected, actual);
    }
    @isTest
    static void getWorkingDaysDaysAreNullBoth() {
        Date startDate =null;
        Date endDate =null;
        Integer actual = WorkingDays.getWorkingDays(startDate, endDate);
        Integer expected = -1;
        System.assertEquals(expected, actual);
    }
    @isTest
    static void getWorkingDaysDaysGreater() {
        Date startDate =Date.newInstance(2016, 01, 31);
        Date endDate =Date.newInstance(2016, 01, 01);
        Integer actual = WorkingDays.getWorkingDays(startDate, endDate);
        Integer expected = -1;
        System.assertEquals(expected, actual);
    }
    @isTest
    static void getWorkingDaysNegative() {
        Date startDate = Date.newInstance(2016, 01, 02);
        Date endDate = Date.newInstance(2016, 01, 04);
        Integer actual = WorkingDays.getWorkingDays(startDate, endDate);
        Integer expected = 01;
        System.assertEquals(expected, actual);
    }
    @isTest
    static void getWorkingDaysNegativeOther() {
        
        Integer actual= WorkingDays.getDayOfWeek(null);
        Integer expected = -1;
        System.assertEquals(expected, actual);
    }
    
    @isTest
    static void getWorkingDaysNegativeo() {
        Date startDate = Date.newInstance(2016, 01, 01);
        Date endDate = Date.newInstance(2016, 01, 30);
        Integer actual = WorkingDays.getWorkingDays(startDate, endDate);
        Integer expected = 21;
        System.assertEquals(expected, actual);
    }
    
    
    
    
    
    
    
    
    
    
    
}