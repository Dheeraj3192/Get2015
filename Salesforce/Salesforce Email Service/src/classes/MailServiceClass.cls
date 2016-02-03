/** 
* Author: Dheeraj Kumar
* Created Date: 03/02/2016
* Name:  MailServiceClass
* Desc: Mail service Class for getting attachment in XML format 
*/

global class MailServiceClass implements Messaging.InboundEmailHandler {
    
    
    /**
    *    @param  Messaging.InboundEmail ,  Messaging.InboundEnvelope	
    *    @return  Messaging.InboundEmailResult
    *    @desc  Handle mail and getting xml file form attachment and insert list of contact
    */
    global Messaging.InboundEmailResult handleInboundEmail(Messaging.InboundEmail email, Messaging.InboundEnvelope envelope) {
        Messaging.InboundEmailResult result = new Messaging.InboundEmailResult();
        for (Messaging.Inboundemail.TextAttachment file : email.textAttachments) {
            list<Contact>contactList=new list<Contact>();
            String fileBody = (String)file.body;
            Dom.Document doc = new Dom.Document();
            doc.load(fileBody);
            for(DOM.XMLNode xmlnodeobj:doc.getRootElement().getChildElements()){
                Contact con = new Contact();
                String fName = xmlnodeobj.getChildElement('firstName', null).getText();
                String lName = xmlnodeobj.getChildElement('lastName', null).getText();
                system.debug(fName + ' ' + lName);
                con.FirstName = fName;
                con.LastName = lName;
                contactList.add(con);
                system.debug(contactList);
            }
            if(contactList.size()>0)
            	insert contactList;
            
        }
        
        return result;
    }
}