package br.com.possoler.api.api_posso_ler.site.controller;

import br.com.possoler.api.api_posso_ler.site.service.*;
import br.com.possoler.api.api_posso_ler.site.utils.LanguageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "*")
@Controller
public class HomeController {

    private final MenuLateralService menuLateralService;
    private final HeadService headService;
    private final ConteudosService conteudosService;
    private final BlocoDownloadService blocoDownloadService;
    private final BlocoSobreService blocoSobreService;
    private final BlocoDoacoesService blocoDoacoesService;
    private final BlocoPerguntasServices blocoPerguntasServices;
    private final BlocoTecnologiaService blocoTecnologiaService;
    private final BlocoTutorialService blocoTutorialService;
    private final BlocoComentarioService blocoComentarioService;
    private final FooterService footerService;
    private final GlideScriptService glideScriptService;
    private final VersaoExtensaoScriptService versaoExtensaoScriptService;
    private final InstrucoesDownloadDeskService instrucoesDownloadDeskService;
    private final InstrucoesDownloadMobService instrucoesDownloadMobService;
    private final CardChangelogService cardChangelogService;
    private final CardChaveAcessoService cardChaveAcessoService;
    private final LanguageUtils languageUtils;

    HomeController(
        MenuLateralService menuLateralService,
        HeadService headService,
        ConteudosService conteudosService,
        BlocoDownloadService blocoDownloadService,
        BlocoSobreService blocoSobreService,
        BlocoDoacoesService blocoDoacoesService,
        BlocoPerguntasServices blocoPerguntasServices,
        BlocoTecnologiaService blocoTecnologiaService,
        BlocoTutorialService blocoTutorialService,
        BlocoComentarioService blocoComentarioService,
        FooterService footerService,
        GlideScriptService glideScriptService,
        VersaoExtensaoScriptService versaoExtensaoScriptService,
        InstrucoesDownloadDeskService instrucoesDownloadDeskService,
        InstrucoesDownloadMobService instrucoesDownloadMobService,
        CardChangelogService cardChangelogService,
        CardChaveAcessoService cardChaveAcessoService,
        LanguageUtils languageUtils
    ) {
        this.menuLateralService = menuLateralService;
        this.headService = headService;
        this.conteudosService = conteudosService;
        this.blocoDownloadService = blocoDownloadService;
        this.blocoSobreService = blocoSobreService;
        this.blocoDoacoesService = blocoDoacoesService;
        this.blocoPerguntasServices = blocoPerguntasServices;
        this.blocoTecnologiaService = blocoTecnologiaService;
        this.blocoTutorialService = blocoTutorialService;
        this.blocoComentarioService = blocoComentarioService;
        this.footerService = footerService;
        this.glideScriptService = glideScriptService;
        this.versaoExtensaoScriptService = versaoExtensaoScriptService;
        this.instrucoesDownloadDeskService = instrucoesDownloadDeskService;
        this.instrucoesDownloadMobService = instrucoesDownloadMobService;
        this.cardChangelogService = cardChangelogService;
        this.cardChaveAcessoService = cardChaveAcessoService;
        this.languageUtils = languageUtils;
    }

    public static String homeLanguage;

    @GetMapping("${view.homepage}")
    public ModelAndView indexGet(
        Model model,
        String language
    ) {
        ModelAndView mv = new ModelAndView();
        homeLanguage = languageUtils.preventNullLanguage(language);
        menuLateralService.menuLateralFactory(homeLanguage, mv);
        headService.headFactory(homeLanguage, mv);
        conteudosService.conteudoFactory(homeLanguage, mv);
        blocoDownloadService.blocoDownloadFactory(homeLanguage, mv);
        blocoSobreService.blocoSobreFactory(homeLanguage, mv);
        blocoDoacoesService.blocoDoacoesFactory(homeLanguage, mv);
        blocoPerguntasServices.blocoPerguntasFactory(homeLanguage, mv);
        blocoTecnologiaService.blocoTecnologiaFactory(homeLanguage, mv);
        blocoTutorialService.blocoTutorialFactory(homeLanguage, mv);
        blocoComentarioService.blocoComentarioFactory(homeLanguage, mv);
        footerService.footerFactory(homeLanguage, mv);
        versaoExtensaoScriptService.factoryElement(homeLanguage, model);
        glideScriptService.factoryElement(homeLanguage, model);
        instrucoesDownloadDeskService.factoryElement(homeLanguage, model);
        instrucoesDownloadMobService.factoryElement(homeLanguage, model);
        cardChangelogService.factoryElement(homeLanguage, model);
        cardChaveAcessoService.factoryElement(homeLanguage, model);

        mv.setViewName("index");
        return mv;
    }

    @PostMapping("${view.homepage}")
    public ModelAndView indexPost(
            Model model,
            String language
    ) {
        ModelAndView mv = new ModelAndView();
        homeLanguage = languageUtils.preventNullLanguage(language);
        menuLateralService.menuLateralFactory(homeLanguage, mv);
        headService.headFactory(homeLanguage, mv);
        conteudosService.conteudoFactory(homeLanguage, mv);
        blocoDownloadService.blocoDownloadFactory(homeLanguage, mv);
        blocoSobreService.blocoSobreFactory(homeLanguage, mv);
        blocoDoacoesService.blocoDoacoesFactory(homeLanguage, mv);
        blocoPerguntasServices.blocoPerguntasFactory(homeLanguage, mv);
        blocoTecnologiaService.blocoTecnologiaFactory(homeLanguage, mv);
        blocoTutorialService.blocoTutorialFactory(homeLanguage, mv);
        blocoComentarioService.blocoComentarioFactory(homeLanguage, mv);
        footerService.footerFactory(homeLanguage, mv);
        versaoExtensaoScriptService.factoryElement(homeLanguage, model);
        glideScriptService.factoryElement(homeLanguage, model);
        instrucoesDownloadDeskService.factoryElement(homeLanguage, model);
        instrucoesDownloadMobService.factoryElement(homeLanguage, model);
        cardChangelogService.factoryElement(homeLanguage, model);
        cardChaveAcessoService.factoryElement(homeLanguage, model);

        mv.setViewName("index");
        return mv;
    }
}
