/**
* Author: Dheeraj Kumar	
* Created Date: 15/02/2016
* Name: RestWebServiceContact
* Desc: Rest API for Contact Object 
*/
@RestResource(urlMapping ='/getcontacts')
global with sharing  class RestWebServiceContact {
         /**
*    @param void
*    @return void 
*    @desc Get Contact By Getting Name
*/
    @HttpGet
    global static void getContactByName() {
        RestRequest req = RestContext.request;
        String contactName = req.params.get('name');
        contact contactList = new contact();
        String returnData = '';
        if(contactName!=null) {
            try {
                String query = 'select id , name from contact where Name=:contactName Limit 1' ;
                contactList = Database.query(query);
                returnData = json.serialize(contactlist);
            } catch(Exception e) {
                returnData ='Exception occured '+e.getMessage();
            }
        }
        System.debug('Return Data is'+returnData);
        RestContext.response.responseBody = Blob.valueOf(returnData);
    } 
}