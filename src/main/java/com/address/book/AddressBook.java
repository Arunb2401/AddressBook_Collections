package com.address.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AddressBook {
    public List<ContactInfo> contactList;

    //Add new contacts to the address book.

    public List<ContactInfo> addContacts(ContactInfo contact) {
        contactList = new ArrayList<>();
        try {
            contactList.add(contact);
            return contactList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactList;
    }

    /*Edit the contact details in address book.
     * Check a first name is match in address book then change details of that person.*/
    public ContactInfo editContacts(List<ContactInfo> contactList, String firstName, String name, String editDetails) {
        try {
            for(ContactInfo contact : contactList){
                if(contact.firstName.equals(name)) {
                    switch (name) {
                        case "firstName":
                            contact.firstName = editDetails;
                            break;
                        case "lastName":
                            contact.lastName = editDetails;
                            break;
                        case "address":
                            contact.address = editDetails;
                            break;
                        case "city":
                            contact.city = editDetails;
                            break;
                        case "state":
                            contact.state = editDetails;
                            break;
                        case "zip":
                            contact.zip = Integer.parseInt(editDetails);
                            break;
                        case "phoneNumber":
                            contact.number = Long.parseLong(editDetails);
                            break;
                        case "email":
                            contact.email = editDetails;
                            break;
                    }
                }
                return contact;
            }
        } catch (Exception e) {
            System.out.println("Detail not found " + e);
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteContacts(boolean contactsList, String firstName) {
        try {
            for (ContactInfo contact : contactList) {
                if (contact.firstName.equals(firstName)) {
                    contactList.remove(contactList.indexOf(contact));
                    System.out.println("Enter first name : " +firstName);
                    break;
                }
            }
            return contactsList;
        } catch (Exception e) {
            System.out.println("Enterd Name was not found :" +e);
            e.printStackTrace();
        }
        return contactsList;
    }
    /*Add Multiple contacts in address book. */
    public List<ContactInfo> addMultipleContactsList(List<ContactInfo> contactDataList) {
        try {
            for (ContactInfo contacts : contactDataList) {
                addContacts(contacts);
            }
            return contactList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactDataList;
    }
    /*Add new address book using HashMap*/
    @SuppressWarnings("null")
	public HashMap<String, List<ContactInfo>> createNewAddAddressBook(String addressBookName) {
        HashMap<String, List<ContactInfo>> addressBookMap = null;
        try {
            addressBookMap.put(addressBookName, new ArrayList<ContactInfo>());
            System.out.println("New Address Book Created with Name : " + addressBookName);
        } catch (Exception e) {
            System.out.println("Invalid name" + e);
            e.printStackTrace();
        }
        return addressBookMap;
    }
}