package br.com.possoler.api.api_posso_ler.site.controller;

import br.com.possoler.api.api_posso_ler.site.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    BlocoTutorialService blocoTutorialService;
    @Autowired
    BlocoComentarioService blocoComentarioService;
    @Autowired
    FooterService footerService;
    @Autowired
    GlideScriptService glideScriptService;
    @Autowired
    VersaoExtensaoScriptService versaoExtensaoScriptService;
    @Autowired
    InstrucoesDownloadDeskService instrucoesDownloadDeskService;
    @Autowired
    InstrucoesDownloadMobService instrucoesDownloadMobService;
    @Autowired
    CardChangelogService cardChangelogService;
    @Autowired
    CardChaveAcessoService cardChaveAcessoService;

    @GetMapping("${homepage}")
    public ModelAndView index(Model model) {

        ModelAndView mv = new ModelAndView();
        menuLateralService.menuLateralFactory("", mv);
        headService.headFactory("", mv);
        conteudosService.conteudoFactory("", mv);
        blocoDownloadService.blocoDownloadFactory("", mv);
        blocoSobreService.blocoSobreFactory("", mv);
        blocoDoacoesService.blocoDoacoesFactory("", mv);
        blocoPerguntasServices.blocoPerguntasFactory("", mv);
        blocoTecnologiaService.blocoTecnologiaFactory("", mv);
        blocoTutorialService.blocoTutorialFactory("", mv);
        blocoComentarioService.blocoComentarioFactory("", mv);
        footerService.footerFactory("", mv);
        versaoExtensaoScriptService.versaoExtensaoScriptFactory("", model);
        glideScriptService.factoryElement("", model);
        versaoExtensaoScriptService.factoryElement("", model);
        instrucoesDownloadDeskService.factoryElement("", model);
        instrucoesDownloadMobService.factoryElement("", model);
        cardChangelogService.factoryElement("", model);
        cardChaveAcessoService.factoryElement("", model);

        mv.setViewName("index");
        return mv;
    }
}
