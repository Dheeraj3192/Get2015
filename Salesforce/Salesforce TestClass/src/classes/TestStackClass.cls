@isTest 
private class TestStackClass {
    private static Stack stak = new stack();
    
    @isTest
    static void testStackPush() {
        stak.push(5);
        stak.push('Dheeraj');
        stak.push(53.8);
        Integer expected = stak.size();
        Integer actual = 3;
        System.assertEquals(expected, actual);
    }
    @isTest
    static void testStackPop() {
        System.debug('size is '+stak.size());
        Object expected = stak.pop();
        Object actual =null;
        System.assertEquals(expected, actual);
        stak.push(5);
        expected = stak.pop();
        actual =5;
        System.assertEquals(expected, actual);
        
    }
    @isTest
    static void testStackPeek() {
        Object expected = stak.peek() ;
        Object actual =null;
        System.assertEquals(expected, actual);
        stak.push(55);
        expected = stak.peek() ;
        actual =55;
        System.assertEquals(expected, actual);
    }
    @isTest
    static void testStackNegative () {
       	stak.push(null);
        Integer expected = stak.size();
        Integer actual = 0;
        System.assertEquals(expected, actual);
        
  }
    
}