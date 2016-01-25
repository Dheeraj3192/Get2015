/**
* Author: Dheeraj Kumar	
* Created Date: 19/01/2016
* Name: AccoutWithPagination
* Desc: Get Account List from the given set of parameter billingcountry ,  billingstate ,billingcity with pagination 
*/
public class AccoutWithPagination {
    public String BillingCty{get;set;} 
    public String BillingCntry{get;set;}
    public String BillingStat{get;set;}
    Public Integer noOfRecords{get; set;}
    Public Integer size{get;set;}	
    
    public ApexPages.StandardSetController setcon {get ; set;}
    
    /**
    *    @param  void 	
    *    @return String  
    *    @desc  Generate appropriate query string
    */
    public String  getQuery() {
        String query ='SELECT Id, Name, BillingCountry,BillingState, BillingCity FROM Account' ;
        String queryCondition ='';
        Integer count=0;
        if(!String.isBlank(BillingCntry)) {
            queryCondition+= 'BillingCountry LIKE \'%'+ BillingCntry + '%\''+' AND ';
            count++;
        }
        
        if(!String.isBlank(BillingStat)) {
            queryCondition+='BillingState LIKE \'%'+ BillingStat+'%\''+' AND ' ;
            count++;
        }
        
        if(!String.isBlank(BillingCty)) {
            queryCondition+='BillingCity LIKE \'%' +BillingCty + '%\''+ ' AND ';
            count++;
        }
        if(count > 0) {
            System.debug(queryCondition);
            queryCondition = queryCondition.trim().removeEnd('AND');
            System.debug(queryCondition);
            query += ' WHERE ' + queryCondition ;
            
        }  
        query +=' LIMIT 100';
        System.debug(query);
        return query;
    }
    
    
    /**
    *    @param  void 
    *    @return void 
    *    @desc get account list which have given parameter billingcountry,billingstate,billingcity are matcheds with pagination 
    */
    public  List<Account>  getAccounts() {
        if(setCon == null)
            return null ;
        return  (List<Account>) setCon.getRecords();
    }
    
    /**
    *    @param  void
    *    @return void 
    *    @desc  Search Accounts with appropriate query 
    */
    public void Search() {
        size = 2	;
        setCon = new ApexPages.StandardSetController(Database.getQueryLocator(getQuery()));
        setCon.setPageSize(size);
        noOfRecords = setCon.getResultSize();
        
    }
    
    /**
    *    @param void 
    *    @return pageReference
    *    @desc  refresh the page
    */
    public pageReference refresh() {
        setCon = null;
        Search();
        setCon.setPageNumber(1);
        return null;
    }
    public Boolean hasNext {
        get {
            return setCon.getHasNext();
        }
        set;
    }
    
    
    public Boolean hasPrevious {
        get {
            return setCon.getHasPrevious();
        }
        set;
    }
    
    public Integer pageNumber {
        get {
            return setCon.getPageNumber();
        }
        set;
    }
    
    /**
    *    @param void 
    *    @return void
    *    @desc  get first page in setCon object
    */
    public void first() {
        setCon.first();
    }
    
    /**
    *    @param void 
    *    @return void
    *    @desc  get last page in setCon object
    */
    public void last() {
        setCon.last();
    }
    
    /**
    *    @param void 
    *    @return void
    *    @desc  get previous page in setCon object
    */
    public void previous() {
        setCon.previous();
    }
    
    /**
    *    @param void 
    *    @return void
    *    @desc  get next page in setCon object
    */
    public void next() {
        setCon.next();
    }
    
}