package module1.message.model;

/**
 * Created by xmitya on 17.10.16.
 */
public class Message {

    private MessagePriority priority;
    private int code;

    public Message() {
    }

    public Message(MessagePriority priority, int code) {
        this.priority = priority;
        this.code = code;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    public void setPriority(MessagePriority priority) {
        this.priority = priority;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{" + priority + ", " + code + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return code == message.code && priority == message.priority;

    }

    @Override
    public int hashCode() {
        int result = priority != null ? priority.hashCode() : 0;
        result = 31 * result + code;
        return result;
    }
}
