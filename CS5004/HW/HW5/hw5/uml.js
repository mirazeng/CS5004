classDiagram
    direction RL

    class Question{
        <<Interface>>
        +getPrompt() String
        +getAnswer() String
        +answer(String) void
        +isRequired() Boolean
        +copy() Question
    }

    class QuestionnaireImpl{
        -Map~String,Question~ questionMap
        -List~Question~ questions

        +getRequiredQuestions() List~Questions~
        +getResponses() List~String~
        +sort(Comparator~Question~) void
        +fold(BiFunction~Question,R,R~, R) R
        +getOptionalQuestions() List~Question~
        +getQuestion(int) Question
        +addQuestion(String, Question) void
        +removeQuestion(String) void
        +filter(Predicate~Question~) Questionnaire
        +isComplete() Boolean
        +toString() String
        +getQuestion(String) Question

    }

    class Questionnaire{
        <<Interface>>
        +getResponses() List~String~
        +getQuestion(int) Question
        +filter(Predicate~Question~) Questionnaire
        +addQuestion(String, Question) void
        +removeQuestion(String) void
        +getOptionalQuestions() List~Question~
        +toString() String
        +getRequiredQuestions() List~Questions~
        +isComplete() Boolean
        +getQuestion(String) Question
        +sort(Comparator~Question~) void
        +fold(BiFunction~Question,R,R~, R) R
    }

    class Likert{
        -boolean required
        -String answer
        -String prompt

        +getPrompt() String
        +getAnswer() String
        +answer(String) void
        +isRequired() Boolean
        +copy() Question
    }

    class YesNo{
        -boolean required
        -String prompt
        -String answer

        +getPrompt() String
        +getAnswer() String
        +answer(String) void
        +isRequired() Boolean
        +copy() Question
    }

    class ShortAnswer{
        -String prompt
        -boolean required
        -String answer

        +getPrompt() String
        +getAnswer() String
        +answer(String) void
        +isRequired() Boolean
        +copy() Question
    }

    class  LikertResponseOption{
        <<Enumeration>>
        +DISAGREE
        +STRONGLY_AGREE
        +STRONGLY_DISAGREE
        +NEUTRAL
        +AGREE

        -String txt
        -int val

        +getValue() int
        +getText() String
        +values LikertResponseOption[]
        +valueOf(String) LikertResponseOption

    }


    Question "0..*" <--o "1" QuestionnaireImpl : aggregation
    Question <|.. Likert : implements
    Question <|.. YesNo : implements
    Question <|.. ShortAnswer : implements

    QuestionnaireImpl ..|> Questionnaire : implements

    Likert ..> LikertResponseOption : dependency
