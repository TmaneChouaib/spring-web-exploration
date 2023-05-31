package ma.emsi.patientsmvc.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;


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

        //retuun the patients.html vue in the templates folder
        return "patients";
    }

    @GetMapping("/deletePatients")
    public String deletePatients(Long id, String keyWord, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyWord="+keyWord;
    }

    @GetMapping("/addPatients")
    public String addPatients(Model model){
        model.addAttribute("patient",new Patient());
        return "addPatients";
    }

    @PostMapping(path="/savePatients")
    public String savePatients(Model mode,
                               @Valid Patient patient ,
                               BindingResult bindingResult ,
                               @RequestParam (defaultValue = "0") int page ,
                               @RequestParam (defaultValue = "") String keyWord){
        if(bindingResult.hasErrors())
            return "addPatients";
        patientRepository.save(patient);
        return "redirect:/index?page="+page+"&keyWord="+keyWord;
    }

    @GetMapping("/editPatients")
    public String editPatients(Model model ,Long id ,String keyWord ,int page){
        Patient patient=patientRepository.findById(id).orElse(null);
        if(patient==null) throw new RuntimeException("Patient cannot be find");
        model.addAttribute("patient",patient);
        model.addAttribute("page",page);
        model.addAttribute("keyWord",keyWord);
        return "editPatients";
    }
}
