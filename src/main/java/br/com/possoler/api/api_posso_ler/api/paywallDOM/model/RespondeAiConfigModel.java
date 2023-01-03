package br.com.possoler.api.api_posso_ler.api.paywallDOM.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespondeAiConfigModel {
    private String site_name;
    private List<String> blur_class;
    private List<String> unlogged_remove_book_block;
    private List<String> unlogged_remove_exercise_block;
    private List<String> unlogged_remove_show_solution_button;
    private List<String> unlogged_remove_block_theory;
    private List<String> unlogged_exclusive_content;
    private DataCyModel data_cy;
    private Integer paywall_height_size;
    private String logged_locked_icons;
    private String logged_enable_scroll_page;
    private String logged_react_modal;
    private String logged_dexter_block;
}
