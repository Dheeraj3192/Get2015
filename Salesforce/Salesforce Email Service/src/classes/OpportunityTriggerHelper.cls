/** 
* Author: Dheeraj Kumar
* Created Date: 21/01/2016
* Name:  OpportunityTriggerHelper
* Desc: Opportunity trigger apex helper class
*/

public class OpportunityTriggerHelper{ 
    
    public static List<Opportunity> newList = new List<Opportunity>();
    public static List<Opportunity> oldList = new List<Opportunity>();
    public static Map<Id,Opportunity> newMap = new Map<Id,Opportunity>();
    public static Map<Id,Opportunity> oldMap = new Map<Id,Opportunity>();     
    
    /**
*    @param void
*    @return void 
*    @desc populate closed date field with today when stage is closed won or closed lost
*/
    public static void populateClosedDateField() {
        for(Opportunity oppty:newMap.values()) 
            if((oppty.StageName == 'Closed Won' || oppty.StageName == 'Closed Lost') && (oldMap.get(oppty.id).StageName != 'Closed Won'  && oldMap.get(oppty.id).StageName !='Closed Lost'))
            oppty.CloseDate = Date.today();     
    }
    
    /**
*    @param void
*    @return void 
*    @desc delete associate product if custom status is Reset
*/
    public static void deleteAssociatedProduct() {
        Set<Id> setOpporutnityId = new Set<Id>();
        for (Opportunity objOpportunity:newList) 
            if (objOpportunity.Custom_Status__c != null && objOpportunity.Custom_Status__c == 'Reset' && objOpportunity.Custom_Status__c != oldMap.get(objOpportunity.Id).Custom_Status__c) 
            setOpporutnityId.Add(objOpportunity.id);
        
        
        if (setOpporutnityId != null && setOpporutnityId.size() > 0) {
            for(Id ids :  setOpporutnityId ) {
                List<OpportunityLineItem> opportunityLineItemList = [select id from OpportunityLineItem where Opportunity.Id = : ids];
                if(opportunityLineItemList!= null&& opportunityLineItemList.size()>0)
                    delete opportunityLineItemList;
            }
        }
    }
    
    public static void  updateManagerField() {
        
        for(Opportunity op : newList) {
            if(op.BillToContact__c != null && op.Manager__c == null) 
            {
                op.Manager__c =op.BillToContact__r.Account.id;
            }
        }
        
    }
    
    /**
*    @param void
*    @return void 
*    @desc send Mail When Status Change 
*/    
    public static void sendMailWhenStatusChange() {
        Id templateId = [Select id from EmailTemplate where name = 'Oppty Status Change Mail'].Id;
        
        for (Opportunity opp : newList) {
            opportunity oldOpp = oldMap.get(opp.Id);
            if (oldOpp.StageName != opp.StageName) {
                Messaging.SingleEmailMessage mail = new Messaging.SingleEmailMessage();
                mail.setTargetObjectId(opp.OwnerId);
                mail.setTemplateId(templateId);
                mail.setSaveAsActivity(false);
                Messaging.SendEmailResult[] result = Messaging.sendEmail(new Messaging.SingleEmailMessage[] {mail});
            }
        }
    }
}