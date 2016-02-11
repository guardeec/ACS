package pojo.client.admin;


import pojo.GeneralParams;

/**
 * Created by root on 27.10.15.
 */
public class GuestDATA extends GeneralParams {
    private Integer guestId;
    private String guestName;
    private Integer cardId;
    private Long timeStart;
    private Long timeEnd;

    public void setSpecificParams(
            Integer guestId,
            String guestName,
            Integer cardId,
            Long timeStart,
            Long timeEnd
    ) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.cardId = cardId;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Long timeStart) {
        this.timeStart = timeStart;
    }

    public Long getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Long timeEnd) {
        this.timeEnd = timeEnd;
    }
}
