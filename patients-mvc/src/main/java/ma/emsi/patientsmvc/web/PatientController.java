package ma.emsi.patientsmvc.web;


import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping("/patientsJson")
    @ResponseBody
    public List<Patient> listePatients(){
        return patientRepository.findAll();
    }

    @GetMapping(path="/index")
    public String index(Model model ,
                           @RequestParam(name="page", defaultValue = "0") int page ,
                           @RequestParam(name="size", defaultValue = "5")  int size ,
                           @RequestParam(name="keyWord", defaultValue = "") String keyWord)
    {
        Page<Patient> pagePatients=patientRepository.findByNameContains(keyWord,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyWord",keyWord);

        //return the patients.html vue in the templates folder
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id, String keyWord, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyWord="+keyWord;
    }

}
