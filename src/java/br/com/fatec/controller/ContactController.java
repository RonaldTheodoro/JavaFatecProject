package br.com.fatec.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.fatec.bean.Contact;


public class ContactController {
    
    public Contact insertContact(Contact contact) {
        contact.setAddress("address");
        return contact;
    }
    
    public Contact alterContact(Contact contact) {
        return contact;
    }
    
    public Contact removeContact(Contact contact) {
        return contact;
    }
    
    public List<Contact> listContact(Contact contact) {
        List<Contact> contacts = new ArrayList();
        return contacts;
    }
}
