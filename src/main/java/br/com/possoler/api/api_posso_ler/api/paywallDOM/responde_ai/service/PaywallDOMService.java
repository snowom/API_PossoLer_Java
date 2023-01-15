package br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.service;

import br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.constants.*;
import br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.model.RespondeAiConfigModel;
import br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.model.DataCyModel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaywallDOMService {

    public RespondeAiConfigModel buildRespondeAiConfigs() {

        List<String> blurList = this.factoryDOMClassList(
            BlurClasses.CLASS_1.getClassName(),
            BlurClasses.CLASS_2.getClassName(),
            BlurClasses.CLASS_3.getClassName(),
            BlurClasses.CLASS_4.getClassName(),
            BlurClasses.CLASS_5.getClassName(),
            BlurClasses.CLASS_6.getClassName(),
            BlurClasses.CLASS_7.getClassName(),
            BlurClasses.CLASS_8.getClassName()
        );
        List<String> unloggedBookBlock = this.factoryDOMClassList(
            UnloggedBookBlock.CLASS_1.getClassName(),
            UnloggedBookBlock.CLASS_2.getClassName(),
            UnloggedBookBlock.CLASS_3.getClassName()
        );
        List<String> unloggedExerciseBlock = this.factoryDOMClassList(
            UnloggedExerciseBlock.CLASS_1.getClassName(),
            UnloggedExerciseBlock.CLASS_2.getClassName(),
            UnloggedExerciseBlock.CLASS_3.getClassName()
        );
        List<String> unloggedSolutionBlock = this.factoryDOMClassList(
            UnloggedSolutionBlock.CLASS_1.getClassName(),
            UnloggedSolutionBlock.CLASS_2.getClassName(),
            UnloggedSolutionBlock.CLASS_3.getClassName()
        );
        List<String> unloggedBlockedTheory = this.factoryDOMClassList(
            UnloggedBlockedTheory.CLASS_1.getClassName(),
            UnloggedBlockedTheory.CLASS_2.getClassName(),
            UnloggedBlockedTheory.CLASS_3.getClassName()
        );
        List<String> unloggedExclusiveContent = this.factoryDOMClassList(
            UnloggedExclusiveContent.CLASS_1.getClassName(),
            UnloggedExclusiveContent.CLASS_2.getClassName()
        );

        DataCyModel dataCy = DataCyModel.builder()
            .format_toggle(DataCy.FORMAT_TOGGLE.getClassName())
            .theory_text_content(DataCy.THEORY_TEXT_CONTENT.getClassName())
            .theory_video_content(DataCy.THEORY_VIDEO_CONTENT.getClassName())
            .exercise_answer_button(DataCy.EXECISE_ANSWER_BUTTON.getClassName())
            .exercise_statement(DataCy.EXERCISE_STATEMENT.getClassName())
            .side_menu(DataCy.SIDE_MENU.getClassName())
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
