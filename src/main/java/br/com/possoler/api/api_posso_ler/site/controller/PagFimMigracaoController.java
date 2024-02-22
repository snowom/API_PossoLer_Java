package br.com.possoler.api.api_posso_ler.site.controller;

import br.com.possoler.api.api_posso_ler.site.service.PagFimMigracaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PagFimMigracaoController {

    private final PagFimMigracaoService pagFimMigracaoService;

    PagFimMigracaoController(PagFimMigracaoService pagFimMigracaoService) {
        this.pagFimMigracaoService = pagFimMigracaoService;
    }

    @GetMapping("${view.pagfimmigracao}")
    private ModelAndView pagFimMigracao(
            Model model
    ) {
        ModelAndView mv = new ModelAndView();
        pagFimMigracaoService.factoryElement(HomeController.homeLanguage, model);
        mv.setViewName("pagFimMigracao");
        return mv;
    }
}
