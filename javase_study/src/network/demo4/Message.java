package network.demo4;

/*
 * Message
 */

import java.io.Serializable;

public class Message implements Serializable {
    private String msgFrom;
    private String msgTo;
    private String msgContent;

    public Message(String msgFrom, String msgTo, String msgContent) {
        this.msgFrom = msgFrom;
        this.msgTo = msgTo;
        this.msgContent = msgContent;
    }

    public Message() {

    }

    public String getMsgFrom() {
        return msgFrom;
    }

    public void setMsgFrom(String msgFrom) {
        this.msgFrom = msgFrom;
    }

    public String getMsgTo() {
        return msgTo;
    }

    public void setMsgTo(String msgTo) {
        this.msgTo = msgTo;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgFrom='" + msgFrom + '\'' +
                ", msgTo='" + msgTo + '\'' +
                ", msgContent='" + msgContent + '\'' +
                '}';
    }
}
