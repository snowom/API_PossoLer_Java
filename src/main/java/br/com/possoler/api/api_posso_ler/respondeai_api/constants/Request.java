package br.com.possoler.api.api_posso_ler.respondeai_api.constants;

import lombok.Getter;

public abstract class Request {
    public final static String DOMAIN_REQUEST = "https://content.respondeai.com.br";
    public final static String BOOK_EXERCISE_ENDPOINT_REQUEST = "/api/v2/books/bookExercise/";

    public final static String THEORY_ENDPOINT = "/graphql";
    public final static String THEORY_OPERATION_NAME = "theory";
    public final static String THEORY_QUERY = "query theory($id: ID!) {theory(id: $id){id lightBody videos{ provider providerId __typename}__typename}}";

    public final static String FIXATION_EXERCISE_OPERATION_NAME = "exercise";
    public final static String FIXATION_EXERCISE_QUERY = "query exercise($id: ID!) {exercise(id: $id) {id lightSolution videos {id provider providerId __typename} __typename}}";

    public final static String LIST_EXERCISE_OPERATION_NAME = "listExercise";
    public final static String LIST_EXERCISE_OPERATION_QUERY = "query listExercise($id: ID!) {listExercise(id: $id) {id lightSolution videos {id provider providerId __typename} __typename}}";

    public enum Operation {

        BOOK_EXERCISE("getBookExercise"),
        THEORY("getTheory"),
        FIXATION_EXERCISE("getFixationExercise"),
        LIST_EXERCISE("getListExercise");

        @Getter
        private final String operationValue;

        Operation(String operationValue){
            this.operationValue = operationValue;
        }
    }
}

