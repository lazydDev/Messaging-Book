public class Message {

    private String text;
    private String name;
    private int id;

    public Message(String text, String name, int id) {
        this.text = text;
        this.name = name;
        this.id = id;
    }

    public void getDetails() {
        System.out.println("Contact Name : " + name + "\nMessage : " + text + "\nId : " + id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}