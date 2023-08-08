package com.ecotheque.test.projetEco.controller;

import com.ecotheque.test.projetEco.Service.ContactService;
import com.ecotheque.test.projetEco.Service.CoursService;
import com.ecotheque.test.projetEco.Service.UtilisateurService;
import com.ecotheque.test.projetEco.model.Contact;
import com.ecotheque.test.projetEco.model.Cours;
import com.ecotheque.test.projetEco.model.Utilisateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ControllerService {
    private final UtilisateurService utilisateurService;
    private final ContactService contactService;
    private final CoursService coursService;

    public ControllerService(UtilisateurService utilisateurService, ContactService contactService, CoursService coursService) {
        this.utilisateurService = utilisateurService;
        this.contactService = contactService;
        this.coursService = coursService;
    }

    @GetMapping("login")
    public String seconnecter(Model model) {
        model.addAttribute("utilisateur",new Utilisateur());
        return "login";
    }
    @PostMapping("login")
    public String addLivreForm(@ModelAttribute Utilisateur utilisateur) {
        utilisateurService.create(utilisateur);
        return "index";
    }
    @GetMapping("/inscription")
    public String inscription() {

        return "inscription";
    }
    /*CONTACT   */
    @GetMapping("contact")
    public String contact(Model model) {
        model.addAttribute("contact",new Contact());
        return "contact";
    }
    @PostMapping("contact")
    public String addForm(@ModelAttribute Contact contact) {
        contactService.create(contact);
        return "index";
    }
    @GetMapping("list")
    public String Contact(Model model){
        model.addAttribute("contacts",contactService.listeContact());
        return "list";
    }
    @GetMapping("delete/{id}")
    public String deleteContact(@PathVariable(name="id")Long id){
        contactService.deleteById(id);
        return "redirect:/list";
    }
    @GetMapping("update/{id}")
    public String updatecontact(Model model, @PathVariable(name="id")Long id){
        model.addAttribute("contact", contactService.findByID(id));
        return "update";
    }
    @PostMapping("update")
    public String updateLivreForm(@ModelAttribute Contact contact){
        contactService.update(contact,contact.getId());
        return "redirect:/";
    }
    /*CONTACT   */

    @GetMapping("/index")
    public String index() {

        return "index";
    }
    @GetMapping("cours")
    public String cours(Model model) {
        model.addAttribute("cours",new Cours());
        return "cours";
    }
    @PostMapping("cours")
    public String addCours(@ModelAttribute Cours cours) {
       coursService.create(cours);
        return "index";
    }
}
