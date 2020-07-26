package de.travelbuddy.controller.v1.api;

import de.travelbuddy.controller.v1.api.exceptions.ContactDetailsNotFoundAPIException;
import de.travelbuddy.model.ContactDetails;
import de.travelbuddy.storage.repositories.IGenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/contacts")
public class ContactDetailsController {

    IGenericRepo<ContactDetails> repo;

    @Autowired
    public ContactDetailsController(IGenericRepo<ContactDetails> repo) {
        this.repo = repo;
        this.repo.setType(ContactDetails.class);
    }

    private ContactDetails fetchContactDetails(Long contactId) {
        ContactDetails cd = repo.read(contactId);

        if (cd == null)
            throw new ContactDetailsNotFoundAPIException();

        return cd;
    }

    //<editor-fold desc="CRUD">
    //###################
    //##### CREATE ######
    //###################
    /*
        No creation of ContactDetails at this point!
        ContactDetails are only created, during the creation off the parent object!
     */

    //###################
    //###### READ #######
    //###################
    @GetMapping("/{contactId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ContactDetails getContactDetails(@PathVariable Long contactId) throws ContactDetailsNotFoundAPIException {
        return fetchContactDetails(contactId);
    }

    //###################
    //##### UPDATE ######
    //###################
    @PutMapping("/{contactId}")
    @ResponseStatus(code = HttpStatus.OK)
    public ContactDetails updateContactDetails(@PathVariable Long contactId, @RequestBody ContactDetails ContactDetails) throws ContactDetailsNotFoundAPIException {
        //Check if exist
        fetchContactDetails(contactId);

        return repo.save(ContactDetails);
    }

    //###################
    //##### DELETE ######
    //###################
    /*
        No deletion of ContactDetails at this point!
        ContactDetails are only deleted, during the deletion off the parent object!
     */
    //</editor-fold>

}
