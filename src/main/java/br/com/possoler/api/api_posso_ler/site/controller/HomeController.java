package br.com.possoler.api.api_posso_ler.site.controller;

import br.com.possoler.api.api_posso_ler.site.model.*;
import br.com.possoler.api.api_posso_ler.site.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    MenuLateralService menuLateralService;
    @Autowired
    HeadService headService;
    @Autowired
    ConteudosService conteudosService;
    @Autowired
    BlocoDownloadService blocoDownloadService;
    @Autowired
    BlocoSobreService blocoSobreService;
    @Autowired
    BlocoDoacoesService blocoDoacoesService;
    @Autowired
    BlocoPerguntasServices blocoPerguntasServices;
    @Autowired
    BlocoTecnologiaService blocoTecnologiaService;

    @GetMapping("${homepage}")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView();
        MenuLateral menuLateral = menuLateralService.menuLateralFactory("br");
        Head head = headService.headFactory("br");
        Conteudos conteudos = conteudosService.conteudoFactory("");
        BlocoDownload blocoDownload = blocoDownloadService.blocoDownloadFactory("");
        BlocoSobre blocoSobre = blocoSobreService.blocoSobreFactory("");
        BlocoDoacoes blocoDoacoes = blocoDoacoesService.blocoDoacoesFactory("");
        BlocoPerguntasFrequentes blocoPerguntas = blocoPerguntasServices.blocoPerguntasFactory("");
        BlocoTecnologia blocoTecnologias = blocoTecnologiaService.blocoTecnologiaFactory("");


        mv.addObject("menuLateral", menuLateral);
        mv.addObject("head", head);
        mv.addObject("conteudos", conteudos);
        mv.addObject("blocoDownload", blocoDownload);
        mv.addObject("blocoSobre", blocoSobre);
        mv.addObject("blocoDoacoes", blocoDoacoes);
        mv.addObject("blocoPerguntas", blocoPerguntas);
        mv.addObject("blocoTecnologias", blocoTecnologias);
        mv.setViewName("index");
        return mv;
    }
}
