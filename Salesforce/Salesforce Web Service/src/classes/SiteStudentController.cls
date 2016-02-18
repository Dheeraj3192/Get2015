public with sharing class SiteStudentController {
   public String selectedStdId{get;set;}
   Public Student__c student{get;set;}
   public boolean show{get;set;}
   
   
    public SiteStudentController(){show = false;}
          public List<SelectOption> getStudentNames() 
          {     
                 List<SelectOption> accOptions= new List<SelectOption>();
                 accOptions.add( new SelectOption('','--Select--',true));
                 for( Student__c std : [select Id,name from Student__c ] ) {
                         accOptions.add( new SelectOption(std.Id,std.name));
                 }
                return accOptions;
          }
    
      public void studentDetail()
      {    System.debug('vselectedStdId '+selectedStdId);
          show =true;
          System.debug('hii '+show);
          student = [SELECT Name,Email__c,Sex__c ,Age__c,Class__r.Name ,First_Name__c,Last_Name__c, DOB__C FROM Student__c WHERE Id = :selectedStdId LIMIT 1] ;
                   
      }
    
   }