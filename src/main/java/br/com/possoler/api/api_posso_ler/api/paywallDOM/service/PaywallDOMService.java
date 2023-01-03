package br.com.possoler.api.api_posso_ler.api.paywallDOM.service;

import br.com.possoler.api.api_posso_ler.api.paywallDOM.model.RespondeAiConfigModel;
import br.com.possoler.api.api_posso_ler.api.paywallDOM.model.DataCyModel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaywallDOMService {

    public RespondeAiConfigModel buildRespondeAiConfigs() {

        List<String> blurList = this.factoryDOMClassList(
    "dOUKdM", "blur", "htZGzZ", "blurs",
            "chTkVa", "cKfPcs", "gzzuMX" , "kEWCPZ"
        );
        List<String> unloggedBookBlock = this.factoryDOMClassList(
    "ReactModalPortal",
            "ReactModal__Body--open",
            "NoAccessDisclaimer__Container-sc-6er3z1-0"
        );
        List<String> unloggedExerciseBlock = this.factoryDOMClassList(
    "ReactModalPortal",
            "ReactModal__Body--open",
            "NoAccessDisclaimer__Container-sc-6er3z1-0"
        );
        List<String> unloggedSolutionBlock = this.factoryDOMClassList(
    "exercise-expand-button",
            "exercise-theory-expand-button",
            "button"
        );
        List<String> unloggedBlockedTheory = this.factoryDOMClassList(
    "paywall",
            "theory-container",
            "expand-overlay"
        );
        List<String> unloggedExclusiveContent = this.factoryDOMClassList(
    "login-overlay",
            "main-wrapper"
        );

        DataCyModel dataCy = DataCyModel.builder()
            .format_toggle("content-format-toggle-container")
            .theory_text_content("theory-text-content-container")
            .theory_video_content("theory-video-content-container")
            .exercise_answer_button("exercise-show-answer-button-container")
            .exercise_statement("exercise-statement")
            .side_menu("side-menu-container")
            .build();

        return RespondeAiConfigModel.builder()
            .site_name("Responde Ai")
            .blur_class(blurList)
            .unlogged_remove_book_block(unloggedBookBlock)
            .unlogged_remove_exercise_block(unloggedExerciseBlock)
            .unlogged_remove_show_solution_button(unloggedSolutionBlock)
            .unlogged_remove_block_theory(unloggedBlockedTheory)
            .unlogged_exclusive_content(unloggedExclusiveContent)
            .data_cy(dataCy)
            .paywall_height_size(299)
            .logged_locked_icons("MuiSvgIcon-root")
            .logged_enable_scroll_page("ReactModal__Body--open")
            .logged_react_modal("ReactModal__Overlay")
            .logged_dexter_block("no-access-dexter-wall")
            .build();
    }


    private List<String> factoryDOMClassList(
            String... classes
    ) {
        return Arrays.asList(classes);
    }
}
