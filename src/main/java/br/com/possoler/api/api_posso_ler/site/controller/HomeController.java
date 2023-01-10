package br.com.possoler.api.api_posso_ler.site.controller;

import br.com.possoler.api.api_posso_ler.site.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
    public ModelAndView index(
        Model model,
        @RequestHeader(name = "language") String langHeader
    ) {

        ModelAndView mv = new ModelAndView();
        menuLateralService.menuLateralFactory(langHeader, mv);
        headService.headFactory(langHeader, mv);
        conteudosService.conteudoFactory(langHeader, mv);
        blocoDownloadService.blocoDownloadFactory(langHeader, mv);
        blocoSobreService.blocoSobreFactory(langHeader, mv);
        blocoDoacoesService.blocoDoacoesFactory(langHeader, mv);
        blocoPerguntasServices.blocoPerguntasFactory(langHeader, mv);
        blocoTecnologiaService.blocoTecnologiaFactory(langHeader, mv);
        blocoTutorialService.blocoTutorialFactory(langHeader, mv);
        blocoComentarioService.blocoComentarioFactory(langHeader, mv);
        footerService.footerFactory(langHeader, mv);
        versaoExtensaoScriptService.versaoExtensaoScriptFactory(langHeader, model);
        glideScriptService.factoryElement(langHeader, model);
        versaoExtensaoScriptService.factoryElement(langHeader, model);
        instrucoesDownloadDeskService.factoryElement(langHeader, model);
        instrucoesDownloadMobService.factoryElement(langHeader, model);
        cardChangelogService.factoryElement(langHeader, model);
        cardChaveAcessoService.factoryElement(langHeader, model);

        mv.setViewName("index");
        return mv;
    }
}
