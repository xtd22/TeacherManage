package com.example.teachermanage.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName history
 */
@Data
public class History implements Serializable {
    /**
     * 
     */
    private Integer historyId;

    /**
     * 
     */
    private String historyMessage;

    /**
     * 
     */
    private String historyMoudle;

    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date historyTime;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        History other = (History) that;
        return (this.getHistoryId() == null ? other.getHistoryId() == null : this.getHistoryId().equals(other.getHistoryId()))
            && (this.getHistoryMessage() == null ? other.getHistoryMessage() == null : this.getHistoryMessage().equals(other.getHistoryMessage()))
            && (this.getHistoryMoudle() == null ? other.getHistoryMoudle() == null : this.getHistoryMoudle().equals(other.getHistoryMoudle()))
            && (this.getHistoryTime() == null ? other.getHistoryTime() == null : this.getHistoryTime().equals(other.getHistoryTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHistoryId() == null) ? 0 : getHistoryId().hashCode());
        result = prime * result + ((getHistoryMessage() == null) ? 0 : getHistoryMessage().hashCode());
        result = prime * result + ((getHistoryMoudle() == null) ? 0 : getHistoryMoudle().hashCode());
        result = prime * result + ((getHistoryTime() == null) ? 0 : getHistoryTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", historyId=").append(historyId);
        sb.append(", historyMessage=").append(historyMessage);
        sb.append(", historyMoudle=").append(historyMoudle);
        sb.append(", historyTime=").append(historyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}