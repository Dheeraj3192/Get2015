/**
* Author: Dheeraj Kumar	
* Created Date: 20/01/2016
* Name: CustomLookupScreen
* Desc: BillToContact using Custom LookUp (List show Contacts related to that Manager Field) in Opportunity object
*/

public class CustomLookupScreen {
    
    
    public Opportunity opportunity{get;set;}
    public Id contactId{get;set;}
    public List<Contact> contactList{get;set;}
    
    // The extension constructor initializes the private member
    // variable acct by using the getRecord method from the standard
    // controller.
    public CustomLookupScreen(ApexPages.StandardController stdController) {
        this.opportunity = (Opportunity)stdController.getRecord();
        Opportunity opportunityObject=this.opportunity;
        this.contactList=[SELECT ID,Name FROM Contact where Contact.AccountID=:opportunityObject.Manager__c];
        
    }
    
    /**
*    @param  void
*    @return List<SelectOption>  are the option list
*    @desc get options(all related contacts) for manager
*/
    public List<SelectOption> getItems(){
        List<SelectOption> options=new List<SelectOption>();
        for(Contact contact:contactList)
            options.add(new SelectOption(contact.Id,contact.Name));
        return options;
    }
    
    /**
*    @param  void
*    @return void
*    @desc setting the manager field by contactid
*/
    public void setManager(){
        Opportunity opportunityObject = this.opportunity;
        opportunityObject.BillToContact__c = this.contactId;
        update opportunityObject;
        
    }
    
    /**
*    @param  void
*    @return void
*    @desc removing the manager field by contactid
*/
    public void clearManager(){
        Opportunity opportunityObject = this.opportunity;
        opportunityObject.BillToContact__c = null;
        update opportunityObject;
        
    }
    
    
    
    
}