package cn.wzu.ccw.game.entity;

public class Question {
    private int id;
    private int type; //选择题为1
    private String choice_question;
    private String choice_a;
    private String choice_b;
    private String choice_c;
    private String choice_d;
    private String choice_answer;
    private int choice_category;
    public Question(int type, String choice_question, String choice_a, String choice_b, String choice_c, String choice_d, String choice_answer, int choice_category) {
        this.type = type;
        this.choice_question = choice_question;
        this.choice_a = choice_a;
        this.choice_b = choice_b;
        this.choice_c = choice_c;
        this.choice_d = choice_d;
        this.choice_answer = choice_answer;
        this.choice_category = choice_category;
    }

    public Question() {
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", type=" + type +
                ", choice_question='" + choice_question + '\'' +
                ", choice_a='" + choice_a + '\'' +
                ", choice_b='" + choice_b + '\'' +
                ", choice_c='" + choice_c + '\'' +
                ", choice_d='" + choice_d + '\'' +
                ", choice_answer='" + choice_answer + '\'' +
                ", choice_category=" + choice_category +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getChoice_question() {
        return choice_question;
    }

    public void setChoice_question(String choice_question) {
        this.choice_question = choice_question;
    }

    public String getChoice_a() {
        return choice_a;
    }

    public void setChoice_a(String choice_a) {
        this.choice_a = choice_a;
    }

    public String getChoice_b() {
        return choice_b;
    }

    public void setChoice_b(String choice_b) {
        this.choice_b = choice_b;
    }

    public String getChoice_c() {
        return choice_c;
    }

    public void setChoice_c(String choice_c) {
        this.choice_c = choice_c;
    }

    public String getChoice_d() {
        return choice_d;
    }

    public void setChoice_d(String choice_d) {
        this.choice_d = choice_d;
    }

    public String getChoice_answer() {
        return choice_answer;
    }

    public void setChoice_answer(String choice_answer) {
        this.choice_answer = choice_answer;
    }

    public int getChoice_category() {
        return choice_category;
    }

    public void setChoice_category(int choice_category) {
        this.choice_category = choice_category;
    }

}
