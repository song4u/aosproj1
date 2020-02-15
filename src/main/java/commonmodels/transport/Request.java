package commonmodels.transport;

import commonmodels.Transportable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.UUID;

public class Request extends Transportable implements Serializable
{

    private String header;
    private String sender;
    private String receiver;
    private String type;
    private String attachment;
    private long timestamp;

    private transient float processTime = .0f;

    private final static long serialVersionUID = -2162237185763801887L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Request() {
        super();
        timestamp = System.currentTimeMillis();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Request withHeader(String header) {
        this.header = header;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Request withSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Request withReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Request withType(String type) {
        this.type = type;
        return this;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Request withAttachment(String attachment) {
        this.attachment = attachment;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Request withTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Request withAttachments(Object... attachments) {
        StringBuilder result = new StringBuilder();
        for (Object str : attachments) {
            result.append(str).append(" ");
        }

        this.attachment = result.toString().trim();
        return this;
    }

    public float getProcessTime() {
        return processTime;
    }

    public void addProcessTime(float processTime) {
        this.processTime += processTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                        .append("        \n").append("header", header)
                        .append("        \n").append("timestamp", timestamp)
                        .append("        \n").append("sender", sender)
                        .append("        \n").append("receiver", receiver)
                        .append("        \n").append("type", type)
                        .append("        \n").append("attachment", attachment)
                        .append("        \n").toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(timestamp).append(sender).append(type).append(receiver).append(attachment).append(header).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Request) == false) {
            return false;
        }
        Request rhs = ((Request) other);
        return new EqualsBuilder().append(timestamp, rhs.timestamp).append(sender, rhs.sender).append(type, rhs.type).append(receiver, rhs.receiver).append(attachment, rhs.attachment).append(header, rhs.header).isEquals();
    }

    public String toCommand() {
        String command = "";

        if (header != null)
            command += header + " ";

        if (receiver != null)
            command += receiver + " ";

        if (attachment != null)
            command +=  attachment + " ";

        return command.trim();
    }
}